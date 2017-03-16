package com.xcesys.extras.framework.entity;

import javax.persistence.ManyToOne;

import com.xcesys.extras.config.auditing.RevListener;
import com.xcesys.extras.entity.User;

import lombok.Getter;
import lombok.Setter;

//@Entity
@RevisionEntity(RevListener.class)
public class RevEntity extends DefaultRevisionEntity {

    @Getter 
    @Setter
    private String username;
    @Getter 
    @Setter
    @ManyToOne
    private User user;
}