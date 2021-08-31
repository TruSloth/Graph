import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeightedGraph implements Cloneable {
    private HashMap<Vertex, List<WeightedEdge>> adjList;

    public WeightedGraph() {
        adjList = new HashMap<Vertex, List<WeightedEdge>>();
    }

    public Vertex addVertex(String label) {
        Vertex vertex = new Vertex(label);
        adjList.putIfAbsent(vertex, new ArrayList<>());
        return vertex;
    }

    public void removeVertex(Vertex vertex) {
        adjList.values().stream().forEach(edgeList -> {
            for (Edge edge : edgeList) {
                if (edge.getDestination() == vertex) {
                    edgeList.remove(edge);
                }
            }
        });
        adjList.remove(vertex);
    }

    public void addDirectedEdge(Vertex origin, Vertex destination, int weight) {
        adjList.get(origin).add(new WeightedEdge(origin, destination, weight));
    }

    public void addUndirectedEdge(Vertex origin, Vertex destination, int weight) {
        adjList.get(origin).add(new WeightedEdge(origin, destination, weight));
        adjList.get(destination).add(new WeightedEdge(destination, origin, weight));
    }

    public void removeEdge(Vertex origin, Vertex destination) {
        List<WeightedEdge> edgeList = adjList.get(origin);
        edgeList.removeIf(edge -> edge.getDestination().equals(destination));

        List<WeightedEdge> reverseEdgeList = adjList.get(destination);
        reverseEdgeList.removeIf(edge -> edge.getDestination().equals(origin));
    }

    public Vertex getVertex(String label) {
        for (Vertex vertex : adjList.keySet()) {
            if (vertex.getLabel() == label) {
                return vertex;
            }
        }

        return null;
    }

    public ArrayList<Vertex> getVertices() {
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();

        adjList.keySet().stream().forEach(vertex -> vertices.add(vertex));

        return vertices;
    }

    public WeightedEdge getEdge(Vertex origin, Vertex destination) {
        List<WeightedEdge> edgeList = adjList.get(origin);
        for (WeightedEdge edge : edgeList) {
            if (edge.getDestination() == destination) {
                return edge;
            }
        }

        return null;
    }

    public ArrayList<WeightedEdge> getEdges() {
        ArrayList<WeightedEdge> edgesList = new ArrayList<WeightedEdge>();

        for (Vertex origin : getVertices()) {
            for (Vertex destination : getAdjVertices(origin)) {
                WeightedEdge edge = getEdge(origin, destination);
                if (!edgesList.contains(edge)) {
                    edgesList.add(edge);
                }
            }
        }

        return edgesList;
    }

    public ArrayList<Vertex> getAdjVertices(Vertex origin) {
        ArrayList<Vertex> adjVertices = new ArrayList<Vertex>();

        adjList.get(origin).stream().forEach(edge -> {
            adjVertices.add(edge.getDestination());
        });

        return adjVertices;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void printGraph() {
        for (Vertex vertex : adjList.keySet()) {
            System.out.print(vertex.getLabel());
            for (WeightedEdge edge : adjList.get(vertex)) {
                System.out.printf(" -> " + edge.getDestination().getLabel() + "(%d)", edge.getWeight());
            }
            System.out.println();
        }
    }
}
