package laba1;

import java.util.ArrayList;

public class Node {
    private char _label;
    private ArrayList<NodeLink> _links;

    public Node(char pLabel) {
        _label = pLabel;
        _links = new ArrayList<>();
    }

    public char get_label() {
        return _label;
    }

    public void set_label(char _label) {
        this._label = _label;
    }

    public ArrayList<NodeLink> get_links() {
        return _links;
    }

    public void set_links(ArrayList<NodeLink> _links) {
        this._links = _links;
    }

    public void addLink(Node pOther, int pBandwidth, int pLosses) {
        _links.add(new NodeLink(pOther, pBandwidth, pLosses));
        pOther._links.add(new NodeLink(this, pBandwidth, pLosses));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(_label).append(" connects to:\n");

        if (_links.isEmpty()) {
            sb.append("  [ no connections ]\n");
        } else {
            for (NodeLink link : _links) {
                sb.append("  ").append(link).append("\n");
            }
        }
        return sb.toString();
    }


}
