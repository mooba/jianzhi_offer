public class Edge {
    public Node from;
    public Node to;
    // 边的权重
    public int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
