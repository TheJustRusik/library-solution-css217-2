package items;

import java.util.UUID;

public class Book implements Item{
    private String name;
    private final String UUID;
    @Override
    public String getUUID() {
        return UUID;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getType() {
        return "Book";
    }

    public Book(String name) {
        this.name = name;
        this.UUID = java.util.UUID.randomUUID().toString();
    }
}
