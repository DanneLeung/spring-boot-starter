package com.xcesys.extras.framework.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.xcesys.extras.framework.core.model.IdEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
// @NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class PreferenceValue extends IdEntity implements Serializable {
	private static final long serialVersionUID = -3952389941716183924L;
	@ManyToOne
	private Preference preference;
	private String value;
}
