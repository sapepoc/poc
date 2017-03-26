package org.sapient.ruleengin;

import java.util.List;

import org.sapient.ruleengin.facts.RuleType;
import org.sapient.ruleengin.trade.model.Entity;

public interface RuleEngin
{
	void fireRule(List<RuleType> ruleTypes, List<? extends Entity> facts);
}
