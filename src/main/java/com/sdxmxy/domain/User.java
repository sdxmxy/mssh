package com.sdxmxy.domain;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "User")
public class User {

    private String id;
    private String name;
    private String type;

}
