package org.sapient.ruleengine.report;

public final class PerformanceReport
{
	private final long timeTakenInMillis;
	private final long memoryConsumptionInMB;

	public PerformanceReport()
	{
		this(0, 0);
	}

	public PerformanceReport(long timeTakenInMillis, long memoryConsumptionInMB)
	{
		this.timeTakenInMillis = timeTakenInMillis;
		this.memoryConsumptionInMB = memoryConsumptionInMB;
	}

	public long getTimeTakenInMillis() 
	{
		return timeTakenInMillis;
	}

	public long getMemoryConsumptionInMB()
	{
		return memoryConsumptionInMB;
	}

	@Override
	public String toString() 
	{
		return "PerformanceReport [timeTakenInMillis=" + timeTakenInMillis + ", memoryConsumptionInMB="
				+ memoryConsumptionInMB + "]";
	}

}