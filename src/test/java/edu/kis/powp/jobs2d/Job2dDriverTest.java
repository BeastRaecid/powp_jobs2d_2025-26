package edu.kis.powp.jobs2d;

import java.lang.management.OperatingSystemMXBean;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.commands.SetPositionCommand;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

/**
 * Plotter test.
 * 
 * @author Dominik
 */
public class Job2dDriverTest {
	private static Job2dDriver driver = new StubDriver();
	private static SetPositionCommand setPositionCommand;
	private static OperateToCommand operateToCommand;
	private static ComplexCommand complexCommand;

	/**
	 * Driver test.
	 */
	public static void main(String[] args) {
		FiguresJoe.figureScript1(driver);

		// Test commands
		setPositionCommand = new SetPositionCommand(driver, 200, 200);
		operateToCommand = new OperateToCommand(driver, 250, -300);
		setPositionCommand.execute();
		operateToCommand.execute();

		// Test complex commands
		complexCommand = new ComplexCommand();
		complexCommand.addCommand(new SetPositionCommand(driver, 11111, 11111));
		complexCommand.addCommand(new OperateToCommand(driver, -22222, -22222));
		complexCommand.addCommand(new OperateToCommand(driver, 33333, 33333));
		complexCommand.execute();
	}

	private static class StubDriver implements Job2dDriver {

		@Override
		public void operateTo(int x, int y) {
			System.out.println("Driver operateTo action... " + x + " " + y);
		}

		@Override
		public void setPosition(int x, int y) {
			System.out.println("Driver setPosition action... " + x + " " + y);
		}
	};
}
