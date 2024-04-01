import items.Item;
import users.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CLI {
    static Scanner sc = new Scanner(System.in);
    private final ArrayList<StaffBase> staffs;
    private final ArrayList<UserBase> users;
    private final Library library;
    public CLI(Library library, ArrayList<StaffBase> staffs, ArrayList<UserBase> users) {
        this.library = library;
        this.staffs = staffs;
        this.users = users;
    }
    public void run() {
        while (true) {
            System.out.print(
                    """
                    Available commands:
                        1 - Switch to users
                        2 - Switch to staffs
                        3 - Switch to library
                        4 - Add new User
                        5 - Add new Staff
                        Any - Exit
                    Input:\s"""
            );
            String input = sc.next();
            switch (input){
                case "1" -> {
                    System.out.println("Choose user:");
                    AtomicInteger i = new AtomicInteger(0);
                    users.forEach(c -> System.out.println("    " + i.getAndIncrement() + " - " + c.getUsername()));
                    System.out.print(
                            """
                                Any - Exit
                            Input:\s"""
                    );
                    try{
                        int userIndex = sc.nextInt();
                        UserBase user = users.get(userIndex);
                        userCommands(user);
                    }catch (Exception ignored){

                    }

                }
                case "2" -> {
                    System.out.println("Choose staff:");
                    AtomicInteger i = new AtomicInteger(0);
                    staffs.forEach(c -> System.out.println("    " + i.getAndIncrement() + " - " + c.getUsername()));
                    System.out.print(
                            """
                                Any - Exit
                            Input:\s"""
                    );
                    try{
                        int staffIndex = sc.nextInt();
                        StaffBase staff = staffs.get(staffIndex);
                        staffCommands(staff);
                    }catch (Exception ignored){

                    }
                }
                case "3" -> libraryCommands();
                case "4" -> {
                    System.out.print("""
                            Which User?
                                1 - User
                                2 - Patron
                            Input:\s""");
                    String type = sc.next();
                    System.out.print("Username: ");
                    String username = sc.next();
                    switch (type) {
                        case "1" -> users.add(new User(username));
                        case "2" -> users.add(new Patron(username));
                    }
                }
                case "5" -> {
                    System.out.print("Username: ");
                    String name = sc.next();
                    staffs.add(new Librarian(name));
                }
                default -> {
                    return;
                }
            }

        }
    }

    private void staffCommands(StaffBase staff) {
        while (true) {
            System.out.print(
                    """
                    Available commands:
                        1 - Create new item
                        2 - Delete item
                        Any - Exit
                    Input:\s"""
            );
            switch (sc.next()) {
                case "1" -> {
                    System.out.print("""
                        Which type of item you want create?
                            1 - Book
                            2 - Magazine
                            3 - Compact
                            Any - Abort operation
                        Input:\s""");
                    switch (sc.next()) {
                        case "1" -> {
                            System.out.print("Book name: ");
                            library.storeItem(staff.createItem("Book", sc.next()));
                        }
                        case "2" -> {
                            System.out.print("Magazine name: ");
                            library.storeItem(staff.createItem("Magazine", sc.next()));
                        }
                        case "3" -> {
                            System.out.print("Compact name: ");
                            library.storeItem(staff.createItem("Compact", sc.next()));
                        }
                    }
                }
                case "2" -> {
                    System.out.println("Choose item to delete: ");
                    var i = new AtomicInteger(0);
                    library.getAllItems().forEach(item ->
                            System.out.println("    " + i.getAndIncrement() + " " + item.getName() + " " + item.getUUID())
                    );
                    var itemUUIDS = new ArrayList<>(library.getAllItems().stream().map(Item::getUUID).toList());
                    System.out.print("""
                                Any - Exit
                            Input:\s""");
                    try{
                        int itemIndex = sc.nextInt();
                        library.takeItem(itemUUIDS.get(itemIndex));
                    }catch (Exception ignored){

                    }
                }
                default -> {
                    return;
                }
            }
        }

    }
    private void userCommands(UserBase userBase) {
        while (true) {
            System.out.print(
                    """
                            Available commands:
                                1 - Take item
                                2 - Return item
                                3 - Show my items
                                Any - Exit
                            Input:\s"""
            );

            switch (sc.next()) {
                case "1" -> {
                    System.out.println("Choose what to take:");
                    AtomicInteger i = new AtomicInteger(0);
                    library.getAllItems().forEach(item -> System.out.println("    " + i.getAndIncrement() + " - " + item.getName() + " " + item.getType()));
                    ArrayList<String> itemsUUIDS = new ArrayList<>(library.getAllItems().stream().map(Item::getUUID).toList());
                    System.out.print("""
                                Any - Exit
                            Input:\s""");
                    try {
                        int itemIndex = sc.nextInt();
                        Item itemToTake;
                        if( (itemToTake = library.getItem(itemsUUIDS.get(itemIndex))) != null ){
                            userBase.takeItem(itemToTake);
                            library.takeItem(itemsUUIDS.get(itemIndex));
                        }
                    } catch (Exception ignored) {

                    }
                }
                case "2" -> {
                    System.out.println("Choose what to return:");
                    AtomicInteger i = new AtomicInteger(0);
                    userBase.getItems().forEach(item -> System.out.println("    " + i.getAndIncrement() + " - " + item.getName() + " " + item.getType()));
                    ArrayList<String> itemsUUIDS = new ArrayList<>(userBase.getItems().stream().map(Item::getUUID).toList());
                    System.out.print("""
                                Any - Exit
                            Input:\s""");
                    try {
                        int itemIndex = sc.nextInt();
                        library.storeItem(
                                userBase.returnItem(itemsUUIDS.get(itemIndex))
                        );
                    }catch (Exception ignored) {

                    }
                }
                case "3" -> {
                    System.out.println("Items:");
                    AtomicInteger i = new AtomicInteger(0);
                    userBase.getItems().forEach(item -> System.out.println("    " + i.getAndIncrement() + " - " + item.getName() + " " + item.getType() + " " + item.getUUID()));
                    System.out.println("End.");
                }
                default -> {
                    return;
                }

            }
        }
    }
    private void libraryCommands() {
        while (true) {
            System.out.print(
                    """
                    Available commands:
                        1 - List all items
                        2 - List all Books
                        3 - List all Compacts
                        4 - List all Magazines
                        Any - Exit
                    Input:\s"""
            );

            switch (sc.next()) {
                case "1" -> {
                    System.out.println("Library items:");
                    library.getAllItems().forEach(item -> System.out.println(item.getName() + " " + item.getType() + " " + item.getUUID()));
                    System.out.println("End");
                }
                case "2" -> {
                    System.out.println("Library books:");
                    library.getAllItems().stream()
                            .filter(item ->
                                    Objects.equals(item.getType(), "Book")
                            ).forEach(item ->
                                    System.out.println(item.getName() + " "  + item.getUUID())
                            );
                    System.out.println("End");
                }
                case "3" -> {
                    System.out.println("Library compacts:");
                    library.getAllItems().stream()
                            .filter(item ->
                                    Objects.equals(item.getType(), "Compact")
                            ).forEach(item ->
                                    System.out.println(item.getName() + " "  + item.getUUID())
                            );
                    System.out.println("End");
                }
                case "4" -> {
                    System.out.println("Library magazines:");
                    library.getAllItems().stream()
                            .filter(item ->
                                    Objects.equals(item.getType(), "Magazine")
                            ).forEach(item ->
                                    System.out.println(item.getName() + " "  + item.getUUID())
                            );
                    System.out.println("End");
                }
                default -> {
                    return;
                }
            }
        }

    }

}
