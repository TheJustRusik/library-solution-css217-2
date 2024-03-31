import items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Storage {
    private HashMap<String, Item> items;

    public Item takeItem(String UUID) {
        if (!items.containsKey(UUID)) {
            throw new NoSuchElementException("Item with UUID " + UUID + " not found");
        }
        return items.remove(UUID);
    }
    public void storeItem(Item item) {
        items.put(item.getUUID(), item);
    }
    public ArrayList<Item> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public Storage() {
        items = new HashMap<>();
    }
}
