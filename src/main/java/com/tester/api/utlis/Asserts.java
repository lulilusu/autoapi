package com.tester.api.utlis;

import com.tester.api.listeners.ReportListener;


public class Asserts {

    public static void asserts(String actual, String expected, int statusCode) {
        verifyResult(actual, expected, statusCode);
    }

    public static void verifyResult(String actual, String expected, int statusCode) {
        boolean assertFlag = false;
        StringBuffer assertResult = new StringBuffer();
        if (actual != null || !"".equals(actual.trim())) {
            String[] actualData = actual.split(";");
            for (String assertStr : actualData) {
                if (assertStr.contains(expected)) {
                    assertFlag = true;
                    assertResult.append("状态码: " + statusCode + "\n" + "预期结果: " + "\n" + expected + "\n" + "断言结果: " + assertFlag);
                } else if (!assertStr.contains(expected)) {
                    assertFlag = false;
                    assertResult.append("状态码: " + statusCode + "\n" + "预期结果: " + "\n" + expected + "\n" + "断言结果: " + assertFlag);
                    if (assertFlag = false || statusCode == 200) {
                        assertFlag = true;
                    }
                }
            }
        }
        ReportListener.assertResult(assertResult);
        Assertion.verifyTrue(assertFlag,"断言失败");
    }
}
