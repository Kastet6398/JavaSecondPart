package auth;

import annotations.UserAnnotation;

@UserAnnotation
public record RegularUser(User userDetails) implements UserType {

    public PremiumUser toPremium() {
        return new PremiumUser(userDetails);
    }

    @Override
    public void displayUserInfo(User user) {
        System.out.println(STR."Regular User: \{user.getFirstName()} \{user.getLastName()}");
    }
}
