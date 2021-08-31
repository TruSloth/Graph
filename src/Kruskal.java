import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Kruskal {
    private static HashMap<Vertex, DisjointSetNode> disjointSet;
    private static ArrayList<WeightedEdge> edgeList;
    private static ArrayList<WeightedEdge> mstEdges;

    public static ArrayList<WeightedEdge> findMST(WeightedGraph g) {
        mstEdges = new ArrayList<WeightedEdge>();
        edgeList = g.getEdges();

        edgeList.sort(Comparator.comparing(WeightedEdge :: getWeight));
        
        initializeKruskal(g);

        for (WeightedEdge edge : edgeList) {
            DisjointSetNode origin = disjointSet.get(edge.getOrigin());
            DisjointSetNode destination = disjointSet.get(edge.getDestination());

            if (DisjointSetNode.findSet(origin) != DisjointSetNode.findSet(destination)) {
                mstEdges.add(edge);
                DisjointSetNode.union(origin, destination);
            }
        }

        return mstEdges;
    }

    private static void initializeKruskal(WeightedGraph g) {
        disjointSet = new HashMap<Vertex, DisjointSetNode>();
        for (Vertex vertex : g.getVertices()) {
            disjointSet.putIfAbsent(vertex, new DisjointSetNode(vertex));
        }
    }

    public static void printMST() {
        for (WeightedEdge edge : mstEdges) {
            String origin = edge.getOrigin().getLabel();
            String destination = edge.getDestination().getLabel();
            System.out.printf("%s -> %s (%d)\n", origin, destination, edge.getWeight());
        }
    }
}
