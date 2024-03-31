package items;

import items.Item;

import java.util.UUID;

public class Magazine implements Item {
    private String UUID;
    private String name;
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
        return "Magazine";
    }

    public Magazine(String name) {
        this.name = name;
        this.UUID = java.util.UUID.randomUUID().toString();
    }
}
