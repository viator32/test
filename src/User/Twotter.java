package User;

import java.util.List;

public class Twotter {
    public static void main(String[] args) {


    TwotterSystem sys = new TwotterSystem();

    User u1 = new User("Serhii", "32532");
    User u2 = new User("Alina", "32532");

    sys.addMessage(u1, new Message("Hello World"));
    sys.addMessage(u2, new Message("boiiii"));
    sys.addMessage(u1, new Message("esaegwgeqegqwgqq"));

    List<Message> a = sys.getAllMessages();
    List<Message> m = sys.getAllMessagesFromDate("2023-02-05");
    List<Message> d = sys.getAllMessagesFromUser(u2);
    System.out.println(a+"\n"+m+"\n"+d);
    System.out.println(sys.registerMasseges.get(1).getCreationDate());
}
}