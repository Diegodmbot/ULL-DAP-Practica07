package practica07;

import javax.swing.*;
import java.net.MalformedURLException;

public abstract class Ranking {
    protected String title_;
    public abstract void update();
    public abstract JPanel writeRanking() throws MalformedURLException;
}
