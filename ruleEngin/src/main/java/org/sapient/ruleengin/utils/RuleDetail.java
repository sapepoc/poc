package org.sapient.ruleengin.utils;

public final class RuleDetail
{
	private final String ruleName;
	
	public RuleDetail(String ruleName)
	{
		this.ruleName = ruleName;
	}
	
	public String getRuleName()
	{
		return ruleName;
	}

	@Override
	public String toString()
	{
		return "RuleDetail [ruleName=" + ruleName + "]";
	}
}
