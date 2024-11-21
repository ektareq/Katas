package com.tek.utility;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

public class MissingMandatoryValueException extends AbstractThrowableProblem {
	
	private MissingMandatoryValueException(String message) {
		super(Problem.DEFAULT_TYPE, message, Status.INTERNAL_SERVER_ERROR);
	}

	public static MissingMandatoryValueException forNullValue(String fieldName) {
		return new MissingMandatoryValueException(defaultMessage(fieldName) + " (null)");
	}

	public static MissingMandatoryValueException forEmptyValue(String fieldName) {
		return new MissingMandatoryValueException(defaultMessage(fieldName) + " (empty)");
	}

	public static MissingMandatoryValueException forBlankValue(String fieldName) {
		return new MissingMandatoryValueException(defaultMessage(fieldName) + " (blank)");
	}

	private static String defaultMessage(String fieldName) {
		return "The field \"" + fieldName + "\" is mandatory and wasn't set";
	}
}