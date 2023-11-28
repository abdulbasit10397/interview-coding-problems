package venturedive.question1;

import java.util.*;
import java.io.*;

/**
 * An OOP knowledge evaluation question to implement methods as per given instructions
 */
interface IUser {
    public int getId();
    public void setId(int id);
    public String getEmail();
    public void setEmail(String email);
    public String getPassword();
    public void setPassword(String password);
    public int getIncorrectAttempt();
    public void setIncorrectAttempt(int incorrectAttempt);
    public String getLocation();
    public void setLocation(String location);

}

interface IApplicationAuthState {
    public List<IUser> getRegisteredUsers();
    public void setRegisteredUsers(List<IUser> registeredUsers);
    public List<IUser> getUsersLoggedIn();
    public void setUsersLoggedIn(List<IUser> usersLoggedIn);
    public List<String> getAllowedLocations();
    public void setAllowedLocations(List<String> allowedLocations);
    public String Register(IUser user);
    public String Login(IUser user);
    public String Logout(IUser user);
}

/*
 * These strings can be copied and pasted to avoid typing errors.
 * User1@email.com should be replaced with the correct user email.
 *
 * User1@email.com registered successfully!
 * User1@email.com is not registered!
 * User1@email.com is not logged in!
 * User1@email.com is already registered!
 * User1@email.com logged in successfully!
 * User1@email.com logged out successfully!
 * User1@email.com is already logged in!
 * User1@email.com is already logged in from another location!
 * User1@email.com is blocked!
 * User1@email.com is not allowed to login from this location!
 * User1@email.com password is incorrect!
 */

// Implement User and ApplicationAuthState class.

class User implements IUser {
    private int id;
    private String email;
    private String password;
    private String location;

    private int incorrectAttempt;


    public User(int id, String email, String password, String location) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.location = location;
        this.incorrectAttempt = 0;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public int getIncorrectAttempt() {
        return 0;
    }

    @Override
    public void setIncorrectAttempt(int incorrectAttempt) {

    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public void setLocation(String location) {

    }
}

class ApplicationAuthState implements  IApplicationAuthState {
    private List<String> allowedLocations;
    private List<IUser> registeredUsers;
    private List<IUser> usersLoggedIn;
    public ApplicationAuthState(List <String> allowedLocations) {
        this.allowedLocations = allowedLocations;
        this.registeredUsers = new ArrayList<>();
        this.usersLoggedIn = new ArrayList<>();
    }

    @Override
    public List<IUser> getRegisteredUsers() {
        return null;
    }

    @Override
    public void setRegisteredUsers(List<IUser> registeredUsers) {

    }

    @Override
    public List<IUser> getUsersLoggedIn() {
        return null;
    }

    @Override
    public void setUsersLoggedIn(List<IUser> usersLoggedIn) {

    }

    @Override
    public List<String> getAllowedLocations() {
        return null;
    }

    @Override
    public void setAllowedLocations(List<String> allowedLocations) {

    }

    @Override
    public String Register(IUser user) {
        IUser isUserAlreadyRegistered = lookupUser(registeredUsers, user);
        if(Objects.nonNull(isUserAlreadyRegistered)) {
            return user.getEmail() + " is already registered!";
        }

        registeredUsers.add(user);
        return user.getEmail() + " registered successfully!";
    }

    @Override
    public String Login(IUser user) {
        IUser userRegistered = lookupUser(registeredUsers, user);
        if(Objects.isNull(userRegistered)) {
            return user.getEmail() + " is not registered!";
        }

        IUser userAlreadyLoggedIn = lookupUser(usersLoggedIn, user);
        if (Objects.nonNull(userAlreadyLoggedIn) && userAlreadyLoggedIn.getIncorrectAttempt() <3) {
            if(userAlreadyLoggedIn.getLocation().equals(user.getLocation())) {
                return user.getEmail() + " is already logged in!";
            } else {
                return user.getEmail() + " is already logged in from another location!";
            }
        }

        if (!verifyLoginLocation(user.getLocation())) {
            return user.getEmail() + " is not allowed to login from this location!";
        }

        return doLogin(userAlreadyLoggedIn, user);
    }


    private String doLogin (IUser loggedInUser, IUser userToLogin) {
        if (loggedInUser.getIncorrectAttempt() >=3) {
            return userToLogin.getEmail() + " is blocked!";
        }

        if (loggedInUser.getPassword().equals(userToLogin.getPassword())) {
            userToLogin.setIncorrectAttempt(0);
            usersLoggedIn.add(userToLogin);
            return userToLogin.getEmail() + " logged in successfully!";
        } else {
            userToLogin.setIncorrectAttempt(userToLogin.getIncorrectAttempt() + 1);
            usersLoggedIn.add(userToLogin);
            return userToLogin.getEmail() + " password is incorrect!";
        }
    }


    private boolean verifyLoginLocation (String location) {
        for (String allowedLocation : allowedLocations) {
            if(location.equals(allowedLocation)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String Logout(IUser user) {
        IUser userAlreadyLoggedIn = lookupUser(usersLoggedIn, user);

        if(Objects.isNull(userAlreadyLoggedIn)) {
            return user.getEmail() + " is not logged in!";
        }

        usersLoggedIn.remove(userAlreadyLoggedIn);
        return user.getEmail() + " logged out successfully!";
    }

    private IUser lookupUser (List<IUser> users, IUser user) {
        String emailToFind = user.getEmail();

        for (IUser userInList : users) {
            if(userInList.getEmail().equals(emailToFind)) {
                return userInList;
            }
        }

        return null;
    }
}



public class Question1 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        List <IUser> users = new ArrayList <IUser> ();
        List <String> allowedLocations = new ArrayList <String> ();

        int allowedLocationCount = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i <allowedLocationCount; i++) {
            String a = bufferedReader.readLine().trim();
            allowedLocations.add(a);
        }
        ApplicationAuthState authState = new ApplicationAuthState(allowedLocations);

        int usersCount = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i <usersCount; i++) {
            String[] a = bufferedReader.readLine().trim().split(",");
            users.add(new User(Integer.parseInt(a[0]), a[1], a[2], a[3]));
        }

        int actionCount = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i <actionCount; i++) {
            String[] a = bufferedReader.readLine().trim().split(":");
            int uIndex = Integer.parseInt(a[1]);
            if (a[0].equals("Register")) {
                writer.println(authState.Register(users.get(uIndex)));
            } else if (a[0].equals("Login")) {
                writer.println(authState.Login(users.get(uIndex)));
            } else if (a[0].equals("Logout")) {
                writer.println(authState.Logout(users.get(uIndex)));
            }
        }

        writer.close();
    }
}