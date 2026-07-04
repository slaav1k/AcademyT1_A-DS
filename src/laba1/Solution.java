package laba1;


public class Solution {
    public static MatrixValue[][] matrixNet() {
        MatrixValue[][] net = new MatrixValue[6][6];

        // A - B
        net[0][1] = new MatrixValue(1500, 90);
        net[1][0] = net[0][1];
        // A - C
        net[0][2] = new MatrixValue(2000, 10);
        net[2][0] = net[0][2];
        // A - D
        net[0][3] = new MatrixValue(1000, 50);
        net[3][0] = net[0][3];
        // B - F
        net[1][5] = new MatrixValue(1500, 60);
        net[5][1] = net[1][5];
        // C - E
        net[2][4] = new MatrixValue(900, 5);
        net[4][2] = net[2][4];
        // C - F
        net[2][5] = new MatrixValue(500, 20);
        net[5][2] = net[2][5];
        // D - E
        net[3][4] = new MatrixValue(2500, 1);
        net[4][3] = net[3][4];
        // E - F
        net[4][5] = new MatrixValue(300, 85);
        net[5][4] = net[4][5];

        return net;
    }
}
