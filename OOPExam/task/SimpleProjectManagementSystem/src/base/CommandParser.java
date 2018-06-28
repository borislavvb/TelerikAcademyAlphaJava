package base;

import commands.Command;
import commands.CommandType;

public interface CommandParser {
    abstract Command parseCommand(String commandString);

}
