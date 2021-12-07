import entity.City;
import entity.ContractPlayer;
import entity.Player;
import manager.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    static CityManager cityManager = new CityManager();
    static CoachManager coachManager = new CoachManager();
    static GameManager gameManager = new GameManager();
    static PlayerManager playerManager = new PlayerManager();
    static StadiumManager stadiumManager = new StadiumManager();
    static TeamManager teamManager = new TeamManager();
    static ContractCoachManager contractCoachManager = new ContractCoachManager();
    static ContractPlayerManager contractPlayerManager = new ContractPlayerManager();

    public static void main(String[] args) {
        Menu.main(args);
    }
}
