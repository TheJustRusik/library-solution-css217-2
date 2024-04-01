package repositories;

import items.Item;
import java.util.ArrayList;

public interface Library {
    void storeItem(Item item);
    ArrayList<Item> getAllItems();
    void takeItem(String uuid);
    Item getItem(String uuid);
}
