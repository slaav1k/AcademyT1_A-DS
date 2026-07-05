package laba1;

public class NetMatrix {
    private MatrixValue[][] _net;

    public NetMatrix(int pCount) {
        _net = new MatrixValue[pCount][pCount];
    }

    public MatrixValue[][] get_net() {
        return _net;
    }

    public void set_net(MatrixValue[][] _net) {
        this._net = _net;
    }

    public void setElement(int pA, int pB, MatrixValue pValue) {
        _net[pA][pB] = pValue;
        _net[pB][pA] = _net[pA][pB];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = _net.length;

        char[] labels = new char[size];
        for (int i = 0; i < size; i++) {
            labels[i] = (char) ('A' + i);
        }

        sb.append("          ");
        for (char label : labels) {
            sb.append(String.format("%-20c", label));
        }
        sb.append("\n");

        sb.append("---").append("-".repeat(size * 20)).append("\n");

        for (int i = 0; i < size; i++) {
            sb.append(labels[i]).append(" | ");
            for (int j = 0; j < _net[i].length; j++) {
                if (_net[i][j] == null) {
                    sb.append(String.format("%-20s", "[  no link  ]"));
                } else {
                    sb.append(String.format("%-20s", _net[i][j]));
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
