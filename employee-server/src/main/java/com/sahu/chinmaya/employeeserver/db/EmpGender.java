package com.sahu.chinmaya.employeeserver.db;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EmpGender {
	MALE, FEMALE , OTHERS;
	
	public static List<String> names()
	{
		return Stream.of(values())
                .map(Enum::name)
                .collect(Collectors.toList());
	}
}
