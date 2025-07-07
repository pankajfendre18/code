package com.test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.text.IsEmptyString;
import org.junit.jupiter.api.Test;

class HamcrestMatchersTest {

	@Test
	void test() {
		List<Integer> scores = Arrays.asList(101, 102, 103, 104);

		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(101, 102));
		assertThat(scores, everyItem(greaterThan(100)));
		assertThat(scores, everyItem(lessThan(105)));

		assertThat("", IsEmptyString.emptyString());
		assertThat(null, IsEmptyString.emptyOrNullString());

		Integer marks[] = { 50, 60, 70, 80, 90 };
		assertThat(marks, arrayWithSize(5));
		assertThat(marks, arrayContaining(50, 60, 70, 80, 90));
		assertThat(marks, arrayContainingInAnyOrder(80, 70, 90, 50, 60));
	}

}
