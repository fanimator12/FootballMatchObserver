import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FootballFan implements PropertyChangeListener {
    private FootballGame footballGame;
    private String myName;
    private String myTeam;

    public FootballFan(FootballGame footballGame, String myName, boolean isHomeTeamFan) {
        this.footballGame = footballGame;
        this.myName = myName;
        if (isHomeTeamFan)
            this.myTeam = footballGame.getHomeTeam();
        else
            this.myTeam = footballGame.getAwayTeam();
        footballGame.addListener(this);
        cheer(myTeam);
    }

    public void cheer(String team) {
        System.out.println(myName + " -> GO " + team);
    }

    public void reactOnGoal(String team) {
        if (team.equals(myTeam))
            System.out.println(myName + " -> YAY! (" + team + " scored)");
        else
            System.out.println(myName + " -> BOO! (" + team + " scored)");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        reactOnGoal(evt.getPropertyName());
    }
}
