package cse364.group10.project.User;

public class UserNotFoundException extends  RuntimeException {
    UserNotFoundException(String id) {
        super("Could not find user " + id);
    }
}