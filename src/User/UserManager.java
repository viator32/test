package User;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserManager implements ObjectManager<User>{
    @Override
    public void serialize(List<User> users) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.dat")) ){
        objectOutputStream.writeObject(users);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> deserialize() {
        List<User> list = new ArrayList<>();

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.dat"))){
            list = (ArrayList) objectInputStream.readObject();

        }
        catch (IOException e){
           throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
