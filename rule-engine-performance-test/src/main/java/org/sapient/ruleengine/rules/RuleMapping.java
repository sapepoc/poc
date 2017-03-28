package org.sapient.ruleengine.rules;

public enum RuleMapping 
{
			
	RULE1("trade.buy.amount.rule", TradeBuyAmountRule.class),
	RULE2("trade.buy.quantity.rule", TradeBuyQuantityRule.class),
	RULE3("trade.sell.amount.rule", TradeSellAmountRule.class),
	RULE4("trade.sell.quantity.rule", TradeSellQuantityRule.class);
	
	private RuleMapping(String ruleName, Class<?> clazz)
	{
		this.ruleName = ruleName;
		this.clazz = clazz;
	}
	
	public static RuleMapping getRuleMapping(String ruleName)
	{
		for (RuleMapping ruleMapping : RuleMapping.values()) 
		{
			if(ruleMapping.getRuleName().equals(ruleName))
			{
				return ruleMapping;
			}
		}
		
		throw new RuntimeException("No rule mapping found for ruleName:"+ ruleName);
	}
	
	private String ruleName;
	private Class<?> clazz;
	
	public String getRuleName() 
	{
		return ruleName;
	}
	
	public Class<?> getClazz() 
	{
		return clazz;
	}
}
