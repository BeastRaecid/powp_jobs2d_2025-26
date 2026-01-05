package edu.kis.powp.jobs2d.drivers.factories;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;

abstract class Factory {
    abstract ComplexCommand create(Job2dDriver driver);

    public ComplexCommand command;

    public void execute() {
        this.command.execute();
    }
}
