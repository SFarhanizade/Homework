import entity.*;

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
                case 3:{
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
                        case 1:{

                        }
                    }
                    break;
                }
                case
            }
        }
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
        System.out.println("Stadium "+stadium.getName());
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

    private static List<Team> showTeams(){
        List<Team> teams = Main.teamManager.loadAll();
        System.out.println("Teams:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i+1)+"-"+teams.get(i).getName());
        }
        return teams;
    }

    private static Team chooseTeam(List<Team> teams, String message){
        System.out.print(message + " or 0 to back: ");
        int menuNum = input.nextInt();
        input.nextLine();
        if (menuNum == 0)
            return null;
        return teams.get(menuNum - 1);
    }

    private static void showTeam(Team team){
        System.out.println("""
                
                1-Players
                2-Capitan
                3-Coach
                4-Points
                5-Show games
                6-Edit
                7-Remove
                0-Back
                """);
        int menuNum = input.nextInt();
        switch(menuNum) {
            case 0:{
                break;
            }
            case 1:{
                showPlayer(choosePlayer(showPlayers(team), "Choose a player"));
                break;
            }
            case 2:{
                Player capitan = chooseCapitan(team.getCapitan(), team.getPlayers());
                if (capitan == null){
                    System.out.println("Canceled!");
                    return;
                }
                team.setCapitan(capitan);
                Main.teamManager.update(team);
                System.out.println("Done!");
            }
            case 3:{

            }
        }
    }

    private static List<Player> showPlayers(Team team) {
        System.out.println("Players of "+team.getName()+":");
        List<Player> players = team.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i+1)+"-"+players.get(i).getName());
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

    private static void showPlayer(Player player){
        if(player == null)
            return;
        System.out.println("Player "+ player.getName());
        System.out.println("""
                
                1-Edit name
                2-Edit team
                0-Back
                """);
        int menuNum = input.nextInt();
        input.nextLine();
        switch(menuNum){
            case 0:{
                break;
            }
            case 1:{
                System.out.print("Enter a name: ");
                String name = input.nextLine();
                player.setName(name);
                Main.playerManager.update(player);
                System.out.println("Done!");
                break;
            }
            case 2:{
                System.out.println("The current team: "+player.getTeam().getName());
                Team team = chooseTeam(showTeams(), "Choose a team");
                if(team==null){
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

    private static Player chooseCapitan(Player capitan, List<Player> players){
        if(capitan == null)
        System.out.println("The team has no capitan at the moment.");
        else
            System.out.println("The current capitan is "+capitan.getName());
        Player newCapitan = choosePlayer(players, "Choose a capitan");
        return newCapitan;
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
