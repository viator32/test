package User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable, Comparable<User>{
    private final String benutzername;
    private transient final  String password;

    private List<Message> messages = new ArrayList<>();

    public List<Message> getMessages() {
        return messages;
    }
    public void addMessageToUser(Message m){
        messages.add(m);
    }

    public User(String benutzername, String password) {
        this.benutzername = benutzername;
        this.password = password;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int compareTo(User u) {
      return this.benutzername.compareTo(u.benutzername);
    }

    @Override
    public String toString() {
        return "User{" +
                "benutzername='" + benutzername + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

