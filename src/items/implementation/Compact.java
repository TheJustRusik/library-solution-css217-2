package items.implementation;

import items.Item;

public class Compact implements Item {
    private final String name;
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
        return "Compact";
    }

    public Compact(String name) {
        this.name = name;
        this.UUID = java.util.UUID.randomUUID().toString();
    }
}
