public class PrimApp {
    public static void main(String[] args) throws Exception {

        WeightedGraph g = new WeightedGraph();

        Vertex vertexA = g.addVertex("a");
        Vertex vertexB = g.addVertex("b");
        Vertex vertexC = g.addVertex("c");
        Vertex vertexD = g.addVertex("d");
        Vertex vertexE = g.addVertex("e");
        Vertex vertexF = g.addVertex("f");
        Vertex vertexG = g.addVertex("g");
        Vertex vertexH = g.addVertex("h");
        Vertex vertexI = g.addVertex("i");

        g.addUndirectedEdge(vertexA, vertexB, 4);
        g.addUndirectedEdge(vertexA, vertexH, 8);
        g.addUndirectedEdge(vertexB, vertexC, 8);
        g.addUndirectedEdge(vertexB, vertexH, 11);
        g.addUndirectedEdge(vertexC, vertexD, 7);
        g.addUndirectedEdge(vertexC, vertexF, 4);
        g.addUndirectedEdge(vertexC, vertexI, 2);
        g.addUndirectedEdge(vertexD, vertexE, 9);
        g.addUndirectedEdge(vertexD, vertexF, 14);
        g.addUndirectedEdge(vertexE, vertexF, 10);
        g.addUndirectedEdge(vertexF, vertexG, 2);
        g.addUndirectedEdge(vertexG, vertexH, 1);
        g.addUndirectedEdge(vertexG, vertexI, 6);
        g.addUndirectedEdge(vertexH, vertexI, 7);

        g.printGraph();
        
        System.out.println();
        
        Prim.findMST(g, vertexA);
        Prim.printMST();
    }
}
