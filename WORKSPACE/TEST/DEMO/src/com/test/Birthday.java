package com.test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Birthday {
	public static void main(String[] args) {
		LocalDate birthDay = LocalDate.of(1996, 06, 18);
		LocalDate today = LocalDate.now();

		System.out.println(ChronoUnit.YEARS.between(birthDay, today));
	}
}
