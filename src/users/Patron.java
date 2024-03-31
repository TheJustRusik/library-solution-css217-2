package users;

import items.Item;

import java.util.ArrayList;

public class Patron implements UserBase {
    ArrayList<Item> items;

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public void takeItem(Item item) {
        items.add(item);
    }

    public Patron() {
        items = new ArrayList<>();
    }
}
