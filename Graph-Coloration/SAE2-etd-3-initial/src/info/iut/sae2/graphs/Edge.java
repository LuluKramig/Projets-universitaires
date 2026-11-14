package info.iut.sae2.graphs;
/**
 * Class for edge.
 */
public class Edge implements IEdge {
    /**
     * The source node.
     */
    private INode nodeSrc;
    /**
     * The destination node.
     */
    private INode nodeDst;
    /**
     * A constructor for edges.
     * @param nodeSourc The source node.
     * @param nodeDest The destination node.
     */
    public Edge(INode nodeSourc, INode nodeDest){
        nodeSrc=nodeSourc;
        nodeDst=nodeDest;
    }
    /**
     * Getter for the  source node.
     */
    @Override
    public INode source(){
        return nodeSrc;
    }
    /**
     * Getter for the destination node.
     */
    @Override
    public INode target(){
        return nodeDst;
    }
    /**
     * Setter for the source node.
     * @param src The new source node.
     */
    public void setSrc(Node src) {
        nodeSrc=src;
    }
    /**
     * Setter for the destination node.
     * @param dst The new destination node.
     */
    public void setDst(Node dst){
        nodeDst=dst;
    }
}
