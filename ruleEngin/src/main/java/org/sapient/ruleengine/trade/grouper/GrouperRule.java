package org.sapient.ruleengine.trade.grouper;

public interface GrouperRule 
{
	boolean isValidPair(String type1, String type2);
}
