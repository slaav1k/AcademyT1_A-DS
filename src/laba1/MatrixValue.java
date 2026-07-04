package laba1;

public class MatrixValue {
    private int _bandwidth;
    private int _losses;

    public MatrixValue(int pBandwidth, int pLosses) {
        _bandwidth = pBandwidth;
        _losses = pLosses;
    }

    public int get_bandwidth() {
        return _bandwidth;
    }

    public void set_bandwidth(int _bandwidth) {
        this._bandwidth = _bandwidth;
    }

    public int get_losses() {
        return _losses;
    }

    public void set_losses(int _losses) {
        this._losses = _losses;
    }

    @Override
    public String toString() {
        return String.format("[%d MB, %d%%]", _bandwidth, _losses);
    }
}
