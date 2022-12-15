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
                //observer.update();
            }
        });
        observer = new Observer(this);

        GridBagConstraints mainPanelConstraints = new GridBagConstraints();
        mainPanel.add(infoLabel, mainPanelConstraints);
        mainPanelConstraints.gridy = 1;
        mainPanel.add(observer.getRanking(), mainPanelConstraints);
        mainPanelConstraints.gridy = 2;
        mainPanel.add(botonActualizar, mainPanelConstraints);

        frame.add(mainPanel);
        frame.setSize(500,720);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
    }
}