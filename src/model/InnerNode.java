package model;

import java.util.HashMap;

public class InnerNode extends Node {
    Node lNode;
    Node rNode;

    public InnerNode(int weight, Node lNode, Node rNode) {
        super(weight);
        this.lNode = lNode;
        this.rNode = rNode;
    }

    @Override
    public HashMap<String, String> buildCode() {
        HashMap<String, String> codes = new HashMap<String, String>();
        lNode.code.append(code).append("0");
        codes.putAll(lNode.buildCode());
        rNode.code.append(code).append("1");
        codes.putAll(rNode.buildCode());
        return codes;
    }

    @Override
    public StringBuilder codeString(char word) {
        if (lNode.codeString(word) == null) {
            return rNode.codeString(word);
        } else
            return lNode.codeString(word);
    }


    public Node getlNode() {
        return lNode;
    }

    public void setlNode(Node lNode) {
        this.lNode = lNode;
    }

    public Node getrNode() {
        return rNode;
    }

    public void setrNode(Node rNode) {
        this.rNode = rNode;
    }
}
