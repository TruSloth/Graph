public class Edge {
    private Vertex destination;

    public Edge(Vertex destination) {
        this.destination = destination;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }
}