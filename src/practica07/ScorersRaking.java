package practica07;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ScorersRaking extends Ranking {
    private ArrayList<Player> playersList;

    public ScorersRaking(ArrayList<Player> players) {
        this.title_ = "Mejores Goleadores";
        this.playersList = players;
    }

    @Override
    public void update() {
    }

    @Override
    public JPanel writeRanking() throws MalformedURLException {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(title_);
        panel.add(title);
        for (Player player : playersList) {
            JLabel playerLabel = new JLabel("<html><body>" +
                    player.toString() + "<br>" +
                    player.getNumberOfGoals()
                    + "</body></html>");
            URL url = new URL(player.getFlagUrl());
            Image icon = new ImageIcon(url).getImage();
            icon = icon.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            playerLabel.setIcon(new ImageIcon(icon));
            panel.add(playerLabel);
        }
        return panel;
    }
}
