package org.sapient;

public interface FactProcessor<F extends Fact>
{
	void process(F fact);
}
