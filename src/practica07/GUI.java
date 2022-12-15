package practica07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel infoLabel;
    private JLabel[] playerLabel;
    private JButton botonActualizar;
    private Observer observer;

    public GUI() throws IOException {
        frame = new JFrame();
        mainPanel = new JPanel(new GridBagLayout());
        infoLabel = new JLabel("Se muestran estadísticas de los jugadores del Mundial de 2022", SwingConstants.CENTER);
        botonActualizar = new JButton("Actualizar");
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        observer = new Observer(this);
        playerLabel = new JLabel[observer.getArrSize()];
        ArrayList<Player> players = observer.getPlayers();
        for (int i = 0; i < observer.getArrSize(); i++) {
            playerLabel[i] = new JLabel("<html><body>" +
                    players.get(i).toString() + "<br>" +
                    players.get(i).getNumberOfGoals()
                    + "</body></html>");
            URL url = new URL(players.get(i).getFlagUrl());
            Image icon = new ImageIcon(url).getImage();
            icon = icon.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            playerLabel[i].setIcon(new ImageIcon(icon));
        }

        GridBagConstraints mainPanelConstraints = new GridBagConstraints();
        mainPanel.add(infoLabel, mainPanelConstraints);
        mainPanelConstraints.gridy = 1;
        for (JLabel label : playerLabel) {
            mainPanel.add(label, mainPanelConstraints);
            mainPanelConstraints.gridy++;
        }
        mainPanel.add(botonActualizar, mainPanelConstraints);

        frame.add(mainPanel);
        frame.setSize(1280,720);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
    }
}