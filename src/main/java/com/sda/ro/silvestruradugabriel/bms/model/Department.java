package com.sda.ro.silvestruradugabriel.bms.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    //joinColumns ={@JoinColumn(name = "projectId")},
    //            inverseJoinColumns = {@JoinColumn(name = "employeeId")})

    @ManyToMany
    @JoinTable(name = "users_departments",
            joinColumns = {@JoinColumn(name = "departmentId")},
            inverseJoinColumns = {@JoinColumn(name = "userId")}
    )
    private List<User> users = new ArrayList<>();

    public Department() {
    }

    public Department(Integer id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}