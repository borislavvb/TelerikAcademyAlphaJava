package commands;

public class Command {
    private CommandType commandType;

    public Command(CommandType type) {
        setCommandType(type);

    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

}
