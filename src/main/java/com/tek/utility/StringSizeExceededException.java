package com.tek.utility;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

public class StringSizeExceededException extends AbstractThrowableProblem {

	private StringSizeExceededException(StringSizeExceededExceptionBuilder builder) {
		super(Problem.DEFAULT_TYPE, builder.message(), Status.INTERNAL_SERVER_ERROR);
	}

	public static StringSizeExceededExceptionBuilder builder() {
		return new StringSizeExceededExceptionBuilder();
	}

	static class StringSizeExceededExceptionBuilder {
		private String field;
		private int currentLength;
		private int maxLength;

		public StringSizeExceededExceptionBuilder field(String field) {
			this.field = field;

			return this;
		}

		public StringSizeExceededExceptionBuilder currentLength(int currentLength) {
			this.currentLength = currentLength;
			return this;
		}

		public StringSizeExceededExceptionBuilder maxLength(int maxLength) {
			this.maxLength = maxLength;
			return this;
		}

		private String message() {
			return "Length of \"" + field + "\" must be under " + maxLength + " but was " + currentLength;
		}

		public StringSizeExceededException build() {
			return new StringSizeExceededException(this);
		}
	}
}