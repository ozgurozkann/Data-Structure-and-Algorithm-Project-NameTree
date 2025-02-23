import java.util.HashMap;
import java.util.Map;

class Node {
    char value;
    int count;
    Map<Character, Node> children;

    public Node(char value) {
        this.value = value;
        this.count = 0;
        this.children = new HashMap<>();
    }

    // Düğümün belirli bir çocuğunu kaldıran metod.
    public void removeNode(Node node) {
        this.children.remove(node.value);
    }

    // Düğümün tüm çocuklarını temizleyen metod.
    public void removeAllNodes() {
        this.children.clear();
    }
}



