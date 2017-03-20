package com.xcesys.extras.framework.entity;

import static lombok.AccessLevel.PROTECTED;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.xcesys.extras.framework.core.model.IdEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RememberMeToken extends IdEntity {

	private static final long serialVersionUID = 2909574708567201161L;
	@NonNull
	@Column(length = 64)
	private String username;
	@Column(unique = true, length = 64)
	private String series;
	@NonNull
	@Column(length = 64)
	private String token;
	@NonNull
	private Date lastUsed;

}
