package users;

import items.Item;

import java.util.ArrayList;
import java.util.Objects;

public class Patron implements UserBase {
    private String username;
    private final ArrayList<Item> items;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void takeItem(Item item) {
        items.add(item);
    }

    @Override
    public void returnItem(String uuid) {
        Item returning = items.stream().filter(
                item -> Objects.equals(item.getUUID(), uuid)
        ).findFirst().orElseThrow();

        items.remove(returning);
    }

    @Override
    public ArrayList<Item> getItems() {
        return new ArrayList<>(items);
    }

    public Patron(String username) {
        this.username = username;
        items = new ArrayList<>();
    }
}
