package org.sapient.ruleengine;

import java.util.List;

import org.sapient.ruleengine.facts.RuleType;
import org.sapient.ruleengine.trade.model.Entity;

public interface RuleEngin
{
	void fireRule(List<RuleType> ruleTypes, List<? extends Entity> facts);
}
