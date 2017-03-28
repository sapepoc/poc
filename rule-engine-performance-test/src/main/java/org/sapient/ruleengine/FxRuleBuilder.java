package org.sapient.ruleengine;

import java.util.ArrayList;
import java.util.List;

import org.sapient.ruleengine.rules.Rule;
import org.sapient.ruleengine.rules.RuleMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FxRuleBuilder implements RuleBuilder
{
	private ApplicationContext applicationContext;
	
	@Override
	public List<Rule> buildRules(List<RuleData> ruleDatas) 
	{
		List<Rule> rules = new ArrayList<>();
		for (RuleData ruleData : ruleDatas) 
		{
			RuleMapping ruleMapping = RuleMapping.getRuleMapping(ruleData.getRuleName());
			Class<?> clazz = ruleMapping.getClazz();
			Object rule = applicationContext.getBean(clazz);
			rules.add((Rule)rule);
		}
		return rules;
	}
	
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) 
	{
		this.applicationContext = applicationContext;
	}
}
