package User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        List<User> users = new ArrayList<>();
        users.add(new User("Serhii", "14fasd"));
        users.add(new User("Alina", "325345"));
        users.add(new User("Boris", "gehsve"));
        System.out.println("Do sortirovki \n"+ users);
        Collections.sort(users);
        System.out.println("Posle sortirovki \n" + users);
        userManager.serialize(users);
        System.out.println("Done!");
        System.out.println(userManager.deserialize());


    }
}
