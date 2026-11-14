package Test;

import info.iut.sae2.graphs.Graph;
import info.iut.sae2.graphs.GraphLoader;
import info.iut.sae2.graphs.IGraph;
import info.iut.sae2.graphs.INode;
import info.iut.sae2.graphs.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class Graph_Test {

    @Test
    public void createGraphTest() {
        Graph g = new Graph();
        assertNotNull(g.createGraph());
    }

    @Test
    public void copyTest() {
        IGraph g = new Graph();
        IGraph g2 = new Graph();
        assertEquals(g.getNodes(),g2.getNodes());
        assertEquals(g.getEdges(),g2.getEdges());
    }

    @Test
    public void NodeTest() {
        IGraph g = new Graph();
        g.addNode();
        assertEquals(g.getNodes().size(),1); // Test addNode().

        g.delNode(g.getNodes().get(0));
        assertEquals(g.getNodes().size(),0); // Test DelNode(INode n).

        INode n = new Node();
        g.addNode(n);
        assertEquals(g.getNodes().get(0),n); // Test addNode(INode n).
    }

    @Test
    public void edgeTest() {
        IGraph g = new Graph();
        INode n = new Node();
        INode n2 = new Node();
        g.addEdge(n, n2);
        assertEquals(g.getEdges().size(),1); // Test addNode().

        g.delEdge(g.getEdges().get(0));
        assertEquals(g.getNodes().size(),0); // Test DelNode(INode n).

        g.addNode(n);
        assertEquals(g.getNodes().get(0),n);
    }

    @Test
    public void getNeighbors() {
        //Test sur le graphe testCJ.
        IGraph g = new Graph();
        g = GraphLoader.loadFromFile("dataset/testCJ_nodes.csv", "dataset/testCJ_edges.csv" );
        for (INode node : g.getNodes()){
            assertEquals(g.getNeighbors(node).size(),2);
        }
        //Test sur un cycle eulerien de taille 3.
        INode a = new Node();
        INode b = new Node();
        INode c = new Node();
        IGraph g2= new Graph();
        g2.addNode(c);g2.addNode(b);g2.addNode(a);
        g2.addEdge(c, a);g2.addEdge(c, b);
        assertTrue(g2.getNeighbors(c).contains(a));
        assertTrue(g2.getNeighbors(c).contains(b));
        INode d = new Node();
        assertFalse(g2.getNeighbors(c).contains(d));
        assertEquals(g.getNeighbors(d).size(),0);
    }
}
