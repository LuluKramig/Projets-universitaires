package info.iut.sae2.algorithm;

import info.iut.sae2.graphs.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/**
 * Colouring algorithm class applying the Six-Coloration algorithm 
 */
public class SixColorationPlanarAlgorithm extends AbstractColorAlgorithm<Void> {
    private HashMap<INode, Integer> colorMap = new HashMap<INode, Integer>();
    private ArrayList<INode> nodeList = new ArrayList<>();
    /**
     * Constructor initializing the graph colouring values
     * @param g the graph being coloured
     */
    public SixColorationPlanarAlgorithm(IGraph g) {
        IGraph graph=g.copy();
        while (!(graph.numberOfNodes()==0)) {
            int n = 0;
            while (graph.degree(graph.getNodes().get(n)) > 5) {
                n++;
            }
            INode node = graph.getNodes().get(n);
            nodeList.add(node);
            graph.delNode(node);
        }
        for(int i = nodeList.size() - 1; i >= 0; i--) {
            int color=0;
            HashSet<Integer> colorSet = new HashSet<>();
            for (INode neighbor : g.getNeighbors(nodeList.get(i))) {
                if ((colorMap.containsKey(neighbor))) {
                    colorSet.add(colorMap.get(neighbor));
                }
            }
            while(colorSet.contains(color)){
                color++;
            }
            colorMap.put(nodeList.get(i),color);
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
