import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {
    private static WeightedGraph graph;

    public static void findMST(WeightedGraph g, Vertex r) throws CloneNotSupportedException {
        graph = (WeightedGraph) g.clone();

        Vertex root = graph.getVertex(r.getLabel());

        initializePrim(graph, root);

        Comparator<Vertex> byShortestPathEst = Comparator.comparing(Vertex :: getKey);

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>(byShortestPathEst);

        for (Vertex vertex : graph.getVertices()) {
            priorityQueue.add(vertex);
        }

        while (!priorityQueue.isEmpty()) {
            Vertex origin = priorityQueue.poll();

            for (Vertex vertex : graph.getAdjVertices(origin)) {
                int weight = graph.getEdge(origin, vertex).getWeight();
                if (priorityQueue.contains(vertex) && weight < vertex.getKey()) {
                    priorityQueue.remove(vertex);
                    vertex.setPredecessor(origin);
                    vertex.setKey(weight);
                    priorityQueue.add(vertex);
                }
            }
        }
    }
    


    private static void initializePrim(WeightedGraph g, Vertex root) {
        for (Vertex vertex : g.getVertices()) {
            vertex.setKey(Integer.MAX_VALUE);
            vertex.setPredecessor(null);
        }

        root.setKey(0);
    }

    public static void printMST() {
        for (Vertex vertex : graph.getVertices()) {
            Vertex origin = vertex.getPredecessor();
            if (origin != null) {
                System.out.printf("%s -> %s (%d)\n", origin.getLabel(), vertex.getLabel(), graph.getEdge(origin, vertex).getWeight());
            }
        }
    }
}