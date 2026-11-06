/**
 * Represents one lost or found item.
 */
public class Item {
    private final int id;
    private final String type;
    private final String name;
    private final String description;
    private final String location;
    private final String date;
    private final String contact;
    private boolean returned;

    public Item(int id, String type, String name, String description,
                String location, String date, String contact) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.contact = contact;
        this.returned = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + "\nType: " + type
                + "\nItem: " + name
                + "\nDescription: " + description
                + "\nLocation: " + location
                + "\nDate: " + date
                + "\nContact: " + contact
                + "\nStatus: " + (returned ? "RETURNED" : "OPEN");
    }
}
