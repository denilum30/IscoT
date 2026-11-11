package iscot.client;

import java.awt.BorderLayout;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import iscot.client.gui.LightIcon;
import iscot.enums.Areas;
import iscot.events.AreaLightingOrderEvent;
import iscot.events.Event;

public class LightActuator {

    private final LightIcon luz = new LightIcon();
    private final JTextArea historico = new JTextArea(8, 25);

    public LightActuator(Areas area) {
        JFrame janela = new JFrame("Luz em " + area);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        historico.setEditable(false);

        JPanel painel = new JPanel(new BorderLayout());
        painel.add(luz, BorderLayout.CENTER);
        painel.add(new JScrollPane(historico), BorderLayout.SOUTH);

        janela.setContentPane(painel);
        janela.setLocation(600, 400);
        janela.pack();
        janela.setVisible(true);
    }

    public void handle(Event e) {
        if (e instanceof AreaLightingOrderEvent) {
            AreaLightingOrderEvent ordem = (AreaLightingOrderEvent) e;
            luz.setLigada(ordem.isOn());
            if (ordem.isOn()) {
                registar("Lâmpada ligada");
            } else {
                registar("Lâmpada desligada");
            }
        }
    }

    private void registar(String acao) {
        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        SwingUtilities.invokeLater(() -> historico.append(acao + " - " + hora + "\n"));
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 3) {
            System.err.println("Invalid arguments!");
        } else {
            // TODO connect to the server
            // TODO register with the server
            Areas area = Areas.valueOf(args[2]);

            LightActuator atuador = new LightActuator(area);

            //lampada liga em 2 segundos e desliga em 3 segundos
            Thread.sleep(2000);
            atuador.handle(new AreaLightingOrderEvent(area, true));

            Thread.sleep(3000);
            atuador.handle(new AreaLightingOrderEvent(area, false));
        }
    }
}