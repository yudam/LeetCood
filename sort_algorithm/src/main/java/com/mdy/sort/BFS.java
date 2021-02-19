package com.mdy.sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * User: maodayu
 * Date: 2021/2/10 14:16
 */
public class BFS {

    public static void main(String[] args) {
        HashMap<String, String[]> hashMap = new HashMap<>();
        hashMap.put("A", new String[]{"B", "C"});
        hashMap.put("B", new String[]{"A", "E"});
        hashMap.put("C", new String[]{"A", "D", "F"});
        hashMap.put("D", new String[]{"C", "E"});
        hashMap.put("E", new String[]{"B", "D", "H"});
        hashMap.put("F", new String[]{"C", "G"});
        hashMap.put("G", new String[]{"F", "H"});
        hashMap.put("H", new String[]{"E", "G"});

        Node result = findTarget("A","H",hashMap);

        System.out.println(result);
    }

    /**
     * 查找目标结点，并保存路径
     */
    public static Node findTarget(String root, String target, HashMap<String, String[]> map) {
        List<String> selectNode = new LinkedList<>();
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(root, null));
        while (!deque.isEmpty()) {
            Node value = deque.poll();
            if (selectNode.contains(value.val)) {
                continue;
            }

            if (value.val.equals(target)) {
                return value;
            }

            String[] next = map.get(value.val);
            if (next != null && next.length > 0) {
                for (String s : next) {
                    deque.add(new Node(s, value));
                }
            }
            selectNode.add(value.val);
        }
        return null;
    }


    static class Node {
        public String val;
        public Node parent;

        public Node(String val, Node node) {
            this.val = val;
            this.parent = node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", parent=" + parent +
                    '}';
        }
    }
}
