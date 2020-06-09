package model;

import java.util.HashMap;

public class LeafNode extends Node {
    char aChar;

    public LeafNode(char aChar, int weight) {
        super(weight);
        this.aChar = aChar;

    }

    @Override
    public HashMap<String, String> buildCode() {
        if ("".equals(code.toString())) {
            code.append("0");
        }
        HashMap<String, String> codesMap = new HashMap<>();
        codesMap.put(String.valueOf(aChar), code.toString());
        return codesMap;
    }

    @Override
    public StringBuilder codeString(char word) {
        return aChar == word ? code : null;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }
}
