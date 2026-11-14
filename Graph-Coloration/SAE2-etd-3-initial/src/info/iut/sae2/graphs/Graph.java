package info.iut.sae2.graphs;

import info.iut.sae2.algorithm.FiveColorationPlanarAlgorithm;
import info.iut.sae2.algorithm.SixColorationPlanarAlgorithm;
import info.iut.sae2.algorithm.WelshAndPowell;
import info.iut.sae2.properties.ColorProperty;
import info.iut.sae2.properties.LayoutProperty;
import info.iut.sae2.properties.SizeProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/**
 * Class Graph
 */
public class Graph implements IGraph { 
    /**
     * Set of Nodes
     */
    private ArrayList<INode> nodeSet;
    /**
     * Set of edges
     */
    private ArrayList<IEdge> edgeSet;
    /**
     * True if the graph is oriented false otherwise
     */
    private boolean oriented;
    
    private LayoutProperty layoutProperty = new LayoutProperty();

    private SizeProperty sizeProperty = new SizeProperty();

    private ColorProperty colorProperty = new ColorProperty();

    /**
     * An empty constructor for Graph
     */
    public Graph(){
        this.nodeSet = new ArrayList<>();
        this.edgeSet = new ArrayList<>();
        this.oriented= false;
    }
    /**
     * An simple constructor for Graph
     * @param nodes A set of nodes.
     * @param edges A set of edges.
     * @param oriented True if the graph is oriented false otherwise.
     */
    public Graph(ArrayList<INode> nodes, ArrayList<IEdge> edges, boolean oriented){
        this.nodeSet = nodes;
        this.edgeSet = edges;
        this.oriented=oriented;
    }
    /**
     * Instanciates an IGraph.
     * This method is used to create a new empty graph of the same
     * specific type as the target object
     *
     * @return the new IGraph
     */
    @Override
    public IGraph createGraph(){
        return new Graph();
    }

    
    /**
     * Instanciates an IGraph.
     * This method is used to create a new copy graph of the same
     * specific type as the target object
     *
     * @return the new copy
     */
    @Override
    public IGraph copy(){return new Graph(new ArrayList<>(getNodeSet()), new ArrayList<>(getEdgeSet()), isOriented());}

    /**
     * Adds a new empty node to the graph and returns it.
     *
     * @return the added node
     */
    @Override
    public INode addNode(){
        Node node = new Node();
        layoutProperty.setNodeValue(node, LayoutProperty.DEFAULT_NODE_POS);
        sizeProperty.setNodeValue(node, SizeProperty.DEFAULT_NODE_SIZE);
        colorProperty.setNodeValue(node, ColorProperty.DEFAULT_NODE_COL);
        nodeSet.add(node);
        return node;
    }

    /**
     * Adds a given node to the graph and returns it.
     *
     * @param n the node to add in the graph
     * @return the added node
     */
    @Override
    public INode addNode(INode n){
        layoutProperty.setNodeValue(n, LayoutProperty.DEFAULT_NODE_POS);
        sizeProperty.setNodeValue(n, SizeProperty.DEFAULT_NODE_SIZE);
        colorProperty.setNodeValue(n, ColorProperty.DEFAULT_NODE_COL);
        nodeSet.add(n);
        return n;
    }

    /**
     * Adds a given edge and returns an edge to the graph and returns it.
     *
     * @param e the edge to add
     * @return the added edge
     */
    @Override
    public IEdge addEdge(IEdge e){
        edgeSet.add(e);
        layoutProperty.setEdgeValue(e, LayoutProperty.DEFAULT_EDGE_POS);
        sizeProperty.setEdgeValue(e,SizeProperty.DEFAULT_EDGE_WIDTH);
        colorProperty.setEdgeValue(e,ColorProperty.DEFAULT_EDGE_COL);
        return e;
    }

    /**
     * Adds an edge between the two given nodes and returns it.
     *
     * @param src source of the edge to add
     * @param tgt target of the edge to add
     * @return the added edge
     */
    @Override
    public IEdge addEdge(INode src, INode tgt){
 
            Edge edge = new Edge(src, tgt);
            layoutProperty.setEdgeValue(edge, LayoutProperty.DEFAULT_EDGE_POS);
            sizeProperty.setEdgeValue(edge, SizeProperty.DEFAULT_EDGE_WIDTH);
            colorProperty.setEdgeValue(edge, ColorProperty.DEFAULT_EDGE_COL);
            edgeSet.add(edge);
            return edge;

    }

    /**
     * Deletes a given node from the graph
     *
     * @param n the node to be deleted
     */
    @Override
    public void delNode(INode n){ 
        for (IEdge e : getInOutEdges(n)){
            delEdge(e);
        }
        sizeProperty.delNode(n);
        colorProperty.delNode(n);
        layoutProperty.delNode(n);
        nodeSet.remove(n);
    }

    /**
     * Deletes a given edge from the graph
     *
     * @param e the edge to be deleted
     */
    @Override
    public void delEdge(IEdge e){
        layoutProperty.delEdge(e);
        colorProperty.delEdge(e);
        sizeProperty.delEdge(e);
        edgeSet.remove(e);
    }

    /**
     * Returns the number of nodes in the graph
     *
     * @return the number of nodes
     */
    @Override
    public int numberOfNodes(){return getNodeSet().size();}

    /**
     * Returns the number of edges in the graph
     *
     * @return the number of edges
     */
    @Override
    public int numberOfEdges(){return getEdgeSet().size();}

    /**
     * Returns the neighbors  (successors and predecessors) of a given node in the graph
     *
     * @param n the node whose neighborhood is queried
     * @return the neighbors of the node
     */
    @Override
    public ArrayList<INode> getNeighbors(INode n){
        ArrayList<INode> neighborList = new ArrayList<>();
        for (IEdge edge : getEdgeSet()) {
            if (n.equals(edge.source())) {
                neighborList.add(edge.target());
            } else if (n.equals(edge.target())) {
                neighborList.add(edge.source());
            }
        }
        return neighborList;
    }

    /**
     * Returns the sucessors of a given node in the graph
     *
     * @param n the node whose successors are queried
     * @return the successors of the node
     */
    @Override
    public ArrayList<INode> getSuccesors(INode n){
        if (oriented) {
            return getNeighbors(n);
        }
        ArrayList<INode> neighborList = new ArrayList<>();
        for (IEdge edge : getEdgeSet()) {
            if (n.equals(edge.source())){
                neighborList.add(n);
            }
        }
        return neighborList;
    }

    /**
     * Returns the predecessors of a given node in the graph
     *
     * @param n the node whose predecessors are queried
     * @return the predecessors of the node
     */
    @Override
    public ArrayList<INode> getPredecessors(INode n){
        if (oriented) {
            return getNeighbors(n);
        }
        ArrayList<INode> neighborList = new ArrayList<>();
        for (IEdge edge : getEdgeSet()) {
            if (n.equals(edge.target())){
                neighborList.add(n);
            }
        }
        return neighborList;
    }

    /**
     * Returns the indicent edges of a given node
     *
     * @param n the node whose incident edges are queried
     * @return the incident edges of the node
     */
    @Override
    public ArrayList<IEdge> getInOutEdges(INode n){
        ArrayList<IEdge> edgeList = new ArrayList<>();
        for (INode neighbor : getNeighbors(n)) {
            edgeList.add(getEdge(n, neighbor, oriented));
        }
        return edgeList;
    }

    /**
     * Returns the in-going edges of a given node in the graph
     *
     * @param n the node whose in-going are queried
     * @return the in-going edges of the node
     */
    @Override
    public ArrayList<IEdge> getInEdges(INode n){
        ArrayList<IEdge> edgeList = new ArrayList<>();
        for (INode n2 : getPredecessors(n)) {
            edgeList.add(getEdge(n, n2, oriented));
        }
        return edgeList;
    }

    /**
     * Returns the out-going edges of a given node in the graph
     *
     * @param n the node whose out-going are queried
     * @return the out-going edges of the node
     */
    @Override
    public ArrayList<IEdge> getOutEdges(INode n){
        ArrayList<IEdge> edgeList = new ArrayList<>();
        for (INode n2 : getSuccesors(n)) {
            edgeList.add(getEdge(n, n2, oriented));
        }
        return edgeList;
    }
    

    /**
     * Returns the nodes of the graph
     *
     * @return the nodes of the graph
     */
    @Override
    public ArrayList<INode> getNodes(){
        ArrayList<INode> nodes = new ArrayList<>();
        for (INode node : getNodeSet()) {
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * Returns the edges of the graph
     *
     * @return the edges of the graph
     */
    @Override
    public ArrayList<IEdge> getEdges(){
        ArrayList<IEdge> edges = new ArrayList<>();
        for (IEdge edge : getEdgeSet()) {
            edges.add(edge);
        }
        return edges;
    }

    /**
     * Returns the source node of a given edge in the graph
     *
     * @param e the edge whose source is queried
     * @return the source of the edge
     */
    @Override
    public INode source(IEdge e){
        return e.source();}

    /**
     * Returns the target node of a given edge in the graph
     *
     * @param e the edge whose target is queried
     * @return the target of the edge
     */
    @Override
    public INode target(IEdge e){
        return e.target();
    }

    /**
     * Returns the in-degree (number of predecessors) of a given node in the
     * graph
     *
     * @param n the node whose in-degree is queried
     * @return the in-degree of the node
     */
    @Override
    public int inDegree(INode n){
        return getPredecessors(n).size();
    }

    /**
     * Returns the out-degree (number of successors) of a given node in the
     * graph
     *
     * @param n the node whose out-degree is queried
     * @return the out-degree of the node
     */
    @Override
    public int outDegree(INode n){
        return getSuccesors(n).size();
    }

    /**
     * Returns the degree (number of neighbors) of a given node in the graph
     *
     * @param n the node whose degree is queried
     * @return the degree of the node
     */
    @Override
    public int degree(INode n){
        return getNeighbors(n).size();
    }

    /**
     * Returns true if there exists an edge between the two given nodes,
     * considering the orientation of the edges or not.
     *
     * @param src the source node of the putative edge
     * @param tgt the target node of the putative edge
     * @param oriented if true, the function consider the edge as directed
     * (arc), and undirected otherwise
     * @return true if the edge exists, false otherwise
     */
    @Override
    public boolean existEdge(INode src, INode tgt, boolean oriented){
        return getEdge(src, tgt, oriented) != null;
    }

    /**
     * Returns an existing edge between the source and target nodes while
     * considering the orientation of not.
     *
     * @param src the source node of the putative edge
     * @param tgt the target node of the putative edge
     * @param oriented if true, the function consider the edge as directed
     * (arc), and undirected otherwise
     * @return the edge if the edge exists, null otherwise
     */
    @Override
    public IEdge getEdge(INode src, INode tgt, boolean oriented){
        IEdge edge = null;
        for (IEdge e : getEdgeSet()) {
            //if (e.source().equals(src) && e.target().equals(tgt) || isOriented() ? false : e.target().equals(src) && e.source().equals(tgt)) {
              //  edge=e; 
            //}
            if (e.source().equals(src) && e.target().equals(tgt) || e.target().equals(src) && e.source().equals(tgt)){
                edge=e;
            }
        }
        return edge;
    }

    /**
     * Returns the SizeProperty associated to the Graph.
     *
     * @return The SizeProperty of the Graph
     */
    @Override
    public SizeProperty getSizes(){
        return sizeProperty;
    }

    /**
     * Returns the size of a given node in the graph
     *
     * @param n the node of interest
     * @return the size of the node
     */
    @Override
    public Size getNodeSize(INode n){
        return getSizes().getNodeValue(n);
    }

    /**
     * Returns the width of a given edge in the graph
     *
     * @param e the edge of interest
     * @return the width of the edge
     */
    @Override
    public Double getEdgeWidth(IEdge e){
        return getSizes().getEdgeValue(e);
    }

    /**
     * Set the size of a given node in the graph
     *
     * @param n the node of interest
     * @param s new size of the node
     */
    @Override
    public void setNodeSize(INode n, Size s){
        getSizes().setNodeValue(n,s);
    }

    /**
     * Set the width of a given edge in the graph
     *
     * @param e the edge of interest
     * @param width new width of the edge
     */
    @Override
    public void setEdgeWidth(IEdge e, Double width){
        getSizes().setEdgeValue(e, width);
    } 

    /**
     * Set the size of all nodes in the graph
     *
     * @param s new size of the nodes
     */
    @Override
    public void setAllNodesSizes(Size s){
        getSizes().setAllNodesValues(s);
        
    }

    /**
     * Set the width of all edges in the graph
     *
     * @param width new width of the edges
     */
    @Override
    public void setAllEdgesWidths(Double width){
        
        getSizes().setAllEdgesValues(width);
    }

    /**
     * Returns the LayoutProperty associated to the IGraph.
     *
     * @return The LayoutProperty of the IGraph
     */
    @Override
    public LayoutProperty getLayout(){
        return layoutProperty;
    }

    /**
     * Returns the coordinates of a given node in the graph
     *
     * @param n the node of interest
     * @return the coordinates of the node
     */
    @Override
    public Coord getNodePosition(INode n){
        return getLayout().getNodeValue(n);
    }

    /**
     * Returns the coordinates of a given edge (ie the coordinates of its bends)
     * in the graph
     *
     * @param e the edge of interest
     * @return the coordinates of the bends of the edge
     */
    @Override
    public ArrayList<Coord> getEdgePosition(IEdge e){
        return getLayout().getEdgeValue(e);
    }

    /**
     * Set the coordinates of a given node in the graph
     *
     * @param n the node of interest
     * @param c new coordinates of the node
     */
    @Override
    public void setNodePosition(INode n, Coord c){
        getLayout().setNodeValue(n, c);
    }

    /**
     * Set the coordinates of a given edge (ie the coordinates of its bends) in
     * the graph
     *
     * @param e the edge of interest
     * @param bends the bends of the edge
     */
    @Override
    public void setEdgePosition(IEdge e, ArrayList<Coord> bends){
        getLayout().setEdgeValue(e, bends);
    }

    /**
     * Set the coordinates of all nodes in the graph
     *
     * @param c new coordinates of the nodes
     */
    @Override
    public void setAllNodesPositions(Coord c){
        getLayout().setAllNodesValues(c);
    }

    /**
     * Set the coordinates of all edges (ie the coordinates of its bends) in the
     * graph
     *
     * @param bends the bends of the edges
     */
    @Override
    public void setAllEdgesPositions(ArrayList<Coord> bends){
        getLayout().setAllEdgesValues(bends);
    }

    /**
     * Returns the coordinates of the bouding box of the graph drawing. The
     * bouding box of a drawing of a graph is the minimum rectangle such that
     * all nodes and edges of the graph are inside the rectangle. Please remind
     * that the y-axis is oriented toward the bottom.
     *
     * @return an ArrayList containing the coordinates of the top-left corner of
     * the bonding box (at the first index in the ArrayList) and the coordinates
     * of the bottom-right corner of the bounding box (second index)
     *
     */
    @Override
    public ArrayList<Coord> getBoundingBox(){
        double top, bottom, left, right;
        //Coord s1 = getNodePosition(getNodeSet().get(0));
        top = Double.POSITIVE_INFINITY;//s1.getY();
        bottom = Double.NEGATIVE_INFINITY;//s1.getY();
        left = Double.POSITIVE_INFINITY;//s1.getX();
        right = Double.NEGATIVE_INFINITY;//s1.getX();
        for (INode n: getNodeSet()) {
            Coord c = getNodePosition(n);
            Size s = getNodeSize(n);
            if (c.getY()-s.getH() < top) {
                top = c.getY()-s.getH();
            }
            if (c.getY()+s.getH() > bottom) {
                bottom = c.getY()+s.getH();
            }
            if (c.getX()-s.getW() < left) {
                left = c.getX()-s.getW();
            }
            if (c.getX()+s.getW() > right) {
                right = c.getX()+s.getW();
            }
        }
        Coord topLeftCorner  = new Coord(left,top);
        Coord bottomRightCorner = new Coord(right,bottom);
        ArrayList<Coord> cornerList = new ArrayList<>(Arrays.asList(topLeftCorner,bottomRightCorner));
        return cornerList;
    }

    /**
     * Returns the ColorProperty associated to the IGraph.
     *
     * @return The ColorProperty of the IGraph
     */
    @Override
    public ColorProperty getColor(){
        return colorProperty;
    }

    /**
     * Returns the color of a given node in the graph.
     *
     * @param n the node of interest
     * @return the color of the node
     */
    @Override
    public Color getNodeColor(INode n){
        return getColor().getNodeValue(n);
    }

    /**
     * Returns the color of a given edge in the graph.
     *
     * @param e the edge of interest
     * @return the color of the edge
     */
    @Override
    public Color getEdgeColor(IEdge e){
        return getColor().getEdgeValue(e);
    }

    /**
     * Set the color of a given node in the graph.
     *
     * @param n the node of interest
     * @param c new color of the node
     */
    @Override
    public void setNodeColor(INode n, Color c){
        getColor().setNodeValue(n, c);
    }

    /**
     * Set the color of a given edge in the graph.
     *
     * @param e the edge of interest
     * @param c the bends of the edge
     */
    @Override
    public void setEdgeColor(IEdge e, Color c){
        getColor().setEdgeValue(e, c);
    }

    /**
     * Set the color of all nodes in the graph.
     *
     * @param c the new color of the nodes
     */
    @Override
    public void setAllNodesColors(Color c){
        getColor().setAllNodesValues(c);
    }

    /**
     * Set the color of all edges in the graph.
     *
     * @param c the new color of the edges
     */
    @Override
    public void setAllEdgesColors(Color c){
        getColor().setAllEdgesValues(c);
    }

    /**
     * Color the nodes with Well & Powell algorithm.
     */
    @Override
    public void welshAndPowell(){
        WelshAndPowell w = new WelshAndPowell(this);
        Map<String,Object> p = new HashMap<>();
        p.put("palette", getPalette());
        w.apply(this, p);
    }
    
    /**
     * Color the nodes with a 6 colors algorithm (only for planar graphs)
     */  
    @Override
    public void sixColors(){
        SixColorationPlanarAlgorithm s = new SixColorationPlanarAlgorithm(this);
        Map<String,Object> p = new HashMap<>();
        p.put("palette", getPalette());
        s.apply(this, p);
    }
    
    /**
     * Color the nodes with a 5 colors algorithm (only for planar graphs)
     */  
    @Override
    public void fiveColors(){
        FiveColorationPlanarAlgorithm f = new FiveColorationPlanarAlgorithm(this);
        Map<String,Object> p = new HashMap<>();
        p.put("palette", getPalette());
        f.apply(this, p);
    }

    /**
     * Gets the set containing every node of the graph
     * @return the node set
     */
    public ArrayList<INode> getNodeSet() {
        return nodeSet;
    }

    /**
     * Sets the node set of the graph to a given node set
     * @param nodeSet the replacing node set
     */
    public void setNodeSet(ArrayList<INode> nodeSet) {
        this.nodeSet = nodeSet;
    }
    /**
     * Gets the set containing every edge of the graph
     * @return the edge set
     */
    public ArrayList<IEdge> getEdgeSet() {
        return edgeSet;
    }

    /**
     * Sets the edge set of the graph to a given edge set
     * @param edgeSet the replacing edge set
     */
    public void setEdgeSet(ArrayList<IEdge> edgeSet) {
        this.edgeSet = edgeSet;
    }

    /**
     * If this graph is oriented
     * @return true if oriented, else false
     */
    public boolean isOriented() {
        return oriented;
    }

    /**
     * Sets the status of the graph being oriented or not
     * @param oriented if it will be oriented or not
     */
    public void setOriented(boolean oriented) {
        this.oriented = oriented;
    }

    /**
     * Gets a predefined color palette to color a graph
     * @return the color palette as a color list
     */
    public ArrayList<Color> getPalette() {
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(new Color(68,175,105,255));
        colorList.add(new Color(248,51,60,255));
        colorList.add(new Color(252,171,16,255));
        colorList.add(new Color(43,158,179,255));
        colorList.add(new Color(219,213,181,255));
        colorList.add(new Color(255,139,55,255));
        return colorList;
    }

    public void checkFiveColoration() throws Exception {
        for (INode n : getNodes()) {
            boolean badColors = false;
            for (INode neighbor : getNeighbors(n)) {
                if (getNodeColor(n).equals(getNodeColor(neighbor))) {
                    throw new Exception("Coloration non correcte");
                }
            }
            if (getNodeColor(n) == null || getNodeColor(n).equals(new Color(255,139,55,255)) || badColors) {
                throw new Exception("Coloration non correcte");
            }
        }      
    }
}
