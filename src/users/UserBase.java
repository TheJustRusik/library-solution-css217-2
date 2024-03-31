package users;

import items.Item;

public interface UserBase {
    String getUsername();
    void takeItem(Item item) throws Exception;
}
