package info.iut.sae2.algorithm;

import info.iut.sae2.graphs.IGraph;
import info.iut.sae2.graphs.INode;
import info.iut.sae2.graphs.Color;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * Colouring algorithm class applying the Welsh-Powell algorithm 
 */
public class WelshAndPowell extends AbstractColorAlgorithm<Void> {

    private HashMap<INode, Integer> colorMap = new HashMap<INode, Integer>();
    /**
     * Constructor initializing the graph colouring values
     * @param g the graph being coloured
     */
    public WelshAndPowell(IGraph g) {
        int color = 0;
        ArrayList<INode> sortList = new ArrayList<>(g.getNodes());
        sortList.sort((n1, n2) -> Integer.compare(g.degree(n2), g.degree(n1)));
        while(!(sortList.size()==colorMap.size())){
            for (INode n : sortList) {
                if (!colorMap.containsKey(n)){
                    boolean canColor = true;
                    int i=0;
                    while(canColor && i<g.getNeighbors(n).size()) {
                        if (colorMap.containsKey(g.getNeighbors(n).get(i)) && colorMap.get(g.getNeighbors(n).get(i)) == color) {
                            canColor = false;
                        }
                        i++;
                    }
                    if (canColor) {
                        colorMap.put(n,color);
                    }
                }
            }
            color++;
        }
    }

    /**
     * Applies the graph colouring to a graph.
     * @param g the graph on which the algorithm is applied
     * @param parameters here, contains the color palette
     * @return nothing
     */
    @Override
    public Void apply(IGraph g, Map<String, Object> parameters) {
        for (INode n : colorMap.keySet()) {
            g.setNodeColor(n, ((ArrayList<Color>)parameters.get("palette")).get(colorMap.get(n)));
        }
        return null;
    }
}
