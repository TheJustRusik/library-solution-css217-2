package repositories.implementation;

import items.Item;

import java.util.ArrayList;

public class Library implements repositories.Library {
    private final repositories.Storage storage;
    public Library() {
        storage = new Storage();
    }
    public void storeItem(Item item) {
        storage.storeItem(item);
    }
    public ArrayList<Item> getAllItems() {
        return storage.getAllItems();
    }
    public void takeItem(String uuid) {
        storage.takeItem(uuid);
    }
    public Item getItem(String uuid) {
        return storage.getItem(uuid);
    }



}
