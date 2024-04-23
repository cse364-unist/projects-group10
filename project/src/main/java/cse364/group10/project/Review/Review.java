package cse364.group10.project.Review;

import cse364.group10.project.Users.Users;
public class Review {
    private Users user;
    private String comments;

    public Users getUser() {
        return user;
    }

    public String getComments() {
        return comments;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
