import items.Item;

import java.util.ArrayList;

public class Library {
    private final Storage storage;
    public Library() {
        storage = new Storage();
    }
    public void storeItem(Item item) {
        storage.storeItem(item);
    }
    public ArrayList<Item> getAllItems() {
        return storage.getAllItems();
    }
    public Item takeItem(String uuid) {
        return storage.takeItem(uuid);
    }



}
