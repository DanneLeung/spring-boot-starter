package com.xcesys.extras.framework.core.bean;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.NonNull;

@Data
public class Result {
	@NonNull
	@JsonView(View.class)
	private Integer error;
	@NonNull
	@JsonView(View.class)
	private String msg;

	public interface View {
	}
}
