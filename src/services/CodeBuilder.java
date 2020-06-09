package services;

import model.Node;

import java.util.HashMap;
import java.util.PriorityQueue;

public class CodeBuilder {
    PriorityQueue<Node> queue;

    public CodeBuilder(PriorityQueue<Node> queue) {
        this.queue = queue;
    }

}
