package users;

import items.Item;

public interface StaffBase {
    String getUsername();
    Item createItem(String type, String title) throws Exception;
}
