package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.JaneDriver;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;

public class JaneOptionListener implements ActionListener {

    private JaneDriver janeDriver;

    public JaneOptionListener(JaneDriver janeDriver) {
        this.janeDriver = janeDriver;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FiguresJane.figureScript(janeDriver);
    }
    
}
