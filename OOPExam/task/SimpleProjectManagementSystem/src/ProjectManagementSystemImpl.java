import base.ProjectManagementSystem;
import models.TicketPriority;
import models.TodoState;
import models.base.Item;
import models.base.Task;
import models.base.Ticket;
import models.base.Todo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManagementSystemImpl implements ProjectManagementSystem {

    private List<Item> assignments;

    public ProjectManagementSystemImpl() {
        this.assignments = new ArrayList<>();
    }

    public List<Item> getAssignments() {
        return assignments;
    }

    @Override
    public void addTicket(String title, String description, Date dueDate, TicketPriority priority, String sender, String owner) {
        assignments.add(new Ticket(title, description, dueDate, priority, sender, owner));
    }

    @Override
    public void addTodo(String title, String description, TodoState state) {
        assignments.add(new Todo(title, description, state));
    }

    @Override
    public void addTask(String title, String description, Date dueDate, TicketPriority priority, Date plannedTime, String assignee) {
        assignments.add(new Task(title, description, dueDate, priority, plannedTime, assignee));
    }

    @Override
    public List<Item> listAll() {
        return assignments.stream()
                .sorted(Comparator.comparing(Item::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> listTickets() {
        return assignments.stream()
                .sorted(Comparator.comparing(Item::getTitle))
                .filter(x -> x instanceof Ticket)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> listTodos() {
        return assignments.stream()
                .sorted(Comparator.comparing(Item::getTitle))
                .filter(x -> x instanceof Todo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> listTodos(TodoState state) {
        List<Todo> toDosList = assignments.stream()
                .filter(x -> x instanceof Todo)
                .map(x -> (Todo) x)
                .collect(Collectors.toList());

        return toDosList.stream()
                .filter(x -> x.getState().equals(state))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> listTasks() {
        return assignments.stream()
                .sorted(Comparator.comparing(Item::getTitle))
                .filter(x -> x instanceof Task)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> searchByTitleOrDescription(String pattern) {
        return assignments.stream()
                .filter(x -> x.getTitle().equals(pattern))
                .filter(x -> x.getDescription().equals(pattern))
                .collect(Collectors.toList());
    }

    @Override
    public void changeTodoState(String title) {
        Todo todoItem = (Todo) assignments.stream()
                .filter(x -> x.getTitle().equals(title));

        if (todoItem.getState().equals(TodoState.DONE)) {
            todoItem.setState(TodoState.NOT_DONE);
        } else {
            todoItem.setState(TodoState.DONE);
        }

    }
}
