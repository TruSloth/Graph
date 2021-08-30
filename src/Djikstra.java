import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Djikstra {
    private static WeightedGraph graph;

    public static void solve(WeightedGraph g, Vertex s) throws CloneNotSupportedException {
        graph = (WeightedGraph) g.clone();

        Vertex source = graph.getVertex(s.getLabel());

        initializeSingleSource(graph, source);
        HashSet<Vertex> shortestPathDetermined = new HashSet<Vertex>();

        Comparator<Vertex> byShortestPathEst = Comparator.comparing(Vertex :: getShortestPathEst);

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>(byShortestPathEst);

        for (Vertex vertex : graph.getVertices()) {
            priorityQueue.add(vertex);
        }

        while (!priorityQueue.isEmpty()) {
            Vertex origin = priorityQueue.poll();
            shortestPathDetermined.add(origin);

            for (Vertex destination : graph.getAdjVertices(origin)) {
                if (!shortestPathDetermined.contains(destination)) {
                    priorityQueue.remove(destination);
                    relax(origin, destination, graph.getEdge(origin, destination).getWeight());
                    priorityQueue.add(destination);
                }
            };
        }
    }

    private static void initializeSingleSource(WeightedGraph g, Vertex source) {
        for (Vertex vertex : g.getVertices()) {
            vertex.setShortestPathEst(Integer.MAX_VALUE);
            vertex.setPredecessor(null);
        }

        source.setShortestPathEst(0);
    }

    private static void relax(Vertex origin, Vertex destination, int weight) {
        if (destination.getShortestPathEst() > origin.getShortestPathEst() + weight) {
            destination.setShortestPathEst(origin.getShortestPathEst() + weight);
            destination.setPredecessor(origin);
        }
    }

    private static void printGraph() {
        for (Vertex vertex : graph.getVertices()) {
            System.out.printf(vertex.getLabel() + "(%d)\n", vertex.getShortestPathEst());
        }
    }

    public static void printShortestPath(Vertex destination) {
        Vertex currentVertex = graph.getVertex(destination.getLabel());
        StringBuilder str = new StringBuilder();

        while(currentVertex.getPredecessor() != null) {
            str.append(currentVertex.getLabel() + " >- ");
            currentVertex = currentVertex.getPredecessor();
        }

        str.append(currentVertex.getLabel());
        System.out.println(str.reverse());
    }
}
