package com.xcesys.extras.epa.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.SortedSet;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.core.bean.PageResult;
import com.xcesys.extras.framework.core.model.IdAuditableEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@Cacheable
@Table(name = "TM_DATA_BAR")
public class DataBar extends IdAuditableEntity implements Comparable<DataBar> {

	private static final long serialVersionUID = -5012274748925500133L;

	@Id
	@GeneratedValue(generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "SEQ_TM_DATA_BAR_ID")
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@Column(name = "TM_DATA_BAR_ID")
	private Long id;
	/**
	 * 区域
	 */
	@JsonIgnore
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "TM_AREA_ID", insertable = false, updatable = false)
	private Area area;

	@Column(name = "TM_AREA_ID")
	private Long areaId;
	/**
	 * 功能分类
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String type;
	/**
	 * 描述
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String name;
	/**
	 * 图片路径
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private String picture;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private Integer orders;

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "databar")
	@OrderBy("orders")
	private SortedSet<Tag> tags;

	@Override
	public int compareTo(DataBar o) {
		return (this.orders == null ? 0 : this.orders) - (o.orders == null ? 0 : o.orders);
	}
}
