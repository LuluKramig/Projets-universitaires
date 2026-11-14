package info.iut.sae2.algorithm;
import info.iut.sae2.graphs.IGraph;
import info.iut.sae2.graphs.INode;

import org.junit.Test;
import static org.junit.Assert.*;

import info.iut.sae2.graphs.Color;
import info.iut.sae2.graphs.GraphLoader;
import info.iut.sae2.properties.*;
import info.iut.sae2.algorithm.*;
import info.iut.sae2.graphs.*;

public class Algorithm_Test {
    @Test
    public void testWelshAndPowell() {
        IGraph graph = GraphLoader.loadFromFile("dataset/planar_grid_10_nodes.csv", "dataset/planar_grid_10_edges.csv");
        graph.welshAndPowell();
        for (INode n : graph.getNodes()) {
            for (INode neighbor : graph.getNeighbors(n)) {
                assertFalse(graph.getNodeColor(n).equals(graph.getNodeColor(neighbor)));
            }
        }
    }

    @Test
    public void testSixColorationPlanarAlgorithm() {
        IGraph graph = GraphLoader.loadFromFile("dataset/planar_grid_100_nodes.csv", 
        "dataset/planar_grid_100_edges.csv");
        assertTrue(graph.getNodes().size()==10000);
        assertTrue(graph.getEdges().size()>0);
        graph.sixColors();
        for (INode n : graph.getNodes()) {
            for (INode neighbor : graph.getNeighbors(n)) {
                assertFalse(graph.getNodeColor(n).equals(graph.getNodeColor(neighbor)));
            }
        }
    }
    
    @Test
    public void testFiveColorationPlanarAlgorithm() {
        IGraph graph = GraphLoader.loadFromFile("dataset/planar_grid_10_nodes.csv", "dataset/planar_grid_10_edges.csv");
        graph.fiveColors();
        for (INode n : graph.getNodes()) {
            for (INode neighbor : graph.getNeighbors(n)) {
                assertFalse(graph.getNodeColor(n).equals(graph.getNodeColor(neighbor)));
                assertFalse(graph.getNodeColor(n) == null || graph.getNodeColor(n).equals(new Color(255,139,55,255)));
            }
        }
        
    }

}
