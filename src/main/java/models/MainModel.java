package models;

import views.BaseScreen;

public class MainModel {
    private final BaseScreen screen;
    public MainModel(BaseScreen screen) {
        this.screen = screen;
    }
    public void changeName() {
        System.out.println("Hello");
    }
}
