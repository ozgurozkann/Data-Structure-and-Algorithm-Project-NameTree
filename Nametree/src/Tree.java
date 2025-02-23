class Tree {
    private Node root;

    public Tree() {
        this.root = new Node(' ');
    }

    // Kullanıcıdan alınan ismi ağaca ekleyen metod.
    public void addName(String name) {
        Node current = root;

        for (char c : name.toLowerCase().toCharArray()) {
            current.children.putIfAbsent(c, new Node(c));
            current = current.children.get(c);
            current.count++;
        }
    }

    public void updateName(String oldName, String newName) {
        // Eski ismi ağaçtan kaldırmak
        removeName(oldName);
        // Yeni ismi ağaca eklemek
        addName(newName);
    }

    public void removeName(String name) {
        Node current = root;
        Node parent = null;

        // Eski ismi ağaçta aramak
        for (char c : name.toLowerCase().toCharArray()) {
            if (!current.children.containsKey(c)) {
                System.out.println("Name not found for update: " + name);
                return;
            }
            parent = current;
            current = current.children.get(c);
        }

        // Eski ismi ağaçtan kaldırmak
        if (parent != null) {
            parent.removeNode(current);
        }

        // Eski ismin altındaki tüm düğümleri temizlemek
        current.removeAllNodes();
    }

    // Ağacı düzenli bir şekilde yazdırma
    private void printTree(Node node, String pre, boolean tailKontrol) {
        System.out.println(pre + (tailKontrol ? "└── " : "├── ") + "(" + node.value + ":" + node.count + ")");
        for (int i = 0; i < node.children.size() - 1; i++) {
            printTree((Node) node.children.values().toArray()[i], pre + (tailKontrol ? "    " : "│   "), false);
        }
        if (!node.children.isEmpty()) {
            printTree((Node) node.children.values().toArray()[node.children.size() - 1], pre + (tailKontrol ? "    " : "│   "), true);
        }
    }

    public void printTree() {
        printTree(root, "", true);
    }
}