package com.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ArrayCompareTest.class, QuickBeforeAfterTest.class, StringHelperParameterizedTest.class,
		StringHelperParameterizedTest1.class, StringHelperTest.class })
public class AllTests {

}
