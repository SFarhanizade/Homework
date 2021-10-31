package ir.maktab.jdbc.entity;

import ir.maktab.jdbc.entity.base.BaseEntity;

public class Major implements BaseEntity<Integer> {
    private int id;
    private String name;

    public Major(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Major(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void setId(Integer integer) {
   this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
    public static MajorBuilder builder(){
        return new MajorBuilder();
    }
    public static class MajorBuilder{
        Integer id;
        String name;
        public MajorBuilder id(int id){
            this.id = id;
            return this;
        }

        public MajorBuilder name(String name){
            this.name= name;
            return this;
        }

        public Major build(){
            return new Major(id, name);
        }
    }
}
