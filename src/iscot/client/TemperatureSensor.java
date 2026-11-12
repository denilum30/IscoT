package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.Event;
import iscot.events.TemperatureSensorEvent;

public class TemperatureSensor {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Invalid arguments!");
        } else {
            // TODO connect to the server
            // TODO register with the server
            Areas area = Areas.valueOf(args[2]);

            JFrame janela = new JFrame("Temperatura em " + area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());

            SensorControl sensorControl = new SensorControl("🌡", "Temperatura - " + area, "°C",
                    10, 40, 0.5, 22,
                    valor -> {
                        Event ev = new TemperatureSensorEvent(area, valor);
                        System.out.println(ev);
                        System.out.println("Mudou para:"+valor);
                    });

            painel.add(sensorControl, BorderLayout.CENTER);
            janela.setContentPane(painel);
            janela.setLocationByPlatform(true);
            janela.pack();
            janela.setVisible(true);
        }
    }
}