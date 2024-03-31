package users;

import items.Book;
import items.Compact;
import items.Item;
import items.Magazine;

import java.util.UUID;

public class Librarian implements StuffBase{
    @Override
    public String getUsername() {
        return null;
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
