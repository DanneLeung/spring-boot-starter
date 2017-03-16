package com.xcesys.extras.config.auditing;

import org.springframework.beans.factory.annotation.Configurable;

import com.xcesys.extras.framework.entity.RevEntity;

//@Configurable
public class RevListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        // Set current username and user
        RevEntity revEntity = (RevEntity) revisionEntity;
        revEntity.setUsername(getUsername());
        revEntity.setUser(getUser());

    }
}