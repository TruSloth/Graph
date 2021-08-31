import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Graph implements Cloneable {
    private HashMap<Vertex, List<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<Vertex, List<Edge>>();
    }

    public Vertex addVertex(String label) {
        System.out.println("adding vertex");
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

    public void addDirectedEdge(Vertex origin, Vertex destination) {
        adjList.get(origin).add(new Edge(origin, destination));
    }

    public void addUndirectedEdge(Vertex origin, Vertex destination) {
        adjList.get(origin).add(new Edge(origin, destination));
        adjList.get(destination).add(new Edge(destination, origin));
    }

    public void removeEdge(Vertex origin, Vertex destination) {
        List<Edge> edgeList = adjList.get(origin);
        edgeList.removeIf(edge -> edge.getDestination().equals(destination));

        List<Edge> reverseEdgeList = adjList.get(destination);
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

    public ArrayList<Edge> getEdges() {
        ArrayList<Edge> edgesList = new ArrayList<Edge>();

        for (Vertex origin : getVertices()) {
            for (Vertex destination : getAdjVertices(origin)) {
                Edge edge = getEdge(origin, destination);
                if (!edgesList.contains(edge)) {
                    edgesList.add(edge);
                }
            }
        }

        return edgesList;
    }

    public Edge getEdge(Vertex origin, Vertex destination) {
        List<Edge> edgeList = adjList.get(origin);
        for (Edge edge : edgeList) {
            if (edge.getDestination() == destination) {
                return edge;
            }
        }

        return null;
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
            for (Edge edge : adjList.get(vertex)) {
                System.out.printf(" -> " + edge.getDestination().getLabel());
            }
            System.out.println();
        }
    }
}