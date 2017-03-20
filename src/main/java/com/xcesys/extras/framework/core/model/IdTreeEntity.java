package com.xcesys.extras.framework.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

/**
 * This class defines some properties representing tree data structure.
 * 
 * @author Danne
 * 
 */
@SuppressWarnings("rawtypes")
@MappedSuperclass
public abstract class IdTreeEntity<T extends IdTreeEntity> extends IdAuditableEntity implements Comparable<T> {
	private static final long serialVersionUID = 9122288078023262971L;
	/**
	 * A list of children nodes.
	 */
	protected Set<T> children = new HashSet<T>();

	/**
	 * Depth value in tree.
	 */
	protected Integer depth;
	/**
	 * String value with tree depth indent.
	 */
	protected String displayName;
	/**
	 * Flag indicates leaf node.
	 */
	private Boolean leaf;
	/**
	 * Lineage representing tree path to this node.
	 */
	protected String lineage;
	/**
	 * Node type string value.
	 */
	protected String type;

	/**
	 * String value representing unique tree node name.
	 */
	protected String name;

	/**
	 * Parent node object.
	 */
	protected T parent;

	/**
	 * Parent node id.
	 */
	protected Long parentId;
	/**
	 * Sortable sequence in tree node, if subclass should let it be set to max
	 * value automatically, so should set it to zero value before persisting it
	 */
	protected Integer seq = Integer.valueOf(0);

	@Override
	public int compareTo(T o) {
		Integer seq2 = o.getSeq();
		if (seq2 == null) {
			seq2 = Integer.valueOf(0);
		}
		return (this.seq == null ? Integer.valueOf(0) : this.seq).compareTo(seq2);
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent", orphanRemoval = true)
	public Set<T> getChildren() {
		return this.children;
	}

	@Column(name = "depth", precision = 5, scale = 0)
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

	@Column(name = "lineage", length = 300)
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

	@Column(name = "name", unique = true, nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public T getParent() {
		return parent;
	}

	@Column(name = "parent_id", precision = 20, scale = 0, insertable = false, updatable = false)
	public Long getParentId() {
		if (this.parentId == null) {
			this.parentId = this.parent != null ? this.parent.getId() : null;
		}
		return parentId;
	}

	@SuppressWarnings("unchecked")
	@Column(name = "seq", precision = 5, scale = 0)
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

	@Column(name = "type", length = 4)
	public String getType() {
		return type;
	}

	public void setChildren(Set<T> children) {
		this.children = children;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public void setLineage(String lineage) {
		this.lineage = lineage;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(T parent) {
		this.parent = parent;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	@Transient
	public String toString() {
		return name;
	}

}
