package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Role {
    private Integer rid;
    private String rname;
    private Set<Permission> permissions = new HashSet<Permission>();
    private Set<User> users = new HashSet<User>();
}
