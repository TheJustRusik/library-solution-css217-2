import repositories.Library;
import users.StaffBase;
import users.UserBase;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<StaffBase> employees = new ArrayList<>();
        ArrayList<UserBase> clients = new ArrayList<>();
        Library library = new repositories.implementation.Library();
        CLI cli = new CLI(library, employees, clients);

        cli.run();
    }
}