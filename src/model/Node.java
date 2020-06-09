package model;

import java.util.Comparator;
import java.util.HashMap;

public abstract class Node {
    int weight;
    StringBuilder code;
    public final static Comparator<Node> inputComparator;

    static {
        inputComparator = (c1, c2) -> (int) (c1.weight - c2.weight);
    }

    {
        code = new StringBuilder();
    }

    public abstract HashMap<String, String> buildCode();

    public abstract StringBuilder codeString(char word);

    public Node(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }

    public StringBuilder getCode() {
        return code;
    }

    public void setCode(StringBuilder code) {
        this.code = code;
    }
}
