package v1.task3;

public class Main {
    public static void main(String[] args) {
        Steak steak = new Steak();
        Soup soup = new Soup();
        cookDishes(steak, soup);
    }

    public static void cookDishes(Dish... dishes) {
        for (Dish dish : dishes) dish.cook();
    }
}
