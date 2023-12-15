package auth;

public sealed interface UserType permits RegularUser, PremiumUser {
    void displayUserInfo(User user);

    User userDetails();
}