package edu.kis.powp.jobs2d.drivers.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {
    private Job2dDriver driver;
    private int x;
    private int y;

    public SetPositionCommand(Job2dDriver driver, int x, int y) {
        this.driver = driver;
        this.x = x;
        this.y = y;
    }
    
    public void execute() {
        this.driver.setPosition(x, y);
    }
}
