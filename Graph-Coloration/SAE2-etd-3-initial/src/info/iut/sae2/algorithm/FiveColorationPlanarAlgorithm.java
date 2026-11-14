package info.iut.sae2.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import info.iut.sae2.graphs.Color;
import info.iut.sae2.graphs.IGraph;
import info.iut.sae2.graphs.INode;
import info.iut.sae2.graphs.Node;

/**
 * Colouring algorithm class applying the Five-Coloration algorithm 
 */
public class FiveColorationPlanarAlgorithm extends AbstractColorAlgorithm<Void> {
    private HashMap<INode, Integer> colorMap = new HashMap<INode, Integer>();
    /**
     * Constructor initializing the graph colouring values
     * @param g the graph being coloured
     */
    public FiveColorationPlanarAlgorithm(IGraph g) {
        FiveColorationPlanarAlgorithmRec(g);
    }

    int O=0;
    /**
     * Recursive method used for the graph coloring with the Five-Coloration algorithm
     * @param g the graph being coloured
     * @return nothing
     */
    public Void FiveColorationPlanarAlgorithmRec(IGraph g) {
        IGraph graph = g.copy();
        if(graph.numberOfNodes()<=5) {
            for (INode node : graph.getNodes()) {
                colorierNode(graph, node);
            }
            return null;
        }
        INode node=graph.getNodes().get(0);
        int n=0;
        while ((graph.degree(node))>4 && n<graph.numberOfNodes()) {
            node=graph.getNodes().get(n);  
            n++;
        }
        if ((graph.degree(node))<=4) {
            graph.delNode(node);
            FiveColorationPlanarAlgorithmRec(graph);
            colorierNode(g, node);
        }
        else {
            n=0;
            while ((graph.degree(node))>5) {
                node=graph.getNodes().get(n);
                n++;
            }
            INode n1=new Node();
            INode n2=new Node();
            ArrayList<INode> neighbors = graph.getNeighbors(node);
            for (INode i : neighbors) {
                for(INode j : neighbors) {
                    if (!graph.existEdge(i, j, false) && !i.equals(j)) {
                        n1 = i;
                        n2 = j;
                    }
                }
            }
            for(INode nn2 : graph.getNeighbors(n2)) {
                if (!graph.existEdge(n1, nn2, false) && !n1.equals(nn2)) {
                    graph.addEdge(n1, nn2);
                }
            }
            
            
            graph.delNode(node);
            graph.delNode(n2);
            FiveColorationPlanarAlgorithmRec(graph);
            colorMap.put(n2, colorMap.get(n1));
            colorierNode(g, node);
        }
        return null;
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
    /**
     * Colours a node with the "smallest" colour possible
     * @param g the graph the node is in
     * @param node the node
     */
    private void colorierNode(IGraph g,INode node) {
        int color=0;
        HashSet<Integer> colorSet = new HashSet<>();
        g.getNeighbors(node).stream()
            .filter(n->colorMap.containsKey(n))
            .forEach(n->colorSet.add(colorMap.get(n)));
        while(colorSet.contains(color)){
            color++;
        }
        colorMap.put(node,color);
    }
}
