package items;

public class Magazine implements Item {
    private final String UUID;
    private final String name;
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
