package cse364.group10.project.Users;

public class UserNotFoundException extends  RuntimeException {
    UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
