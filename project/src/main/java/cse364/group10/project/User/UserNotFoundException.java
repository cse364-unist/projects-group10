package cse364.group10.project.User;

public class UserNotFoundException extends  RuntimeException {
    UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}