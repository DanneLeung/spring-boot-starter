package com.xcesys.extras.framework.core.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.NonNull;

@Data
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 7117733819280049542L;

	@NonNull
	@JsonView(View.class)
	private Integer error;

	@NonNull
	@JsonView(View.class)
	private String message;

	@JsonView(View.class)
	private Iterable<T> content;

	public interface View {
	}
}
