package com.xcesys.extras.framework.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;
import com.xcesys.extras.framework.core.bean.PageResult;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class defines some properties representing tree data structure.
 * 
 * @author Danne
 * 
 */
@SuppressWarnings("rawtypes")
@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class IdTreeEntity<T extends IdTreeEntity> extends IdAuditableEntity implements Comparable<T> {
	private static final long serialVersionUID = 9122288078023262971L;
	/**
	 * A list of children nodes.
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent", orphanRemoval = true)
	protected Set<T> children = new HashSet<T>();

	/**
	 * Depth value in tree.
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	protected int depth = 1;
	/**
	 * String value with tree depth indent.
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	protected String displayName;
	/**
	 * Flag indicates leaf node.
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	private boolean leaf;
	/**
	 * Lineage representing tree path to this node.
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	protected String lineage;
	/**
	 * Node type string value.
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	protected String type;

	/**
	 * String value representing unique tree node name.
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	protected String name;

	/**
	 * Parent node object.
	 */

	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	protected T parent;

	/**
	 * Parent node id.
	 */
	// @JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	// @Column(name = "parent_id")
	// protected Long parentId;
	/**
	 * Sortable sequence in tree node, if subclass should let it be set to max
	 * value automatically, so should set it to zero value before persisting it
	 */
	@JsonView(value = { DataTablesOutput.View.class, PageResult.View.class })
	protected int sort = 0;

	@Override
	public int compareTo(T o) {
		return this.sort - o.getSort();
	}

	public int getDepth() {
		int newDepth = this.parent == null ? 1 : ((this.parent.getDepth() == 0 ? 1 : this.parent.getDepth()) + 1);
		if (this.depth == newDepth) {
			this.depth = newDepth;
		}
		return this.depth;
	}

	@Transient
	public String getDisplayName() {
		if (this.depth > 1) {
			this.displayName = StringUtils.leftPad("　　", this.depth - 1) + "－" + this.name;
		} else {
			this.displayName = "+ " + this.name;
		}
		return displayName;
	}

	@Transient
	public boolean getLeaf() {
		return leaf;
	}

	public String getLineage() {
		if (this.getId() == null) {
			this.lineage = null;
		} else {
			String la = (this.parent == null ? "0." : this.parent.getLineage()) + this.getId() + ".";
			if (StringUtils.isBlank(lineage) || !lineage.equals(la)) {
				this.lineage = la;
			}
		}
		return this.lineage;
	}

	public String getName() {
		return this.name;
	}

	public T getParent() {
		return parent;
	}

	// public Long getParentId() {
	// if (this.parentId == null) {
	// this.parentId = this.parent != null ? this.parent.getId() : null;
	// }
	// return parentId;
	// }

	@SuppressWarnings("unchecked")
	public int getSort() {
		// if this.seq has default zero value
		if (this.parent != null && this.sort == 0) {
			this.sort = 1;
			Set<T> chld = this.parent.getChildren();
			if (chld != null) {
				for (T t : chld) {
					if (t != this && t.getSort() > 0) {
						this.sort = Math.max(this.sort, t.getSort());
					}
				}
				this.sort++;
			} else {
				// its parent has no children, then set seq to one.
				this.sort = 1;
			}
		}
		return this.sort;
	}

	@Transient
	public String getTreeName() {
		String treeName = this.name;
		if (getParent() != null) {
			treeName = getParent().getTreeName() + ">" + treeName;
		}
		return treeName;
	}

	public String getType() {
		return type;
	}

	@Override
	@Transient
	public String toString() {
		return name;
	}

}
