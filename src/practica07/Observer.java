package practica07;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Observer {
    private int arrSize;
    private GUI gui;
    private JSONObject obj;
    private ArrayList<Player> players;
    private Ranking ranking;

    public Observer(GUI gui) {
        this.gui = gui;
        // get players from DataFetcher
        this.players = getPlayersFromData();
        // create ranking
        //this.ranking = new Ranking(this.players);
        if (obj != null) {
            arrSize = (int) obj.get("count");
        }
    }

    public ArrayList<Player> getPlayersFromData() {
        ArrayList<Player> playersList = new ArrayList<>();
        DataFetcher dataFetcher = new DataFetcher();
        dataFetcher.setUrl("https://api.football-data.org/v4/competitions/WC/scorers?season=2022");
        this.obj = dataFetcher.getData();
        JSONArray scorers = obj.getJSONArray("scorers");
        for (int i = 0; i < scorers.length(); i++) {
            JSONObject scorer = scorers.getJSONObject(i);
            String playerName = scorer.getJSONObject("player").getString("name");
            String teamName = scorer.getJSONObject("team").getString("name");
            String teamUrl = scorer.getJSONObject("team").getString("crest");
            int goals = (int) scorer.get("goals");
            Player player = new Player(playerName, teamName, teamUrl, goals);
            playersList.add(player);
        }
        return playersList;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getArrSize() {
        return arrSize;
    }
}
