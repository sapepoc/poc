package org.sapient.ruleengine;

public final class RuleData 
{
	private String ruleName;
	private String data;
	
	public RuleData(String ruleName, String data) 
	{
		this.ruleName = ruleName;
		this.data = data;
	}

	public String getRuleName() 
	{
		return ruleName;
	}

	public String getData() 
	{
		return data;
	}

	@Override
	public String toString() {
		return "RuleData [ruleName=" + ruleName + ", data=" + data + "]";
	}
	
}
