import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree nameTree = new Tree();

        // İsimleri eklemek
        System.out.println("Enter names (press Enter to finish):");
        while (true) {
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            nameTree.addName(name);
        }

        // İsimleri ekledikten sonra ağacı yazdırmak
        System.out.println("\nTree after inserting names:");
        nameTree.printTree();

        // İsimleri güncellemek
        System.out.println("\nEnter names to update (oldName newName), or press Enter to skip:");
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            String[] names = input.split(" ");
            if (names.length == 2) {
                nameTree.updateName(names[0], names[1]);
                System.out.println("\nTree after updating names:");
                nameTree.printTree();
            } else {
                System.out.println("Invalid input. Please provide oldName and newName separated by a space.");
            }
        }

        scanner.close();
    }
}


