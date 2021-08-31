public class WeightedEdge extends Edge {
    private int weight;

    public WeightedEdge(Vertex origin, Vertex destination, int weight) {
        super(origin, destination);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight; 
    }
}
