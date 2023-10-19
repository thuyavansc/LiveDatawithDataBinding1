package au.com.softclient.viewbinding1;

public class User {
    //int id;
    String name;
    int age;

    boolean logIn;

    public User(String name, int age, boolean logIn) {
        this.name = name;
        this.age = age;
        this.logIn = logIn;
    }

    public User() {
        this.name = name;
        this.age = age;
        this.logIn = logIn;
    }

    // Getter for id
    //

    // Setter for id
    //

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for logIn
    public boolean isLogIn() {
        return logIn;
    }

    // Setter for logIn
    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }
}
