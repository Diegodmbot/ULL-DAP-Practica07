package practica07;

public class Player {
    private String name;
    protected String team;
    protected String flagUrl;
    protected int numberOfGoals;

    public Player(String playerName, String teamName, String teamUrl, int goals) {
        this.name = playerName;
        this.team = teamName;
        this.flagUrl = teamUrl;
        this.numberOfGoals = goals;
    }
    public String getName() {
        return name;
    }
    public String getTeam() {
        return team;
    }
    public String getFlagUrl() {
        return flagUrl;
    }
    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    @Override
    public String toString() {
        return name + " " + ", " + team;
    }
}
