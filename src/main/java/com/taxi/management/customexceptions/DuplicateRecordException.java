package com.taxi.management.customexceptions;

public class DuplicateRecordException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateRecordException(String s) {
		super(s);
	}
}
