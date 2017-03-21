package com.xcesys.extras.framework.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.xcesys.extras.framework.core.model.IdTreeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * StateCity generated by hbm2java
 */
// @Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
public class StateCity extends IdTreeEntity<StateCity> implements java.io.Serializable {

	private static final long serialVersionUID = 9131091066217558764L;
	/** 编码 */
	private String code;
	/** 国家编码 */
	private String countryCode;
	/** 国家名称 */
	private String countryName;
	private Integer hits;
	private Long id;
	/** 城市级别（一二线，三线等） */
	private Integer level;
	/** 上级编码 */
	private String parentCode;
	/** 拼音 */
	private String spell;
	/** 区域 */
	@ManyToOne
	@JoinColumn
	private Region region;
	private Long regionId;
	/** 经度 */
	private Float longitude;
	/** 纬度 */
	private Float latitude;

	/** 地图经度(地图Vendor自定义的经度) */
	private Float mapX;

	/** 地图纬度(地图Vendor自定义的纬度) */
	private Float mapY;

}