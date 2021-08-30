public class Vertex {
    private String label;
    private int shortestPathEst;
    private Vertex predecessor;
    private int key;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public int getShortestPathEst() {
        return shortestPathEst;
    }

    public void setShortestPathEst(int shortestPathEst) {
        this.shortestPathEst = shortestPathEst;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}