package org.sapient.ruleengine.report;

import org.sapient.ruleengine.utils.CommonUtils;
import org.springframework.stereotype.Component;

@Component
public final class PerformanceMonitor 
{
	private long beforeUsedMemory;
	private long startTime;
	private long endTime;
	private long afterUsedMemory;

	public void startMonitoring()
	{
		Runtime runtime = Runtime.getRuntime();
		beforeUsedMemory = (runtime.totalMemory() - runtime.freeMemory());
		startTime = System.currentTimeMillis();
	}
	
	public void reset()
	{
		this.beforeUsedMemory = 0;
		this.startTime = 0;
		this.endTime = 0;
		this.afterUsedMemory = 0;
	}
	
	public PerformanceReport stopMonitoring()
	{
		endTime = System.currentTimeMillis();
		afterUsedMemory =  Runtime.getRuntime().totalMemory() -  Runtime.getRuntime().freeMemory();
		return generateReport();
	}
	
	public PerformanceReport generateReport()
	{
		long timeTakenInMillis = (endTime - startTime);
		long memoryUsedInKB = afterUsedMemory - beforeUsedMemory;
		return new PerformanceReport(timeTakenInMillis, CommonUtils.bytesToMegabytes(memoryUsedInKB));
	}

	@Override
	public String toString() 
	{
		return "PerformanceMonitor [beforeUsedMemory=" + beforeUsedMemory + ", startTime=" + startTime + ", endTime="
				+ endTime + ", afterUsedMemory=" + afterUsedMemory + "]";
	}
}
