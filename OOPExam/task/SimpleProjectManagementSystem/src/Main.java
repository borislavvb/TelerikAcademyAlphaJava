import base.CommandParser;

public class Main {

    public static void main(String[] args) {
        CommandParser parser = new CommandParserImpl();
        ProjectManagementSystemImpl system = new ProjectManagementSystemImpl();
        Application app = new Application(parser, system);
        app.run();
    }
}
