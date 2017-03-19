package com.xcesys.extras.framework.entity;

import static lombok.AccessLevel.PROTECTED;

import java.io.Serializable;

import javax.persistence.Entity;

import com.xcesys.extras.framework.dao.model.IdEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class Preference extends IdEntity implements Serializable {

    private Boolean isGroupPreference;
    private Boolean isUserPreference;
    @NonNull
    private String name;
}
