package edu.kis.powp.jobs2d.drivers.commands;

public class ComplexCommand implements DriverCommand {
    // Make a list of commands
    private java.util.List<DriverCommand> commands;

    // A method to add commands to the list
    public void addCommand(DriverCommand command) {
        if (commands == null) {
            commands = new java.util.ArrayList<>();
        }
        commands.add(command);
    }

    // Constructor
    public ComplexCommand() {
        this.commands = new java.util.ArrayList<>();
    }

    // Execute all
    @Override
    public void execute() {
        for (DriverCommand command : commands) {
            command.execute();
        }
    }
}
