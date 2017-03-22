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
	@JsonView(DataTablesOutput.View.class)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent", orphanRemoval = true)
	protected Set<T> children = new HashSet<T>();

	/**
	 * Depth value in tree.
	 */
	@JsonView(DataTablesOutput.View.class)
	protected Integer depth;
	/**
	 * String value with tree depth indent.
	 */
	@JsonView(DataTablesOutput.View.class)
	protected String displayName;
	/**
	 * Flag indicates leaf node.
	 */
	@JsonView(DataTablesOutput.View.class)
	private Boolean leaf;
	/**
	 * Lineage representing tree path to this node.
	 */
	@JsonView(DataTablesOutput.View.class)
	protected String lineage;
	/**
	 * Node type string value.
	 */
	@JsonView(DataTablesOutput.View.class)
	protected String type;

	/**
	 * String value representing unique tree node name.
	 */
	@JsonView(DataTablesOutput.View.class)
	protected String name;

	/**
	 * Parent node object.
	 */

	@JsonView(DataTablesOutput.View.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	protected T parent;

	/**
	 * Parent node id.
	 */
	// @JsonView(DataTablesOutput.View.class)
	// @Column(name = "parent_id")
	// protected Long parentId;
	/**
	 * Sortable sequence in tree node, if subclass should let it be set to max
	 * value automatically, so should set it to zero value before persisting it
	 */
	@JsonView(DataTablesOutput.View.class)
	protected Integer seq = Integer.valueOf(0);

	@Override
	public int compareTo(T o) {
		Integer seq2 = o.getSeq();
		if (seq2 == null) {
			seq2 = Integer.valueOf(0);
		}
		return (this.seq == null ? Integer.valueOf(0) : this.seq).compareTo(seq2);
	}

	public Integer getDepth() {
		int newDepth = this.parent == null ? 1 : ((this.parent.getDepth() == null ? 1 : this.parent.getDepth()) + 1);
		if (this.depth == null || !this.depth.equals(newDepth)) {
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
	public Boolean getLeaf() {
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
	public Integer getSeq() {
		if (this.seq == null) {
			this.seq = 1;
			return this.seq;
		}
		// if this.seq has default zero value
		if (this.parent != null && this.seq != null && this.seq.intValue() == 0) {
			this.seq = 1;
			Set<T> chld = this.parent.getChildren();
			if (chld != null) {
				for (T t : chld) {
					if (t != this && t.getSeq() != null) {
						this.seq = Math.max(this.seq, t.getSeq());
					}
				}
				this.seq++;
			} else {
				// its parent has no children, then set seq to one.
				this.seq = Integer.valueOf(1);
			}
		}
		return this.seq;
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
