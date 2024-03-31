package users;

import items.Book;
import items.Compact;
import items.Item;
import items.Magazine;

public class Librarian implements StaffBase {
    private final String name;

    public Librarian(String name) {
        this.name = name;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public Item createItem(String type, String name) {
        switch (type) {
            case "Book" -> {
                return new Book(name);
            }
            case "Magazine" -> {
                return new Magazine(name);
            }
            case "Compact" -> {
                return new Compact(name);
            }
        }
        throw null;
    }



}
