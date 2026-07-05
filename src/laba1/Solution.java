package laba1;


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
}
