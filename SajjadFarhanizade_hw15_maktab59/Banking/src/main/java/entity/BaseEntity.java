package entity;

public interface BaseEntity<ID> {
    void setId(ID id);
    ID getId();
}
