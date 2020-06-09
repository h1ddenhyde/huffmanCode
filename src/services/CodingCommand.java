package services;

import model.InnerNode;
import model.LeafNode;
import model.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CodingCommand implements Command {
    HashMap<Character, AtomicInteger> letterInfo;
    HashMap<String, String> codes;
    StringBuilder word;
    PriorityQueue<Node> queue;

    @Override
    public void execute() {
        init();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        countNumbers(s);

        while (queue.size() > 1) {
            Node n1 = queue.poll();
            Node n2 = queue.poll();
            queue.add(new InnerNode(n1.getWeight() + n2.getWeight(), n1, n2));
        }

        codes = queue.peek().buildCode();

        for (char ch : s.toCharArray())
            word.append(queue.peek().codeString(ch));

    }

    public String getResult() {
        return word.toString();
    }


    public void printResult() {
        System.out.println(letterInfo.size() + " " + word.length());
        System.out.println(codes.toString());
        System.out.println(word.toString());
    }

    private HashMap<Character, AtomicInteger> countNumbers(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            if (letterInfo.containsKey(chars[i])) {
                letterInfo.get(chars[i]).incrementAndGet();
            } else {
                letterInfo.put(chars[i], new AtomicInteger(1));
            }
        }
        for (Character character : letterInfo.keySet()) {
            queue.add(new LeafNode(character, letterInfo.get(character).get()));
        }
        return letterInfo;
    }

    private void init() {
        codes = new HashMap<>();
        word = new StringBuilder();
        letterInfo = new HashMap<>();
        queue = new PriorityQueue(33, Node.inputComparator);
    }
}
