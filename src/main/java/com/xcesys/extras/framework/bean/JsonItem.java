package com.xcesys.extras.framework.bean;

import java.io.Serializable;

/**
 * 
 * JSON item object for returning result to client with json format.
 * 
 * @author danne
 * 
 */
public class JsonItem implements Serializable, Comparable<JsonItem> {
	private static final long serialVersionUID = -6712745839690304192L;
	/**
	 * Additional information of object.
	 */
	private String extra;

	/**
	 * identifier of object.
	 */
	private Long id;
	/**
	 * Path to image that representing object.
	 */
	private String image;
	/**
	 * Label or description of object.
	 */
	private String name;
	/**
	 * Parent id for tree structure data.
	 */
	private Long pId;
	/**
	 * String value of object like unique code.
	 */
	private String value;

	public JsonItem() {
		super();
	}

	public JsonItem(long id, Long pId, String value, String name) {
		super();
		this.id = id;
		this.pId = pId;
		this.value = value;
		this.name = name;
	}

	public JsonItem(long id, String name, String image, String extra) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.extra = extra;
	}

	public JsonItem(long id, String value, String name, String image,
			String extra) {
		super();
		this.id = id;
		this.value = value;
		this.name = name;
		this.image = image;
		this.extra = extra;
	}

	@Override
	public int compareTo(JsonItem o) {
		return 0;
	}

	public String getExtra() {
		return extra;
	}

	public Long getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public Long getpId() {
		return pId;
	}

	public String getValue() {
		return value;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setpId(Long pid) {
		this.pId = pid;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
