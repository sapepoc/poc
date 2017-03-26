package org.sapient.ruleengin;

import java.util.List;
import java.util.Map;

import org.sapient.ruleengin.facts.RuleType;
import org.sapient.ruleengin.trade.model.Entity;

public class RuleEnginImpl implements RuleEngin 
{
	private Map<RuleType, RuleApplier> ruleAppliers;
	
	public RuleEnginImpl(Map<RuleType, RuleApplier> ruleAppliers)
	{
		this.ruleAppliers = ruleAppliers;
	}
	
	@Override
	public void fireRule(List<RuleType> ruleTypes, List<? extends Entity> facts) 
	{
		for(RuleType ruleType : ruleTypes)
		{
			RuleApplier ruleApplier = ruleAppliers.get(ruleType);
			if(ruleApplier != null)
			{
				ruleApplier.applyRule(facts);
			}
		}
	}
}
