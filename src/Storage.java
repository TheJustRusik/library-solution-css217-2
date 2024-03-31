import items.Item;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class Storage {
    HashMap<String, Item> items;

    public void takeItem(String UUID) {
        if (!items.containsKey(UUID)) {
            throw new NoSuchElementException("Item with UUID " + UUID + " not found");
        }
        items.remove(UUID);
    }
    public void storeItem(Item item) {
        items.put(item.getUUID(), item);
    }

    public Storage() {
        items = new HashMap<>();
    }
}
