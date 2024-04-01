package repositories;

import items.Item;

import java.util.ArrayList;

public interface Storage {
    Item takeItem(String UUID);
    void storeItem(Item item);
    Item getItem(String UUID);
    ArrayList<Item> getAllItems();
}
