package edu.kis.powp.jobs2d;

import java.lang.management.OperatingSystemMXBean;

import javax.xml.parsers.FactoryConfigurationError;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.commands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.commands.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.commands.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.factories.RectangleFactory;
import edu.kis.powp.jobs2d.drivers.factories.TriangleFactory;
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
	private static RectangleFactory rectangleFactory;
	private static TriangleFactory triangleFactory;

	/**
	 * Driver test.
	 */
	public static void main(String[] args) {
		FiguresJoe.figureScript1(driver);

		// Test commands
		System.err.println("\nTesting commands:");
		setPositionCommand = new SetPositionCommand(driver, 200, 200);
		operateToCommand = new OperateToCommand(driver, 250, -300);
		setPositionCommand.execute();
		operateToCommand.execute();

		// Test complex commands
		System.err.println("\nTesting complex commands:");
		complexCommand = new ComplexCommand();
		complexCommand.addCommand(new SetPositionCommand(driver, 11111, 11111));
		complexCommand.addCommand(new OperateToCommand(driver, -22222, -22222));
		complexCommand.addCommand(new OperateToCommand(driver, 33333, 33333));
		complexCommand.execute();

		// Test rectangle factory
		System.err.println("\nTesting rectangle factory:");
		rectangleFactory = new RectangleFactory();
		rectangleFactory.create(driver);
		rectangleFactory.execute();

		// Test triangle factory
		System.err.println("\nTesting triangle factory:");
		triangleFactory = new TriangleFactory();
		triangleFactory.create(driver);
		triangleFactory.execute();
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
