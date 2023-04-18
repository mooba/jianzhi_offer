import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    public HashMap<Node, Integer> calDijkstra(Node from) {
        HashMap<Node, Integer> retMap = new HashMap<>();
        if (from == null) {
            return retMap;
        }

        Set<Node> processedNode = new HashSet<>();
        retMap.put(from, 0);
        Node node = getMinAndUnselectedNode(processedNode, retMap);
        while (node != null) {
            Integer curDistance = retMap.get(node);
            if (!processedNode.contains(node)) {
                List<Edge> edges = node.edges;
                for (Edge edge: edges) {
                    if (retMap.get(edge.to) == null) {
                        retMap.put(edge.to, edge.weight + curDistance);
                    } else {
                        // 已经到过这个点，之前的距离是preDistance, 然后和现在的距离进行对比
                        Integer preDistance = retMap.get(edge.to);
                        retMap.put(edge.to, Math.min(edge.weight + curDistance, preDistance));
                    }
                }
            }

            processedNode.add(node);
            node = getMinAndUnselectedNode(processedNode, retMap);
        }
        
        return retMap;
    }


    public Node getMinAndUnselectedNode(Set<Node> processedNode, Map<Node, Integer> distanceMap) {
        Node minNode = null;
        Integer minDistance = Integer.MAX_VALUE;
        for (Node node : distanceMap.keySet()) {
            if (!processedNode.contains(node)) {
                if (distanceMap.get(node) < minDistance) {
                    minNode = node;
                }
            }
        }
        return minNode;
    }



    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 97);
        for (String keyString : map.keySet()) {
            if (keyString.length() < 26) {
                map.put(keyString + 1, 100);
            }
        }

        System.out.println(map);
    }
    
}
