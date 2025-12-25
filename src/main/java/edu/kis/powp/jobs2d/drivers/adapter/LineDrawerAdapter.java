package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * driver adapter to drawer with several bugs.
 */
public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {
	private DrawPanelController drawController;
	private ILine line;
	private String name;
	private int startX = 0, startY = 0;

	public LineDrawerAdapter(DrawPanelController drawController, ILine line, String name) {
		super();

		this.drawController = drawController;
		this.line = line;
		this.name = name;
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		this.line.setStartCoordinates(startX, startY);
		this.setPosition(x, y);
		this.line.setEndCoordinates(x, y);

		this.drawController.drawLine(line);
	}

	@Override
	public String toString() {
		return "Graphics drawer: " + this.name;
	}
}
