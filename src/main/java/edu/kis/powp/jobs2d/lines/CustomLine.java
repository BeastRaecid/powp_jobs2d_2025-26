package edu.kis.powp.jobs2d.lines;

import java.awt.Color;

import edu.kis.legacy.drawer.shape.line.AbstractLine;

public class CustomLine extends AbstractLine {
    public CustomLine(Color newColor, float newThickness, boolean dotted) {
        super();
        this.color = newColor;
		this.thickness = newThickness;
		this.dotted = dotted;
    }
}
