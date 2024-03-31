package users;

import items.Item;
import java.util.ArrayList;
import java.util.Objects;

public class User implements UserBase {
    private final ArrayList<Item> items;
    private final String username;
    int itemsLimit = 3;
    @Override
    public void takeItem(Item item) throws Exception {
        if (itemsLimit > 0) {
            items.add(item);
            itemsLimit--;
        }
        else
            throw new Exception("Can't take more than 3 items!");
    }


    @Override
    public void returnItem(String uuid) {
        Item returning = items.stream().filter(
                item -> Objects.equals(item.getUUID(), uuid)
        ).findFirst().orElseThrow();

        items.remove(returning);
        itemsLimit++;
    }

    @Override
    public ArrayList<Item> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public String getUsername() {
        return username;
    }

    public User(String username) {
        this.username = username;
        items = new ArrayList<>();
    }
}
