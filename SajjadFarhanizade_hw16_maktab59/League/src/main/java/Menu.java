import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    1-City
                    2-Stadium
                    3-Team
                    4-Coach
                    5-Player
                    6-Game
                    """);
            int menuNum = input.nextInt();
            input.nextLine();
            switch (menuNum) {
                case 1: {
                    System.out.println("""
                                                        
                            1-Show
                            2-Add
                            3-Remove
                            0-Back
                            """);
                    menuNum = input.nextInt();
                    input.nextLine();
                    switch (menuNum) {
                        case 0: {
                            break;
                        }
                        case 1: {
                            showCity(chooseCity(showCities(),
                                    "Choose a city to see the details"));
                            break;
                        }
                        case 2: {
                            addCity();
                            break;
                        }
                        case 3: {
                            City city = chooseCity(showCities(), "Choose a city to remove");
                            if (city == null)
                                break;
                            if (!isSure())
                                break;
                            Main.cityManager.delete(city);
                            System.out.println("Removed!");
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("""
                                                        
                            1-Show
                            2-Add
                            3-Remove
                            0-Back
                            """);
                    menuNum = input.nextInt();
                    input.nextLine();
                    switch (menuNum) {
                        case 0: {
                            break;
                        }
                        case 1: {
                            showStadium(chooseStadium(showStadiums(),
                                    "Choose a stadium to see details"));
                            break;
                        }
                        case 2: {
                            addStadium();
                            break;
                        }
                        case 3: {
                            Stadium stadium = chooseStadium(showStadiums(),
                                    "Choose a stadium to remove");
                            if (!isSure())
                                break;
                            Main.stadiumManager.delete(stadium);
                            System.out.println("Removed!");
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("""
                                                        
                            1-Show
                            2-Add
                            3-Remove
                            0-Back
                            """);
                    menuNum = input.nextInt();
                    input.nextLine();
                    switch (menuNum) {
                        case 0: {
                            break;
                        }
                        case 1: {
                            showTeam(chooseTeam(showTeams(), "Choose a team"));
                            break;
                        }
                        case 2: {
                            addTeam();
                            break;
                        }
                        case 3: {
                            Team team = chooseTeam(showTeams(), "Choose a team to remove");
                            if (!isSure()) {
                                System.out.println("Canceled!");
                                break;
                            }
                            Main.teamManager.delete(team);
                            System.out.println("Removed!");
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("""
                            1-Show
                            2-Add
                            0-Back
                            """);
                    menuNum = input.nextInt();
                    input.nextLine();
                    switch (menuNum) {
                        case 0: {
                            break;
                        }
                        case 1: {
                            showCoach(chooseCoach(showCoaches(), "Choose a coach to see details"));
                            break;
                        }
                        case 2: {
                            addCoach();
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("""
                            1-Show
                            2-Add
                            0-Back
                            """);
                    menuNum = input.nextInt();
                    input.nextLine();
                    switch (menuNum) {
                        case 0: {
                            break;
                        }
                        case 1: {
                            showPlayer(choosePlayer(showPlayers(), "Choose a player"));
                            break;
                        }
                        case 2: {
                            addPlayer();
                            break;
                        }

                    }
                    break;
                }
                case 6: {
                    System.out.println("""
                            1-Show
                            2-Add
                            0-Back
                            """);
                    menuNum = input.nextInt();
                    input.nextLine();
                    switch (menuNum) {
                        case 0: {
                            break;
                        }
                        case 1: {
                            showGame(chooseGame(showGames(), "Choose a game to see details"));
                            break;
                        }
                        case 2: {
                            addGame();
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    private static void addGame() {
        Stadium stadium = chooseStadium(showStadiums(), "Choose the stadium");
        System.out.print("Enter the year: ");
        Integer year = input.nextInt();
        input.nextLine();
        Team team1 = chooseTeam(showTeams(Main.teamManager.getValidTeams()),
                "Choose the first team");
        if (team1 == null) {
            System.out.println("Canceled!");
            return;
        }
        Team team2 = chooseTeam(showTeams(Main.teamManager.getValidTeams(team1)),
                "Choose the second team");
        if (team2 == null) {
            System.out.println("Canceled!");
            return;
        }
        System.out.println("Enter the goals of " + team1.getName());
        Integer goals1 = input.nextInt();
        input.nextLine();
        System.out.println("Enter the goals of " + team2.getName());
        Integer goals2 = input.nextInt();
        input.nextLine();
        Game game = Game.builder()
                .stadium(stadium)
                .team1(team1)
                .team2(team2)
                .goals1(goals1)
                .goals2(goals2)
                .year(year)
                .build();
        Main.gameManager.save(game);
    }

    private static void showCity(City city) {
        if (city == null)
            return;
        System.out.println("City " + city.getName());
        System.out.println("""
                                
                1-Edit Name
                2-Show Stadiums
                3-Remove
                0-Back
                """);
        int menuNum = input.nextInt();
        input.nextLine();
        switch (menuNum) {
            case 0: {
                break;
            }
            case 1: {
                System.out.print("Enter a name for the city: ");
                String name = input.nextLine();
                city.setName(name);
                Main.cityManager.update(city);
                break;
            }
            case 2: {
                List<Stadium> stadiums = showStadiums(city);
                System.out.print("Choose a stadium to see details or 0 to back: ");
                menuNum = input.nextInt();
                input.nextLine();
                if (menuNum == 0)
                    break;
                showStadium(stadiums.get(menuNum - 1));
                break;
            }
            case 3: {
                if (!isSure()) {
                    break;
                }
                Main.cityManager.delete(city);
                System.out.println("Removed!");
                break;
            }
        }
    }

    private static void addCity() {
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        City city = City.builder()
                .name(name)
                .build();
        Main.cityManager.save(city);
        System.out.println("Added!");
    }

    private static List<City> showCities() {
        List<City> cities = Main.cityManager.loadAll();
        System.out.println("Cities:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println((i + 1) + "-" + cities.get(i).getName());
        }
        return cities;
    }

    private static City chooseCity(List<City> cities, String message) {
        System.out.print(message + " or 0 to back: ");
        int menuNum = input.nextInt();
        input.nextLine();
        if (menuNum == 0)
            return null;
        return cities.get(menuNum - 1);
    }

    private static void addStadium() {
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        City city = chooseCity(showCities(), "Choose a city");
        if (city == null) {
            System.out.println("Canceled!");
            return;
        }
        Stadium stadium = Stadium.builder()
                .name(name)
                .city(city)
                .build();
        Main.stadiumManager.save(stadium);
        System.out.println("Added!");
    }

    private static List<Stadium> showStadiums(City city) {
        List<Stadium> stadiums = city.getStadiums();
        System.out.println("Stadiums in " + city.getName());
        for (int i = 0; i < stadiums.size(); i++) {
            System.out.println((i + 1) + "-" + stadiums.get(i).getName());
        }
        return stadiums;
    }

    private static List<Stadium> showStadiums() {
        List<Stadium> stadiums = Main.stadiumManager.loadAll();
        System.out.println("Stadium:");
        for (int i = 0; i < stadiums.size(); i++) {
            System.out.println((i + 1) + "-" + stadiums.get(i).getName());
        }
        return stadiums;
    }

    private static Stadium chooseStadium(List<Stadium> stadiums, String message) {
        System.out.print(message + " or 0 to back: ");
        int menuNum = input.nextInt();
        input.nextLine();
        if (menuNum == 0)
            return null;
        return stadiums.get(menuNum - 1);
    }

    private static void showStadium(Stadium stadium) {
        if (stadium == null)
            return;
        System.out.println("Stadium " + stadium.getName());
        System.out.println("""
                1-Edit Name
                2-Remove
                0-Back
                """);
        int menuNum = input.nextInt();
        switch (menuNum) {
            case 0: {
                break;
            }
            case 1: {
                System.out.print("Enter a name: ");
                String name = input.nextLine();
                stadium.setName(name);
                Main.stadiumManager.update(stadium);
                break;
            }
            case 2: {
                if (!isSure())
                    break;
                Main.stadiumManager.delete(stadium);
                System.out.println("Removed!");
                break;
            }
        }
    }

    private static List<Team> showTeams() {
        List<Team> teams = Main.teamManager.loadAll();
        System.out.println("Teams:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + "-" + teams.get(i).getName());
        }
        return teams;
    }

    private static List<Team> showTeams(List<Team> teams) {
        System.out.println("Teams:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + "-" + teams.get(i).getName());
        }
        return teams;
    }

    private static Team chooseTeam(List<Team> teams, String message) {
        System.out.print(message + " or 0 to back: ");
        int menuNum = input.nextInt();
        input.nextLine();
        if (menuNum == 0)
            return null;
        return teams.get(menuNum - 1);
    }

    private static void showTeam(Team team) {
        if(team == null)
            return;
        System.out.println("""
                                
                1-Players
                2-Capitan
                3-Coach
                4-Points
                5-Show games
                6-Edit name
                7-Remove
                0-Back
                """);
        int menuNum = input.nextInt();
        switch (menuNum) {
            case 0: {
                break;
            }
            case 1: {
                System.out.println("""
                               1-Show
                               2-Add
                               3-Remove
                               0-Back                        
                        """);
                menuNum = input.nextInt();
                input.nextLine();
                switch (menuNum) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        showPlayer(choosePlayer(showPlayers(team), "Choose a player"));
                        break;
                    }
                    case 2: {
                        Player player = choosePlayer(showPlayers(), "Choose a player");
                        if (player == null) {
                            System.out.println("Canceled!");
                            break;
                        }
                        List<Player> players = team.getPlayers();
                        players.add(player);
                        team.setPlayers(players);
                        Main.teamManager.update(team);
                        System.out.println("Done!");
                        break;
                    }
                    case 3: {
                        Player player = choosePlayer(showPlayers(team), "Choose a player to remove");
                        if (player == null) {
                            System.out.println("Canceled!");
                            break;
                        }
                        List<Player> players = team.getPlayers();
                        players.remove(player);
                        player.setTeam(null);
                        Main.playerManager.update(player);
                        team.setPlayers(players);
                        Main.teamManager.update(team);
                        System.out.println("Removed!");
                        break;
                    }
                }
                break;
            }
            case 2: {
                System.out.println("""
                        1-Show
                        2-Change
                        0-Back
                        """);
                menuNum = input.nextInt();
                input.nextLine();
                switch (menuNum) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        System.out.println("The current capitan: " + team.getCapitan().getName());
                        break;
                    }
                    case 2: {
                        Player capitan = chooseCapitan(team.getCapitan(), team.getPlayers());
                        if (capitan == null) {
                            System.out.println("Canceled!");
                            return;
                        }
                        team.setCapitan(capitan);
                        Main.teamManager.update(team);
                        System.out.println("Done!");
                        break;
                    }
                }

            }
            case 3: {
                System.out.println("""
                        1-Show
                        2-Change
                        3-Remove
                        0-Back
                        """);
                menuNum = input.nextInt();
                input.nextLine();
                switch (menuNum) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        showCoach(team.getCoach());
                        break;
                    }
                    case 2: {
                        if (team.getCoach() == null) {
                            System.out.println("There is no coach working with this team!");
                        }
                        Coach coach = chooseCoach(showFreeCoaches(), "Choose a coach");
                        if (coach == null) {
                            System.out.println("There are no free coaches available right now!");
                            break;
                        }
                        team.setCoach(coach);
                        Main.coachManager.update(coach);
                        System.out.println("Done!");
                        break;
                    }
                    case 3: {
                        if (!isSure()) {
                            System.out.println("Canceled!");
                            break;
                        }
                        team.setCoach(null);
                        Main.teamManager.update(team);
                        System.out.println("Removed!");
                    }
                }
            }
            case 4: {
                System.out.println("Points: " + team.getPoints());
                break;
            }
            case 5: {
                showGame(chooseGame(showGames(team), "Choose a game"));
                break;
            }
            case 6: {
                System.out.println("Enter a name: ");
                String name = input.nextLine();
                team.setName(name);
                Main.teamManager.update(team);
                System.out.println("Done!");
                break;
            }
            case 7: {
                if (!isSure()) {
                    System.out.println("Canceled!");
                    break;
                }
                Main.teamManager.delete(team);
                System.out.println("Removed!");
                break;
            }
        }
    }

    private static List<Team> getCoachLessTeam() {
        return Main.teamManager.getAllCoachLessTeam();
    }

    private static void addPlayer() {
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        Team team = chooseTeam(showTeams(), "Choose a team");
        Player player = Player.builder()
                .name(name)
                .team(team)
                .build();
        Main.playerManager.save(player);
        System.out.println("Done!");
    }

    private static List<Player> showPlayers(Team team) {
        System.out.println("Players of " + team.getName() + ":");
        List<Player> players = team.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + "-" + players.get(i).getName());
        }
        return players;
    }

    private static List<Player> showPlayers() {
        List<Player> players = Main.playerManager.loadFreePlayers();
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + "-" + players.get(i).getName());
        }
        return players;
    }

    private static Player choosePlayer(List<Player> players, String message) {
        System.out.print(message + " or 0 to back: ");
        int menuNum = input.nextInt();
        input.nextLine();
        if (menuNum == 0)
            return null;
        return players.get(menuNum - 1);
    }

    private static void showPlayer(Player player) {
        if (player == null)
            return;
        System.out.println("Player " + player.getName());
        System.out.println("""
                                
                1-Edit name
                2-Edit team
                0-Back
                """);
        int menuNum = input.nextInt();
        input.nextLine();
        switch (menuNum) {
            case 0: {
                break;
            }
            case 1: {
                System.out.print("Enter a name: ");
                String name = input.nextLine();
                player.setName(name);
                Main.playerManager.update(player);
                System.out.println("Done!");
                break;
            }
            case 2: {
                System.out.println("The current team: " + player.getTeam().getName());
                Team team = chooseTeam(showTeams(), "Choose a team");
                if (team == null) {
                    System.out.println("Canceled!");
                    return;
                }
                player.setTeam(team);
                Main.playerManager.update(player);
                System.out.println("Done!");
                break;
            }
        }
    }

    private static Player chooseCapitan(Player capitan, List<Player> players) {
        if (capitan == null)
            System.out.println("The team has no capitan at the moment.");
        else
            System.out.println("The current capitan is " + capitan.getName());
        Player newCapitan = choosePlayer(players, "Choose a capitan");
        return newCapitan;
    }

    private static Player chooseCapitan(List<Player> players, String message) {
        if (players == null) {
            System.out.println("The team has no player!");
            return null;
        }
        System.out.print(message + " or 0 to back: ");
        int menuNum = input.nextInt();
        input.nextLine();
        if (menuNum == 0)
            return null;
        return players.get(menuNum - 1);
    }

    private static void addCoach() {
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        Team team = chooseTeam(showTeams(getCoachLessTeam()), "Choose a team");
        Coach coach = Coach.builder()
                .name(name)
                .team(team)
                .build();
        Main.coachManager.save(coach);
        System.out.println("Done!");
    }

    private static List<Coach> showCoaches() {
        List<Coach> coaches = Main.coachManager.loadAll();
        Coach coach = null;
        for (int i = 0; i < coaches.size(); i++) {
            coach = coaches.get(i);
            String team = (coach.getTeam() == null) ? "Free" : coach.getTeam().getName();
            System.out.println((i + 1) + "-" + coach.getName() + " Team: " + team);
        }
        return coaches;
    }

    private static List<Coach> showFreeCoaches() {
        List<Coach> coaches = Main.coachManager.loadFreeCoaches();
        if (coaches.isEmpty()) {
            return null;
        }
        for (int i = 0; i < coaches.size(); i++) {
            System.out.println((i + 1) + "-" + (coaches.get(i).getName()));
        }
        return coaches;
    }

    private static void showCoach(Coach coach) {
        if (coach == null)
            return;
        System.out.println("Coach " + coach.getName());
        System.out.println("""
                1-Edit name
                2-Edit team
                3-Quit from the team
                0-Back
                """);
        int menuNum = input.nextInt();
        input.nextLine();
        switch (menuNum) {
            case 0: {
                break;
            }
            case 1: {
                System.out.print("Enter a name: ");
                String name = input.nextLine();
                coach.setName(name);
                Main.coachManager.update(coach);
                System.out.println("Done!");
                break;
            }
            case 2: {
                System.out.println("The current team: " + coach.getTeam().getName());
                Team team = chooseTeam(showTeams(getCoachLessTeam()), "Choose a team");
                if (team == null) {
                    System.out.println("Canceled!");
                    return;
                }
                coach.setTeam(team);
                Main.coachManager.update(coach);
                System.out.println("Done!");
                break;
            }
            case 3: {
                if (coach.getTeam() == null) {
                    System.out.println("There is no team working with the coach!");
                    break;
                }
                if (!isSure()) {
                    System.out.println("Canceled!");
                    break;
                }
                coach.setTeam(null);
                Main.coachManager.update(coach);
                System.out.println("Done!");
                break;
            }
        }
    }

    private static Coach chooseCoach(List<Coach> coaches, String message) {
        if (coaches == null) {
            System.out.println("There are no coaches available right now!");
            return null;
        }
        System.out.print(message + " or 0 to back: ");
        int menuNum = input.nextInt();
        input.nextLine();
        if (menuNum == 0)
            return null;
        return coaches.get(menuNum - 1);
    }

    private static List<Team> getTeamSortedByPoints() {
        return Main.teamManager.getAllSortedByPoints();
    }

    private static List<Game> showGames(Team team) {
        List<Game> games = team.getGames();
        System.out.println("Games:");
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            System.out.println((i + 1) + "-" + game.getTeam1().getName() + " " + game.getFirstTeamGoals() +
                    "\n  " + game.getTeam2().getName() + " " + game.getSecondTeamGoals() + "\n");
        }
        return games;
    }

    private static List<Game> showGames() {
        List<Game> games = Main.gameManager.loadAll();
        System.out.println("Games:");
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            System.out.println((i+1)+"- between "+game.getTeam1().getName() + " and "+
            game.getTeam2().getName() + "in "+game.getYear());
        }
        return games;
    }

    private static Game chooseGame(List<Game> games, String message) {
        if (games == null) {
            System.out.println("There are no games!");
            return null;
        }
        System.out.print(message + " or 0 to back: ");
        int menuNum = input.nextInt();
        input.nextLine();
        if (menuNum == 0)
            return null;
        return games.get(menuNum - 1);
    }

    private static void showGame(Game game) {
        if (game == null) {
            return;
        }
        System.out.println("Game between " + game.getTeam1().getName() +
                " and " + game.getTeam2().getName());
        System.out.println(game.getTeam1().getName() + " Goals: " + game.getFirstTeamGoals());
        System.out.println(game.getTeam2().getName() + " Goals: " + game.getSecondTeamGoals());
        System.out.println("Winner: " + game.getWinner().getName());
        System.out.println("Held in " + game.getStadium().getName() + " in " + game.getYear());
    }

    private static void addTeam() {
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        List<Player> players = new ArrayList<>();
        while (players.size() < 5) {
            Player player = choosePlayer(showPlayers(), (players.size() + 1) + "Choose a player");
            if (player != null) {
                players.add(player);
            }
        }
        Coach coach = null;
        while (coach == null) {
            coach = chooseCoach(showFreeCoaches(), "Choose a coach for the team");
        }
        Player capitan = null;
        while (capitan == null) {
            capitan = chooseCapitan(showPlayers(players), "Choose a capitan for the team");
        }
        Team team = Team.builder()
                .name(name)
                .players(players)
                .coach(coach)
                .capitan(capitan)
                .build();
        Main.teamManager.save(team);
        System.out.println("Done!");
    }

    private static List<Player> showPlayers(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i+1)+"-"+players.get(i).getName());
        }
        return players;
    }

    private static boolean isSure() {
        System.out.print("Are you sure? (y/n) ");
        String answer = input.nextLine();
        if (!answer.equals("y")) {
            System.out.println("Canceled!");
            return false;
        }
        return true;
    }
}
