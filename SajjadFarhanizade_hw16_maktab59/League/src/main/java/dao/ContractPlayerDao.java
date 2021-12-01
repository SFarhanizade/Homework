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

public class ContractPlayerDao extends BaseDao<ContractPlayer> {

    public ContractPlayerDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<ContractPlayer> getEntityClass() {
        return ContractPlayer.class;
    }

    public List<ContractPlayer> getMostExpensive() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ContractPlayer> cq = cb.createQuery(ContractPlayer.class);
        CriteriaQuery<Integer> cqP = cb.createQuery(Integer.class);
        Root<ContractPlayer> from = cq.from(ContractPlayer.class);
        Root<ContractPlayer> from1 = cqP.from(ContractPlayer.class);
        cqP.select(cb.max(from1.get("price")));
        TypedQuery<Integer> query1 = entityManager.createQuery(cqP);
        int max = query1.getSingleResult();
        cq.multiselect(from.get("player"),from.get("team"),from.get("price"), from.get("year"));
        cq.where(cb.equal(from.get("price"),max));
        TypedQuery<ContractPlayer> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
