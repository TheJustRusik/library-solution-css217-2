package users;

import items.Item;

import java.util.ArrayList;

public interface UserBase {
    String getUsername();
    void takeItem(Item item) throws Exception;
    void returnItem(String uuid) throws Exception;
    ArrayList<Item> getItems();
}
