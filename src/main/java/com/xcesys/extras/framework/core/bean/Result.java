package com.xcesys.extras.framework.core.bean;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.NonNull;

@Data
public class Result<T> {
	@NonNull
	@JsonView(View.class)
	private Integer error;
	@NonNull
	@JsonView(View.class)
	private String msg;
	@JsonView(View.class)
	private T content;

	public interface View {
	}
}
