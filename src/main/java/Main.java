import controllers.MainController;

public class Main {
    public static void main(String[] args) {
        MainController c = new MainController();
        c.start();

        // To close the window programmatically, use this:
        // c.stop();
        // or in controller:
        // screen.stop();
    }
}
