package com.project.common.core.utils;

import ch.qos.logback.core.PropertyDefinerBase;

import java.util.Random;

public class LogRandomNumUtil extends PropertyDefinerBase {
	private static Random rand = new Random();
	private static String randNum = "";
	static {
		randNum = (rand.nextInt(900000)+ 100000) + "";
	}
	@Override
    public String getPropertyValue() {
        return randNum;
    }
}
