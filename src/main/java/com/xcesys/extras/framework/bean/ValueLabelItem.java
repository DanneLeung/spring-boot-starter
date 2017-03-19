package com.xcesys.extras.framework.bean;

import java.io.Serializable;

/**
 * A simple JavaBean to represent code-value pairs. This is most commonly used
 * when constructing user interface elements which have a label to be displayed
 * to the user, and a corresponding value to be returned to the server. One
 * exampel is dropdown list.
 * 
 * @author Danne
 * 
 */
public class ValueLabelItem implements Comparable<ValueLabelItem>, Serializable {

	public static final String FIELD_DESCRIPTION = "description";

	public static final String FIELD_ID = "id";

	public static final String FIELD_LABEL = "label";

	public static final String FIELD_SEQNUM = "seq";

	public static final String FIELD_VALUE = "value";

	private static final long serialVersionUID = -6477134999088399608L;

	private String category;

	/**
	 * Detail description for item.
	 */
	private String desc;

	/**
	 * Display label combined with value & '-' & label.
	 */
	private String displayLabel;

	/**
	 * Unique id for item.
	 */
	private Long id;

	/**
	 * Label for item.
	 */
	private String label;

	/**
	 * Sortable sequence value for item.
	 */
	private Integer seq;

	/**
	 * value for item.
	 */
	private String value;

	public ValueLabelItem() {
	}

	public ValueLabelItem(Long id, String value, String label) {
		this(id, value, label, null);
	}

	public ValueLabelItem(Long id, String value, String label,
			String description) {
		super();
		this.id = id;
		this.value = value;
		this.label = label;
		this.desc = description;
	}

	public ValueLabelItem(Long id, String value, String label,
			String description, String category) {
		super();
		this.id = id;
		this.value = value;
		this.label = label;
		this.desc = description;
		this.category = category;
	}

	public ValueLabelItem(String value, String label) {
		this(null, value, label);
	}

	@Override
	public int compareTo(ValueLabelItem item) {
		int ret = 0;
		if (this.seq != null && item.getSeq() != null) {
			ret = this.seq.compareTo(item.getSeq());
		}
		if (ret == 0) {
			ret = (this.getValue() + this.getLabel()).compareToIgnoreCase(item
					.getValue() + item.getLabel());
		}
		return ret;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		final ValueLabelItem other = (ValueLabelItem) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value)) {
			return false;
		}
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label)) {
			return false;
		}
		return true;
	}

	public String getCategory() {
		return category;
	}

	/**
	 * 
	 * @return
	 * @deprecated uses displayLabel instead.
	 */
	@Deprecated
	public String getCodeLabel() {
		return this.getDisplayLabel();
	}

	public String getDesc() {
		return desc;
	}

	public String getDisplayLabel() {
		if (displayLabel == null) {
			if (this.value != null && this.value.equals(this.label)) {
				this.displayLabel = this.value;
			} else {
				displayLabel = this.value
						+ ((this.label == null || this.label.trim().length() == 0) ? ""
								: (" - " + this.label));
			}
		}
		return displayLabel;
	}

	public Long getId() {
		return id;
	}

	public String getLabel() {
		if (this.label == null) {
			this.label = "";
		}
		return this.label;
	}

	public Integer getSeq() {
		return seq;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((value == null) ? 0 : value.hashCode());
		result = PRIME * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDesc(String description) {
		this.desc = description;
	}

	public void setDisplayLabel(String displayLabel) {
		this.displayLabel = displayLabel;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLabel(String name) {
		this.label = name;
	}

	public void setSeq(Integer seqNum) {
		this.seq = seqNum;
	}

	public void setValue(String code) {
		this.value = code;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";
		String retValue = "";
		retValue = "ValueLabelItem ( " + super.toString() + TAB + "id = "
				+ this.id + TAB + "code = " + this.value + TAB + "name = "
				+ this.label + TAB + "description = " + this.desc + TAB
				+ "seqNum = " + this.seq + TAB + " )";

		return retValue;
	}

}
