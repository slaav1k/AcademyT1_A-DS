package laba1;

import java.util.ArrayList;

public class NetGraph {
    private ArrayList<Node> _graph;

    public NetGraph() {
        _graph = new ArrayList<>();
    }

    public ArrayList<Node> get_graph() {
        return _graph;
    }

    public void set_graph(ArrayList<Node> _graph) {
        this._graph = _graph;
    }

    public void addElement(Node pNode) {
        _graph.add(pNode);
    }

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\nNETWORK GRAPH\n");

    for (Node node : _graph) {
        sb.append(node);
        sb.append("--------------------------------------------\n");
    }
    return sb.toString();
}
}
