import base.CommandParser;
import commands.Command;
import commands.CommandType;

public class CommandParserImpl implements CommandParser {
    private static final String ADD_TODO_COMMAND_NAME = "ADD-TODO";
    private static final String ADD_TASK_COMMAND_NAME = "ADD-TASK";
    private static final String ADD_TICKET_COMMAND_NAME = "ADD-TICKET";
    private static final String LIST_ALL_COMMAND_NAME = "LIST-ALL";
    private static final String LIST_TASKS_COMMAND_NAME = "LIST-TASKS";
    private static final String LIST_TODOS_COMMAND_NAME = "LIST-TODOS";
    private static final String LIST_TICKETS_COMMAND_NAME = "LIST-TICKETS";
    private static final String UPDATE_TODO_COMMAND_NAME = "UPDATE-TODO";
    private static final String LIST_TODOS_NOT_DONE_COMMAND_NAME = "LIST-TODOS-NOT-DONE";


    @Override
    public Command parseCommand(String commandString) {
        CommandType commandType = getCommandTypeByName(commandString);
        return new Command(commandType);
    }

    private CommandType getCommandTypeByName(String commandName) {
        if (commandName.equals(ADD_TODO_COMMAND_NAME)) {
            return CommandType.ADD_TODO;
        } else if (commandName.equals(ADD_TASK_COMMAND_NAME)) {
            return CommandType.ADD_TASK;
        } else if (commandName.equals(ADD_TICKET_COMMAND_NAME)) {
            return CommandType.ADD_TICKET;
        } else if (commandName.equals(LIST_ALL_COMMAND_NAME)) {
            return CommandType.LIST_ALL;
        } else if (commandName.equals(LIST_TASKS_COMMAND_NAME)) {
            return CommandType.LIST_TASKS;
        } else if (commandName.equals(LIST_TODOS_COMMAND_NAME)) {
            return CommandType.LIST_TODOS;
        } else if (commandName.equals(LIST_TICKETS_COMMAND_NAME)) {
            return CommandType.LIST_TICKETS;
        } else if (commandName.equals(UPDATE_TODO_COMMAND_NAME)) {
            return CommandType.UPDATE_TODO;
        } else if (commandName.equals(LIST_TODOS_NOT_DONE_COMMAND_NAME)) {
            return CommandType.LIST_TODOS_NOT_DONE;
        } else {
            return null;
        }
    }
}
