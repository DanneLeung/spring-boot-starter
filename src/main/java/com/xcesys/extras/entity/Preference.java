package com.xcesys.extras.entity;

import static lombok.AccessLevel.PROTECTED;

import java.io.Serializable;

import javax.persistence.Entity;

import com.xcesys.extras.entity.abstracts.IdEntity;

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

    @NonNull
    private String name;
    private Boolean isGroupPreference;
    private Boolean isUserPreference;
}
