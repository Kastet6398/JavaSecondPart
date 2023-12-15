package auth;

import annotations.UserAnnotation;

@UserAnnotation
public record PremiumUser(User userDetails) implements UserType {

    public RegularUser toRegular() {
        return new RegularUser(userDetails);
    }

    @Override
    public void displayUserInfo(User user) {
        System.out.println(STR."Premium User: \{user.getFirstName()} \{user.getLastName()}");
    }
}
