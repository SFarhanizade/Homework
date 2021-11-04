package ir.maktab.jdbc.entity;

import ir.maktab.jdbc.entity.base.BaseEntity;

public class Major implements BaseEntity<Integer> {
    private Integer id;
    private String name;

    public Major(Integer id, String name) {
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
        private Integer id;
        private String name;
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
