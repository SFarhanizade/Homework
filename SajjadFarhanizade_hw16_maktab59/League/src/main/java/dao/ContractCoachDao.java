package dao;

import entity.ContractCoach;
import entity.ContractPlayer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ContractCoachDao extends BaseDao<ContractCoach> {
    public ContractCoachDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<ContractCoach> getEntityClass() {
        return ContractCoach.class;
    }

    public List<ContractCoach> getMostExpensive() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ContractCoach> cq = cb.createQuery(ContractCoach.class);
        CriteriaQuery<Integer> cqP = cb.createQuery(Integer.class);
        Root<ContractCoach> from = cq.from(ContractCoach.class);
        Root<ContractCoach> from1 = cqP.from(ContractCoach.class);
        cqP.select(cb.max(from1.get("price")));
        TypedQuery<Integer> query1 = entityManager.createQuery(cqP);
        int max = query1.getSingleResult();
        cq.multiselect(from.get("coach"),from.get("team"),from.get("price"), from.get("year"));
        cq.where(cb.equal(from.get("price"),max));
        TypedQuery<ContractCoach> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
