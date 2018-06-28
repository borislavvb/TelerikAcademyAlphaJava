import base.CommandParser;
import commands.Command;
import commands.CommandType;
import models.TicketPriority;
import models.TodoState;
import models.base.Item;

import java.util.Date;
import java.util.Scanner;

public class Application {
    private static final String EXIT_STATE = "EXIT";
    private final CommandParser commandParser;
    private ProjectManagementSystemImpl system;

    public Application(CommandParser commandParser, ProjectManagementSystemImpl system) {
        this.system = system;
        this.commandParser = commandParser;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.print("Please enter your command /Example: ADD-TASK/: ");
            String commandString = in.nextLine();
            Command command = this.commandParser.parseCommand(commandString);
            if (command.getCommandType() == CommandType.EXIT) {
                break;
            }

            switch (command.getCommandType()) {
                case ADD_TODO:
                    System.out.print("Title: ");
                    String title = in.nextLine();
                    System.out.print("Description: ");
                    String description = in.nextLine();
                    System.out.print("State: ");
                    TodoState state = TodoState.fromName(in.nextLine());
                    system.addTodo(title, description, state);
                    break;
                case ADD_TASK:
                    System.out.print("Title: ");
                    String titleTask = in.nextLine();
                    System.out.print("Description: ");
                    String descriptionTask = in.nextLine();
                    System.out.print("Due date (dd/mm/yyyy): ");
                    String dueDateStrTask = in.nextLine();
                    Date dueDateTask = new Date(dueDateStrTask);
                    System.out.print("Priority: ");
                    TicketPriority taskPriority = TicketPriority.fromName(in.nextLine());
                    System.out.print("Planned time (dd/mm/yyyy HH:mm): ");
                    String plannedTimeStr = in.nextLine();
                    Date plannedTime = new Date(plannedTimeStr);
                    System.out.print("Assignee: ");
                    String assignee = in.nextLine();
                    system.addTask(titleTask, descriptionTask, dueDateTask, taskPriority, plannedTime, assignee);
                    break;
                case ADD_TICKET:
                    System.out.print("Title: ");
                    String titleTicket = in.nextLine();
                    System.out.print("Description: ");
                    String descriptionTicket = in.nextLine();
                    System.out.print("Due date (dd/mm/yyyy): ");
                    String dueDateTicketStr = in.nextLine();
                    Date dueDateTicket = new Date(dueDateTicketStr);
                    System.out.print("Priority: ");
                    String priotiry = in.nextLine();
                    TicketPriority ticketPriority = TicketPriority.fromName(priotiry);
                    System.out.print("Sender: ");
                    String sender = in.nextLine();
                    System.out.print("Owner: ");
                    String owner = in.nextLine();
                    system.addTicket(titleTicket, descriptionTicket, dueDateTicket, ticketPriority, sender, owner);
                    break;
                case LIST_ALL:
                    system.listAll().forEach(Item::showDescription);
                    break;
                case LIST_TASKS:
                    system.listTasks().forEach(Item::showDescription);
                    break;
                case LIST_TODOS:
                    system.listTodos().forEach(Item::showDescription);
                    break;
                case UPDATE_TODO:
                    String titleForUpdate = in.nextLine();
                    system.changeTodoState(titleForUpdate);
                    break;
                case LIST_TICKETS:
                    system.listTickets().forEach(Item::showDescription);
                    break;
                case LIST_TODOS_NOT_DONE:
                    system.listTodos(TodoState.NOT_DONE).forEach(Item::showDescription);
                    break;
            }
        }
    }
}
