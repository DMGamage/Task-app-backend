package com.example.taskappbackend.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class User implements SuperEntity{
    @Id
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(name = "full_name", nullable = false)
    private String fullName;
}
