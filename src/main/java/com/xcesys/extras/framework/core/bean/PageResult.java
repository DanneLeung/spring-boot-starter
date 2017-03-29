package com.xcesys.extras.framework.core.bean;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.NonNull;

@Data
public class PageResult<T> {
	@NonNull
	@JsonView(View.class)
	private Long total;
	@JsonView(View.class)
	@NonNull
	private Iterable<T> rows;

	public interface View {
	}
}
