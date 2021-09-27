import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    static Statement statement;

    static {
        try {
            statement = DbConfig.getDataSource().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        printMostExpensiveCoach();
        System.out.println();
        printMostExpensivePlayer();
        System.out.println();
        printCitiesTeamsCount();
        System.out.println();
        printTeamsPoints(getTeamsPoints());
        System.out.println();
        printBestTeam(getTeamsPoints());
        System.out.println();
        printBestDerby();
    }

    static void printMostExpensiveCoach() throws SQLException {
        ResultSet resultset = statement.executeQuery("SELECT c.name AS 'Name', MAX(tc.price) AS 'Wage' FROM TeamCoach tc, Coach c;");
        System.out.println("The Most Expensive Coach(es) in 1400:");
        while (resultset.next()) {
            System.out.println("Name: " + resultset.getString("Name")
                    + "  Wage: " + resultset.getInt("Wage"));
        }
    }

    static void printMostExpensivePlayer() throws SQLException {
        ResultSet resultset = statement.executeQuery("SELECT p.name AS 'Name', tp.price AS 'Wage' FROM TeamPlayer tp, Player p WHERE tp.price > (SELECT AVG(tp.price) FROM TeamPlayer tp) AND tp.player_id = p.id;");
        System.out.println("The Most Expensive Player(s) in 1400:");
        while (resultset.next()) {
            System.out.println("Name: " + resultset.getString("Name")
                    + "  Wage: " + resultset.getInt("Wage"));
        }
    }

    static void printCitiesTeamsCount() throws SQLException {
        ResultSet resultset = statement.executeQuery("SELECT c.name AS 'City', COUNT(t.city_id) AS 'Count' FROM City c, Team t WHERE c.id = t.city_id GROUP BY c.id;");
        System.out.println("The Number of Teams in Cities:");
        while (resultset.next()) {
            System.out.println("City: " + resultset.getString("City")
                    + "  Teams: " + resultset.getInt("Count"));
        }
    }

    static void printBestDerby() throws SQLException {
        ResultSet resultset = statement.executeQuery("SELECT t1.name AS 'Team1', t2.name AS 'Team2',(g.firstTeamGoals+ g.secondTeamGoals) AS 'Goals' FROM Game g, Team t1, Team t2 WHERE NOT t1.id = t2.id AND t1.city_id = t2.city_id AND t1.id = g.firstTeam_id AND t2.id=g.secondTeam_id;");
        System.out.println("The best Derby:");
        while (resultset.next()) {
            System.out.println("Team1: " + resultset.getString("Team1")+"" +
                    "\nTeam2: " + resultset.getString("Team2")+
                    "\nTotal Goals: " + resultset.getInt("Goals"));
        }
    }

    static void printTeamsPoints(ArrayList teams) {
        System.out.println("Teams Points:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.print("Team: " + ((Object[]) teams.get(i))[0].toString());
            System.out.print("      Point: " + ((int) ((Object[]) teams.get(i))[1]) + "\n");
        }
    }

    static void printBestTeam(ArrayList teams){
        System.out.println("The most successful Team:");
        int max = (int)((Object[])teams.get(0))[1];
        String maxStr = ((Object[])teams.get(0))[0].toString();
        for (int i = 0; i < teams.size(); i++) {
            if(((int)((Object[])teams.get(i))[1])>max) {
                max = (int)((Object[])teams.get(i))[1];
                maxStr = ((Object[])teams.get(i))[0].toString();
            }
        }
        System.out.println("Team: "+ maxStr + "     Point: "+max);
    }

    static ArrayList getTeamsPoints() throws SQLException {
        ArrayList teams = new ArrayList();
        ResultSet resultset = statement.executeQuery("""
                SELECT t.name AS 'Name', SUM(g.points) AS 'Points'
                FROM Game g, Team t
                WHERE g.firstTeam_id = t.id AND g.firstTeamGoals>=g.secondTeamGoals
                GROUP BY t.id;""");
        Object[] obj = new Object[2];
        while (resultset.next()) {
            obj = new Object[2];
            obj[0] = resultset.getString("Name");
            obj[1] = resultset.getInt("Points");
            teams.add(obj);
        }
        resultset = statement.executeQuery("""
                SELECT t.name, SUM(g.points) AS 'Points'
                FROM Game g, Team t
                WHERE g.secondTeam_id = t.id AND g.secondTeamGoals>=g.firstTeamGoals
                GROUP BY t.id;""");
        while (resultset.next()) {
            obj = new Object[2];
            obj[0] = resultset.getString("Name");
            obj[1] = resultset.getInt("Points");
            teams.add(obj);
        }

        for (int i = 0; i < teams.size(); i++) {
            obj = (Object[]) teams.get(i);
            for (int j = i + 1; j < teams.size(); j++) {
                if (((Object[]) teams.get(j))[0].equals(obj[0]))
                    obj[1] = (int) obj[1] + (int) ((Object[]) teams.get(j))[1];
            }
        }
        return teams;
    }


}
