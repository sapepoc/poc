package org.sapient.ruleengine;

import java.util.List;

import org.sapient.ruleengine.rules.Rule;

public interface RuleBuilder 
{
	public List<Rule> buildRules(List<RuleData> ruleDatas);
}
