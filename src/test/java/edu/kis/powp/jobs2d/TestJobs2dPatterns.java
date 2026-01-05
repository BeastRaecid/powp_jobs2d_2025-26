package edu.kis.powp.jobs2d;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.JaneDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.JaneOptionListener;
import edu.kis.powp.jobs2d.events.FigureScript1OptionListener;
import edu.kis.powp.jobs2d.events.FigureScript2OptionListener;
import edu.kis.powp.jobs2d.events.JaneOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.lines.CustomLine;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		FigureScript1OptionListener figureScript1OptionListener = new FigureScript1OptionListener(
			DriverFeature.getDriverManager());
		FigureScript2OptionListener figureScript2OptionListener = new FigureScript2OptionListener(
			DriverFeature.getDriverManager());
		JaneOptionListener JaneOptionListener = new JaneOptionListener(
			new JaneDriver(0, 0));

		application.addTest("Figure Joe 1", figureScript1OptionListener);
		application.addTest("Figure Joe 2", figureScript2OptionListener);
		application.addTest("Figure Jane 1", JaneOptionListener);
	}

	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

		DrawPanelController drawerController = DrawerFeature.getDrawerController();

		Job2dDriver solidDriver = new LineDrawerAdapter(drawerController, LineFactory.getBasicLine(), "Solid");
		DriverFeature.addDriver("Solid drawer", solidDriver);

		Job2dDriver dottedDriver = new LineDrawerAdapter(drawerController, LineFactory.getDottedLine(), "Dotted");
		DriverFeature.addDriver("Dotted drawer", dottedDriver);

		Job2dDriver specialDriver = new LineDrawerAdapter(drawerController, LineFactory.getSpecialLine(), "Special");
		DriverFeature.addDriver("Special drawer", specialDriver);

		ILine customLine = new CustomLine(Color.RED, 3, true);

		Job2dDriver customDriver = new LineDrawerAdapter(drawerController, customLine, "Custom");
		DriverFeature.addDriver("Custom drawer", customDriver);

		DriverFeature.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param application Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Application application) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
		application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
				new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
		defaultDrawerWindow.setVisible(true);
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);
				setupDefaultDrawerVisibilityManagement(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);

				app.setVisibility(true);
			}
		});
	}

}
