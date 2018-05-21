package models.base;

import models.TodoState;

public class Todo extends Item {

    private TodoState state;

    public Todo(String title, String description, TodoState state) {
        super(title, description);
        this.state = state;
    }

    public TodoState getState() {
        return state;
    }

    public void setState(TodoState state) {
        this.state = state;
    }

    @Override
    public void showDescription() {
        System.out.println();
        System.out.printf("Title: %s\n", this.getTitle());
        System.out.printf("Description: %s\n", this.getDescription());
        System.out.printf("State: %s\n", this.getState());
        System.out.println();
    }
}
