package practica07;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import java.net.URL;

public class GUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel infoLabel;
    private JLabel[] playerLabel;
    private JButton botonActualizar;

    public GUI() throws IOException {
        frame = new JFrame();
        mainPanel = new JPanel(new GridBagLayout());
        infoLabel = new JLabel("Raking de Goleadores");
        botonActualizar = new JButton("Actualizar");
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        playerLabel = new JLabel[3];

//        playerLabel[0] = new JLabel("text0");
//        URL url = new URL("https://crests.football-data.org/762.png");
//        Image image = new ImageIcon(url).getImage();
//        image = image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
//        playerLabel[0].setIcon(new ImageIcon(image));


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