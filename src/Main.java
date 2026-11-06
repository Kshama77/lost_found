import java.util.ArrayList;
import java.util.Scanner;

/**
 * LostFound - a simple console application for tracking lost and found items.
 * Beginner Java concepts: classes, objects, ArrayList, loops, conditionals,
 * methods, and user input with Scanner.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Item> items = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("================================");
        System.out.println("       LOST & FOUND TRACKER");
        System.out.println("================================");

        while (running) {
            showMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addItem("LOST");
                    break;
                case "2":
                    addItem("FOUND");
                    break;
                case "3":
                    viewItems();
                    break;
                case "4":
                    searchItems();
                    break;
                case "5":
                    markAsReturned();
                    break;
                case "6":
                    deleteItem();
                    break;
                case "0":
                    running = false;
                    System.out.println("Thank you for using LostFound. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n------------- MENU -------------");
        System.out.println("1. Report a lost item");
        System.out.println("2. Report a found item");
        System.out.println("3. View all items");
        System.out.println("4. Search items");
        System.out.println("5. Mark item as returned");
        System.out.println("6. Delete an item");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
    }

    private static void addItem(String type) {
        System.out.println("\n--- Report " + type + " Item ---");
        System.out.print("Item name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Item name cannot be empty.");
            return;
        }

        System.out.print("Description: ");
        String description = scanner.nextLine().trim();

        System.out.print("Location: ");
        String location = scanner.nextLine().trim();

        System.out.print("Date (example: 2026-11-06): ");
        String date = scanner.nextLine().trim();

        System.out.print("Your contact information: ");
        String contact = scanner.nextLine().trim();

        Item item = new Item(nextId++, type, name, description, location, date, contact);
        items.add(item);
        System.out.println("Item reported successfully. Item ID: " + item.getId());
    }

    private static void viewItems() {
        System.out.println("\n--- All Lost and Found Items ---");
        if (items.isEmpty()) {
            System.out.println("No items have been reported yet.");
            return;
        }

        for (Item item : items) {
            System.out.println(item);
            System.out.println("--------------------------------");
        }
    }

    private static void searchItems() {
        System.out.print("\nEnter an item name or keyword: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        if (keyword.isEmpty()) {
            System.out.println("Please enter a search keyword.");
            return;
        }

        boolean found = false;
        for (Item item : items) {
            if (item.getName().toLowerCase().contains(keyword)
                    || item.getDescription().toLowerCase().contains(keyword)
                    || item.getLocation().toLowerCase().contains(keyword)) {
                System.out.println(item);
                System.out.println("--------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching items found.");
        }
    }

    private static void markAsReturned() {
        System.out.print("\nEnter the item ID to mark as returned: ");
        int id = readInteger();

        Item item = findItemById(id);
        if (item == null) {
            System.out.println("Item ID not found.");
        } else {
            item.setReturned(true);
            System.out.println("Item #" + id + " marked as returned.");
        }
    }

    private static void deleteItem() {
        System.out.print("\nEnter the item ID to delete: ");
        int id = readInteger();

        Item item = findItemById(id);
        if (item == null) {
            System.out.println("Item ID not found.");
        } else {
            items.remove(item);
            System.out.println("Item #" + id + " deleted successfully.");
        }
    }

    private static int readInteger() {
        String value = scanner.nextLine().trim();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

    private static Item findItemById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
