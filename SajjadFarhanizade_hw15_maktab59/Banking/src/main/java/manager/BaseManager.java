package manager;

import entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseManager <T extends BaseEntity<ID>, ID extends String>{
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("jpa-bank");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
}
