package org.sapient.ruleengin.facts;

public interface FactProcessor<F extends Fact>
{
	void process(F fact);
}
