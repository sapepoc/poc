package org.sapient.ruleengine;

import java.util.List;

import org.sapient.ruleengine.alarm.core.AlarmEventProcessor;
import org.sapient.ruleengine.rules.Rule;
import org.sapient.ruleengine.trade.model.TradeData;

public class JavaRuleEngin extends AbstractRuleEngin
{
	private RuleBuilder builder;
	public JavaRuleEngin(AlarmEventProcessor alarmEventProcessor, RuleBuilder builder)
	{
		super(alarmEventProcessor);
		this.builder = builder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> int fireRules0(List<T> entities, List<RuleData> ruleDatas)
	{
		int fireRules = 0;
		List<Rule> buildRules = builder.buildRules(ruleDatas);
		for (Rule rule : buildRules) 
		{
			if(rule.fireRule((List<TradeData>)entities))
			{
				fireRules++;
			}
		}
		return fireRules;
	}
	
}
