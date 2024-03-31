import users.StuffBase;
import users.UserBase;

import java.util.ArrayList;
import java.util.Scanner;

public class CLI {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<StuffBase> stuffs;
    private ArrayList<UserBase> users;
    private Library library;
    public CLI(Library library, ArrayList<StuffBase> stuffs, ArrayList<UserBase> users) {
        this.library = library;
        this.stuffs = stuffs;
        this.users = users;
    }
    public void run() {
        while (true) {
            System.out.print(
                    """
                    Available commands:
                        1 - Switch to client
                        2 - Switch to employee
                        3 - Switch to library
                        Any - Exit
                    Input:\s"""
            );
            String input = sc.next();
            switch (input){
                case "1" -> {
                    System.out.println("Choose user:");
                    int i = 0;
                    users.forEach(c -> System.out.println("    " + i + " " + c.getUsername()));
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
                    System.out.println("Choose stuff:");
                    int i = 0;
                    users.forEach(c -> System.out.println("    " + i + " " + c.getUsername()));
                    System.out.print(
                            """
                                Any - Exit
                            Input:\s"""
                    );
                    try{
                        int stuffIndex = sc.nextInt();
                        StuffBase stuff = stuffs.get(stuffIndex);
                        stuffCommands(stuff);
                    }catch (Exception ignored){

                    }

                }
                case "3" -> libraryCommands();
                default -> {
                    return;
                }

            }

        }
    }

    private void stuffCommands(StuffBase stuff) {
        while (true) {
            System.out.print(
                """
                Available commands:
                    1 - Add new Item
                    Any - Exit
                Input:\s"""
            );
            switch (sc.next()) {
                case "1" -> {
                    System.out.print("Provide type: ");
                    String type = sc.next();
                    System.out.print("Provide " + type + "'s title: ");
                    String title = sc.next();
                    library.storeItem(stuff.createItem(type, title));
                }
                default -> {
                    return;
                }
            }
        }

    }
    private void userCommands(UserBase userBase) {
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

            }
        }
    }
    private void libraryCommands() {
        System.out.println(
                """
                Available commands:
                    1 - Show all books
                    Any - Exit
                """
        );
    }

}
