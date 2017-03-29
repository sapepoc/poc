package org.sapient.ruleengine.facts;

public interface FactProcessor<F extends Fact>
{
	void process(F fact);
}
