package laba1;

public class NodeLink {
    private Node _target;
    private int _bandwidth;
    private int _losses;

    public NodeLink(Node pNode, int pBandwidth, int pLosses) {
        _target = pNode;
        _bandwidth = pBandwidth;
        _losses = pLosses;
    }

    public Node get_target() {
        return _target;
    }

    public void set_target(Node _target) {
        this._target = _target;
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
        return String.format("-> %c [%d MB, %d%%]", _target.get_label(), _bandwidth, _losses);
    }
}
