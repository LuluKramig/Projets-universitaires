using ButopiaMysteries.Logic;
using Microsoft.VisualBasic;
using System.Security.Policy;
using System.Windows.Forms;
using System.Xml.Linq;

namespace ButopiaMysteries.GraphicsUserInterface
{
    /// <summary>
    /// A window tha allows to select/create mysteries/characters.
    /// </summary>
    public partial class CharacterSelect : Form
    {
        private Roster Roster { get; init; }
        private Point referencePoint = Point.Empty;
        private readonly List<CharacterView> views = [];
        Rules rule = Rules.None;
        private bool moving;
        private CharacterView? selectedView;
        private Point selectedViewStart = Point.Empty;
        private Point mouseOffset = Point.Empty;
        private Dictionary<Rectangle, string> rectangle1 = new Dictionary<Rectangle, string>();
        /// <summary>
        /// Empty constructor.
        /// </summary>
        public CharacterSelect(int nombrePersonnage)
        {
            InitializeComponent();
            // Very first try: create a character, put it in the roster, associate it to the button
            Roster = new();
            MysterySheet charOne = new(Names.RandomName);
            charOne.RandomGeneration(rule);
            Roster.Sheets.Add(charOne.Name, charOne);
            referencePoint = new(10, 10);
            CreateCharacterViews();
            for (int i = 1; i < nombrePersonnage; i++)
            {
                do { charOne = new(Names.RandomName); }
                while (Roster.Sheets.ContainsKey(charOne.Name));
                charOne.RandomGeneration(rule);
                Roster.Sheets.Add(charOne.Name, charOne);
                AddOneNewCharacterView(charOne);
            }
            rectangle1.Add(new Rectangle(625, 85, 150, 50), "Salle d'auto-évaluation");
            rectangle1.Add(new Rectangle(625, 200, 150, 50), "Salle d'examen");
            rectangle1.Add(new Rectangle(625, 315, 150, 50), "Salle d'entraînement");
            label1.ForeColor = Premenu.ColorDiag;
            label2.ForeColor = Premenu.ColorDiag;
            label3.ForeColor = Premenu.ColorDiag;

        }

        /// <summary>
        /// Displays the sheet view as a new form with a given name
        /// </summary>
        /// <param name="text">the name of the character whose sheet will be shown</param>
        private void ShowSheetViewFor(string text)
        {
            new SheetView(Roster.Sheets[text]).ShowDialog();
        }
        /// <summary>
        /// When painting, draws every view
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void CharacterSelect_Paint(object sender, PaintEventArgs e)
        {
            foreach (CharacterView view in views)
            {
                view.Draw(e.Graphics);
            }

            foreach (Rectangle rectangle in rectangle1.Keys)
            {
                e.Graphics.DrawRectangle(Pens.BlueViolet, rectangle);
            }
        }
        /// <summary>
        /// Creates all the views for the sheets in the roster,
        /// used once at creation
        /// </summary>
        private void CreateCharacterViews()
        {
            views.Clear();
            int x = referencePoint.X;
            int y = referencePoint.Y + ViewSettings.DefaultPawnSide;
            foreach (string name in Roster.Sheets.Keys)
            {
                views.Add(new CharacterView(Roster.Sheets[name], new Point(x, y)));
                if (y + ViewSettings.DefaultPawnSide + ViewSettings.DefaultPawnFrame.Height > this.Size.Height)
                {
                    x += ViewSettings.DefaultPawnFrame.Width;
                    y = 10;
                }
                else
                {
                    y += ViewSettings.DefaultPawnFrame.Height;
                }
            }
            referencePoint = new(x, y);
        }
        /// <summary>
        /// Creates a view with the given sheet,
        /// updates the reference point
        /// and manages the space given for creation
        /// </summary>
        /// <param name="sheet">the sheet to create a view for</param>
        private void AddOneNewCharacterView(MysterySheet sheet)
        {
            views.Add(new CharacterView(sheet, new Point(referencePoint.X, referencePoint.Y + ViewSettings.DefaultPawnSide)));
            if (referencePoint.Y + 2 * ViewSettings.DefaultPawnSide + 2 * ViewSettings.DefaultPawnFrame.Height > this.Size.Height)
            {
                referencePoint = new Point(referencePoint.X + ViewSettings.DefaultPawnSide + ViewSettings.DefaultPawnFrame.Width, 10);
            }
            else
            {
                referencePoint = new Point(referencePoint.X, referencePoint.Y + ViewSettings.DefaultPawnSide + ViewSettings.DefaultPawnFrame.Height);
            }
            if (Roster.Sheets.Count >= 15)
            {
                createButton.Enabled = false;
            }
            Refresh();
        }
        /// <summary>
        /// When the create button is clicked, call to execute the character creation process
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void CreateButton_Click(object sender, EventArgs e)
        {
            // CreateRandom();
            CreationDialog();
        }
        /// <summary>
        /// Opens the dialog to create a new character and creates it
        /// </summary>
        private void CreationDialog()
        {
            NewCharacterDialog dialog = new();
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                rule = (dialog.RandomGeneration ? Rules.None : Rules.Fixed);
                CreateRandomWithName(dialog.CharacterName);
                Refresh();
            }
        }

        private void CreateRandom()
        {
            string name = Names.RandomName;
            CreateRandomWithName(name);
        }
        /// <summary>
        /// Creates a new sheet, with a given name, and following the rule as it is, 
        /// then adds the view corresponding to it
        /// </summary>
        /// <param name="name">the name of the created character</param>
        private void CreateRandomWithName(string name)
        {
            if (Roster.Sheets.ContainsKey(name))
            {
                MessageBox.Show("Erreur : " + name + " déjà présent !");
            }
            else
            {
                MysterySheet sheet = new(name);
                sheet.RandomGeneration(rule);
                Roster.Sheets.Add(sheet.Name, sheet);
                AddOneNewCharacterView(sheet);
            }
        }
        /// <summary>
        /// Quits the form if QuitButton is clicked
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void QuitButton_Click(object sender, EventArgs e)
        {
            Dispose();
        }
        /// <summary>
        /// When there is a mouse click, 
        /// display the sheet of the clicked view if it's a left click, 
        /// removes the clicked view if it's a right click
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void CharacterSelect_MouseDown(object sender, MouseEventArgs e)
        {
            foreach (CharacterView view in views)
            {
                if (view.Contains(e.Location))
                {
                    if (e.Button == MouseButtons.Left)
                    {
                        selectedView = SelectView(e.Location);
                        
                        if (selectedView != null)
                        {
                            selectedViewStart = selectedView.location;
                            moving = true;
                            mouseOffset = new Point(e.X -  selectedViewStart.X, e.Y - selectedViewStart.Y);
                        }
                    }
                    else if (e.Button == MouseButtons.Right)
                    {
                        ContextMenuStrip cm = new ContextMenuStrip();
                        ToolStripMenuItem toolViewSheet = new ToolStripMenuItem("Afficher la fiche");
                        ToolStripMenuItem toolDel = new ToolStripMenuItem("Supprimer");
                        toolViewSheet.Click += (s, args) =>
                        {
                            ShowSheetViewFor(view.Sheet.Name);
                        };
                        toolDel.Click += (s, args) =>
                        {
                            if (new OkDialog(view.Sheet.Name).ShowDialog() == DialogResult.OK)
                            {
                                SupprimerView(view);
                            }
                        };
                        cm.Items.Add(toolViewSheet);
                        cm.Items.Add(toolDel);
                        cm.Show(new Point(e.Location.X + this.Location.X, e.Location.Y + this.Location.Y));
                    }
                }
            }
        }
        /// <summary>
        /// Deletes a view and the associated sheet from the app and recreates some to match he correct view display
        /// </summary>
        /// <param name="view">the view to delete</param>
        private void SupprimerView(CharacterView view)
        {
            int indice = views.IndexOf(view);
            referencePoint = new Point(view.location.X, view.location.Y - ViewSettings.DefaultPawnSide);
            views.Remove(view);
            Roster.Sheets.Remove(view.Sheet.Name);
            foreach (CharacterView view2 in views.Slice(indice, views.Count - indice))
            {
                AddOneNewCharacterView(view2.Sheet);
                views.Remove(view2);
            }
            Refresh();
        }

        /// <summary>
        /// MouseMove event handler, used to move views.
        /// </summary>
        /// <param name="sender">(ignored)</param>
        /// <param name="e">used for pointer location</param>
        private void CharacterSelect_MouseMove(object sender, MouseEventArgs e)
        {
            if (moving && selectedView != null)
            {
                selectedView.location.X = e.X - mouseOffset.X;
                selectedView.location.Y = e.Y - mouseOffset.Y;
                Refresh();
            }
        }
        /// <summary>
        /// MouseUp event handler, used for ending movements and launching trials
        /// </summary>
        /// <param name="sender">(ignored)</param>
        /// <param name="e">used for pointer location</param>
        private void CharacterSelect_MouseUp(object sender, MouseEventArgs e)
        {
            if (moving && selectedView != null)
            {
                Rectangle? rect = FindRectangle(e.Location);
                if (rect != null)
                {
                    Rectangle rectTemp = rect.Value;
                    if (comboBoxSkill.Text != "Compétence")
                    {
                        if (rectangle1[rectTemp] == "Salle d'auto-évaluation")
                        {
                            TrialDisplay dialog = new(selectedView.Sheet, Skill_Operations.Name_Invert(comboBoxSkill.Text), null);
                            dialog.ShowDialog();
                        }
                        else if (comboBoxDiff.Text != "Difficulté" && rectangle1[rectTemp] == "Salle d'examen")
                        {
                            TrialDisplay dialog = new(selectedView.Sheet, Skill_Operations.Name_Invert(comboBoxSkill.Text), Trial.Name(comboBoxDiff.Text));
                            dialog.ShowDialog();
                        }
                    }
                    if (rectangle1[rectTemp] == "Salle d'entraînement")
                    {
                        TrainingRoomDialog dialog = new(selectedView.Sheet);
                        dialog.ShowDialog();
                    }



                }
                moving = false;
                selectedView.location = selectedViewStart;
                selectedViewStart = Point.Empty;
                selectedView = null;
                Refresh();
            }
        }
        /// <summary>
        /// Finds the rectangle containing the cursor, null if none
        /// </summary>
        /// <param name="location"></param>
        /// <returns></returns>
        private Rectangle? FindRectangle(Point location)
        {
            Rectangle? rectangle = null;
            foreach (Rectangle rect in rectangle1.Keys)
            {
                if (rect.Contains(location))
                {
                    rectangle = rect;
                }
            }
            return rectangle;
        }
        /// <summary>
        /// Select method for views.
        /// </summary>
        /// <param name="point">a point</param>
        /// <returns>the first view found, if any, null otherwise</returns>
        private CharacterView? SelectView(Point point)
        {
            CharacterView? view = null;
            int i = views.Count - 1;
            while (view == null && i >= 0)
            {
                if (views[i].Contains(point))
                {
                    view = views[i];
                }
                else
                {
                    i--;
                }
            }
            return view;
        }
        /// <summary>
        /// Sets the colour of the backgrounds from the settings
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void CharacterSelect_Load(object sender, EventArgs e)
        {
            BackColor = ViewSettings.DefaultBackgroundColor;
        }


    }
}
