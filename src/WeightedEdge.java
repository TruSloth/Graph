public class WeightedEdge extends Edge {
    private int weight;

    public WeightedEdge(Vertex destination, int weight) {
        super(destination);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight; 
    }
}
