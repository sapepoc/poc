package org.sapient.ruleengin;

import java.util.List;

import org.sapient.ruleengin.trade.model.Entity;

public interface RuleApplier
{
	void applyRule(List<? extends Entity> facts);
}
