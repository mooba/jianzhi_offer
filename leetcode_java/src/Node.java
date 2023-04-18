import java.util.ArrayList;

public class Node {
    // node 所在的序号
    public int value;
    // 入度数
    public int in;
    // 出度数
    public int out;
    // 指向的直接下游节点
    public ArrayList<Node> nexts;
    // 直接相连的出度边
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
    
}
