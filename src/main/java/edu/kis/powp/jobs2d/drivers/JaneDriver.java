package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class JaneDriver extends AbstractDriver {
    
	public JaneDriver(int x, int y) {
        super(x, y);
	}

    @Override
    public void operateTo(int x, int y) {
        DriverFeature.getDriverManager().getCurrentDriver().operateTo(x, y);
    }
}
