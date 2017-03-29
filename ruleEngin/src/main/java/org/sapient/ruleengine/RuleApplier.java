package org.sapient.ruleengine;

import java.util.List;

import org.sapient.ruleengine.trade.model.Entity;

public interface RuleApplier
{
	void applyRule(List<? extends Entity> facts);
}
