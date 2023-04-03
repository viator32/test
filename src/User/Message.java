package User;


import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Message{
    private int charCounter;
    private String message;
    private String creationDate;

    public Message(String message) {
        this.message = message;
        this.charCounter = message.length();
        this.creationDate = String.valueOf(LocalDate.now());
    }

    public void setCharCounter(int charCounter) {
        this.charCounter = charCounter;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getCharCounter() {
        return charCounter;
    }

    public String getMessage() {
        return message;
    }

    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}

