package com.tek.utility;

public final class Assert {

	private Assert() {
	}

	public static void notNull(String fieldName, Object input) {
		if (input == null) {
			throw MissingMandatoryValueException.forNullValue(fieldName);
		}
	}

	public static void notBlank(String fieldName, String input) {
		if (input == null) {
			throw MissingMandatoryValueException.forNullValue(fieldName);
		}

		if (input.isBlank()) {
			throw MissingMandatoryValueException.forBlankValue(fieldName);
		}
	}

	public static StringAsserter field(String fieldName, String value) {
		return new StringAsserter(fieldName, value);
	}

	public static class StringAsserter {
		private final String fieldName;
		private final String value;

		private StringAsserter(String fieldName, String value) {
			this.fieldName = fieldName;
			this.value = value;
		}

		public StringAsserter notBlank() {
			Assert.notBlank(fieldName, value);
			return this;
		}

		public StringAsserter maxLength(int maxLength) {
			if (value != null && value.length() > maxLength) {
				throw StringSizeExceededException.builder().field(fieldName).currentLength(value.length())
						.maxLength(maxLength).build();
			}
			return this;
		}
	}
}
