package edu.kis.powp.jobs2d.drivers.factories;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.commands.SetPositionCommand;

public class RectangleFactory extends Factory {
    public ComplexCommand create(Job2dDriver driver) {
        this.command = new ComplexCommand();
        this.command.addCommand(new SetPositionCommand(driver, -100, 100));
        this.command.addCommand(new OperateToCommand(driver, 100, 100));
        this.command.addCommand(new OperateToCommand(driver, 100, -100));
        this.command.addCommand(new OperateToCommand(driver, -100, -100));
        this.command.addCommand(new OperateToCommand(driver, -100, 100));
        return this.command;
    }
}
