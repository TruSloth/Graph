public class DjikstraApp {
    public static void main(String[] args) throws Exception {

        WeightedGraph g = new WeightedGraph();

        Vertex vertexS = g.addVertex("s");
        Vertex vertexT = g.addVertex("t");
        Vertex vertexX = g.addVertex("x");
        Vertex vertexY = g.addVertex("y");
        Vertex vertexZ = g.addVertex("z");

        g.addDirectedEdge(vertexS, vertexT, 10);
        g.addDirectedEdge(vertexS, vertexY, 5);
        g.addDirectedEdge(vertexT, vertexY, 2);
        g.addDirectedEdge(vertexT, vertexX, 1);
        g.addDirectedEdge(vertexX, vertexZ, 4);
        g.addDirectedEdge(vertexY, vertexT, 3);
        g.addDirectedEdge(vertexY, vertexX, 9);
        g.addDirectedEdge(vertexY, vertexZ, 2);
        g.addDirectedEdge(vertexZ, vertexS, 2);
        g.addDirectedEdge(vertexZ, vertexX, 6);

        g.printGraph();
        
        System.out.println();
        
        Djikstra.solve(g, vertexS);
        Djikstra.printShortestPath(vertexX);
    }
}
