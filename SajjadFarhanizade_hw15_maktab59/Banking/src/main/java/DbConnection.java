import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {
    static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("jpa-bank");
    static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
