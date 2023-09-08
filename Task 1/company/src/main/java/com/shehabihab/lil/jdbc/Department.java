package com.shehabihab.lil.jdbc;

public class Department {
    private long id;
    private String name;
    private String boss;

    public Department(long id, String name, String boss) {
        this.id = id;
        this.name = name;
        this.boss = boss;
    }

    public Department() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBoss() {
        return boss;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }
}
