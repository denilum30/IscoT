package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.Event;
import iscot.events.GroundMoistureSensorEvent;

public class GroundMoistureSensor {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Invalid arguments!");
        } else {
            // TODO connect to the server
            // TODO register with the server
            Areas area = Areas.valueOf(args[2]);

            JFrame janela = new JFrame("Humidade do solo em " + area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());

            SensorControl sensorControl = new SensorControl("🌱", "Humidade do solo - " + area, "%",
                    0, 100, 1, 50,
                    valor -> {
                        Event ev = new GroundMoistureSensorEvent(area, valor);
                        System.out.println(ev);
                        System.out.println("Mudou para:"+valor);
                    });

            painel.add(sensorControl, BorderLayout.CENTER);
            janela.setContentPane(painel);
            janela.setLocation(600, 400);
            janela.pack();
            janela.setVisible(true);
        }
    }
}