import items.Item;

public class Library {
    private final Storage storage;

    public Library() {
        storage = new Storage();
    }

    public void storeItem(Item item) {
        storage.storeItem(item);
    }





}
