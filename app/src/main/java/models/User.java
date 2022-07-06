package models;

public class User {

    private static String name;
    private static String email;
    private static String password;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static boolean verifyUserExistence(){
        return name != null && email != null && password != null;
    }
}
