package users;

import items.Item;

public interface StuffBase {
    String getUsername();
    Item createItem(String type, String title);
}
