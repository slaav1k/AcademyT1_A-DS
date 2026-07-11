package laba1;


import laba1.part1.MatrixValue;
import laba1.part1.NetMatrix;
import laba1.part2.NetGraph;
import laba1.part2.Node;

public class Solution {
    public static NetMatrix matrixNet() {
        NetMatrix net = new NetMatrix(6);

        // A - B
        net.setElement(0, 1, new MatrixValue(1500, 90));
        // A - C
        net.setElement(0, 2, new MatrixValue(2000, 10));
        // A - D
        net.setElement(0, 3, new MatrixValue(1000, 50));
        // B - F
        net.setElement(1, 5, new MatrixValue(1500, 60));
        // C - E
        net.setElement(2, 4, new MatrixValue(900, 5));
        // C - F
        net.setElement(2, 5, new MatrixValue(500, 20));
        // D - E
        net.setElement(3, 4, new MatrixValue(2500, 1));
        // E - F
        net.setElement(4, 5, new MatrixValue(300, 85));

        return net;
    }

    public static NetGraph nodesNet() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');

        A.addLink(B, 1500, 90);
        A.addLink(C, 2000, 10);
        A.addLink(D, 1000, 50);
        B.addLink(F, 1500, 60);
        C.addLink(E, 900, 5);
        C.addLink(F, 500, 20);
        D.addLink(E, 2500, 1);
        E.addLink(F, 300, 85);

        NetGraph net = new NetGraph();
        net.addElement(A);
        net.addElement(B);
        net.addElement(C);
        net.addElement(D);
        net.addElement(E);
        net.addElement(F);

        return net;
    }
}
