package users.implementation;

import items.implementation.Book;
import items.implementation.Compact;
import items.Item;
import items.implementation.Magazine;
import users.StaffBase;

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
    public Item createItem(String type, String name) throws Exception {
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
            default -> throw new Exception("Non existing type!");
        }
    }



}
