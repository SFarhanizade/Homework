import entity.BaseEntity;
import entity.City;
import entity.Stadium;

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
                    3-player
                    4-Coach
                    5-Team
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
                        case 0:{
                            break;
                        }
                        case 1: {
                            List<City> cities = showCities();
                            System.out.print("Choose a city to see the details or 0 to back: ");
                            menuNum = input.nextInt();
                            input.nextLine();
                            if (menuNum == 0)
                                break;
                            showCity(cities.get(menuNum - 1));
                            break;
                        }
                        case 2: {
                            addCity();
                            break;
                        }
                        case 3:{
                            List<City> cities = showCities();
                            System.out.print("Choose a city to remove or  to back: ");
                            int answer = input.nextInt();
                            input.nextLine();
                            if(answer==0)
                                break;
                            if(!isSure())
                                break;
                            Main.cityManager.delete(cities.get(answer-1));
                            System.out.println("Removed!");
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    private static void showCity(City city) {
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

    private static List<Stadium> showStadiums(City city) {
        List<Stadium> stadiums = city.getStadiums();
        System.out.println("Stadiums in " + city.getName());
        for (int i = 0; i < stadiums.size(); i++) {
            System.out.println((i + 1) + "-" + stadiums.get(i).getName());
        }
        return stadiums;
    }

    private static void showStadium(Stadium stadium) {
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
