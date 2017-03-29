package org.sapient.ruleengine;

public final class PerformanceReport 
{
	private final int noOfRuleFired;
	private final long timeTakenInMillis;
	private final long memoryConsumptionInMB;
	
	public PerformanceReport() 
	{
		this(0, 0, 0);
	}
	
	public PerformanceReport(int noOfRuleFired, long timeTakenInMillis, long memoryConsumptionInMB) 
	{
		this.noOfRuleFired = noOfRuleFired;
		this.timeTakenInMillis = timeTakenInMillis;
		this.memoryConsumptionInMB = memoryConsumptionInMB;
	}
	
	public int getNoOfRuleFired() {
		return noOfRuleFired;
	}
	public long getTimeTakenInMillis() {
		return timeTakenInMillis;
	}
	public long getMemoryConsumptionInMB() {
		return memoryConsumptionInMB;
	}
	
	@Override
	public String toString() 
	{
		return "PerformanceReport [noOfRuleFired=" + noOfRuleFired
				+ ", timeTakenInMillis=" + timeTakenInMillis
				+ ", memoryConsumptionInMB=" + memoryConsumptionInMB + "]";
	}
}
