package CrimeDatabase;

import java.util.ArrayList;
import java.util.Iterator;

public class Users {
    private static Users users = null;
    private ArrayList<User> userList = new ArrayList<User>();

    private Users() { 
        userList = DataLoader.loadUsers();
    }

    public static Users getInstance() {
        if(users == null) {
            users = new Users();
        }
        return users;
    }

    public ArrayList<User> getUsers() { 
        return userList;
    }

    public void addUser(int ID, String userName, String pass, String name, int age, String badgeID) { 
        userList.add(new User(ID,  userName,  pass,  name,  age,  badgeID));
        DataWriter.saveUsers();
    }

    public Iterator<User> createIterator() {
        return userList.iterator();
    }
}
