import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // write your code here
        MyMain m = new MyMain(args);
    }
}

class Node {
    int id;
    Node next;

    Node(int n) { id =n; next = null; }
}

class MyMain {
    StringBuilder sb = new StringBuilder(4096);

    void pr(String s) { sb.append(s); }

    Node nodes[] = new Node[100000];
    int N;

    int ceilingLog2(int n) {
        int log = 0;
        int val = 1;
        while (val < n) {
            ++log;
            val <<= 1;
        }
        //System.out.println("ceillog2 of "+ N +" is "+ log);
        return log;
    }

    class TreeResult {
        int days;
        int uniqPaths;
        TreeResult(int d, int u) { days = d; uniqPaths = u; }
    }

    int numDaysForNode(Node node, int parent, int myslot) {
        if (node == null) return 0;

        //System.out.println("Camefrom "+ camefrom +", parent "+ parent +", node is "+ node.id);

        int count = 0;
        int numChildren = 0;

        for (Node n = node; n != null; n = n.next) {
            if (n.id != parent) {
                Node actualNode = nodes[n.id - 1];
                count += numDaysForNode(actualNode, myslot, n.id);
                numChildren += 1;
            }
        }

        count += ceilingLog2(numChildren + 1) + numChildren;
        return count;
    }

    MyMain(String args[]){
        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();
        for (int i=0; i< N - 1; ++i) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            Node node = new Node(to);
            node.next = nodes[from - 1];
            nodes[from - 1] = node;

            node = new Node(from);
            node.next = nodes[to - 1];
            nodes[to - 1] = node;
        }

//        for (int i=0; i< nodes.length; ++i) {
//            if (nodes[i] != null) {
//                String s = "Node "+ (i+1) +":";
//                for (Node n = nodes[i]; n != null; n = n.next) {
//                    s += " "+ n.id;
//                }
//                System.out.println(s);
//            }
//        }

        int days = numDaysForNode(nodes[0], 0, 1);
        System.out.print(days);
    }
}
