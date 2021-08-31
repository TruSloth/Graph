public class DisjointSetNode {
    private Object item;
    private DisjointSetNode parent;
    private int rank;

    public DisjointSetNode getParent() {
        return parent;
    }

    public void setParent(DisjointSetNode parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public DisjointSetNode(Object item) {
        this.item = item;
        this.parent = this;
        this.rank = 0;
    }

    public static void union(DisjointSetNode x, DisjointSetNode y) {
        link(findSet(x), findSet(y));
    }

    public static DisjointSetNode findSet(DisjointSetNode x) {
        if (x != x.getParent()) {
            x.setParent(findSet(x.getParent()));
        }
        return x.getParent();
    }

    public static void link(DisjointSetNode x, DisjointSetNode y) {
        if (x.getRank() > y.getRank()) {
            y.setParent(x);
        } else {
            x.setParent(y);
            if (x.getRank() == y.getRank()) {
                y.setRank(y.getRank() + 1);
            }
        }
    }
}