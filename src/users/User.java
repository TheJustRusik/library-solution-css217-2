package users;

import items.Item;

import java.util.ArrayList;

public class User implements UserBase {
    ArrayList<Item> items;
    String username;
    int itemsLimit = 3;
    @Override
    public void takeItem(Item item) throws Exception {
        if (itemsLimit > 0)
            items.add(item);
        else
            throw new Exception("Can't take more than 3 items!");
    }
    @Override
    public String getUsername() {
        return username;
    }

    public User() {
        items = new ArrayList<>();
    }
}
