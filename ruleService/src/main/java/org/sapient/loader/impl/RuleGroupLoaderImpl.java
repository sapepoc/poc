package org.sapient.loader.impl;

import java.util.Collection;

import org.sapient.loader.RuleGroupLoader;
import org.sapient.rule.RuleGroup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ruleGroupLoader")
public class RuleGroupLoaderImpl implements RuleGroupLoader {

	@Override
	public Collection<RuleGroup> getRuleGroup() {
		// TODO Auto-generated method stub
		System.out.println("I am collecting Rule group and sending it back");
		return null;
	}

}
