package org.sapient.ruleengine.utils;

public class CommonUtils 
{
	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) 
	{
		return bytes / MEGABYTE;
	}
	
	public static void calculateMemeryConsumption(long beforeUsedMemory) 
	{
		Runtime runtime = Runtime.getRuntime();
		
		long afterUsedMemory = runtime.totalMemory() - runtime.freeMemory();
		long memoryUsedInKB = afterUsedMemory - beforeUsedMemory;
		System.out.println("Memory taken in bytes="+ memoryUsedInKB+ " ,in Mega bytes="+
				CommonUtils.bytesToMegabytes(memoryUsedInKB));
		
	}
	
	public static void calculateTimeTaken(long startTime) 
	{
		System.out.println("Time taken in millis="+(System.currentTimeMillis() - startTime));
	}
	
	public static int convertToInteger(String strValue)
	{
		int value = 0;
		try
		{
			value = Integer.parseInt(strValue);
		}
		catch(NumberFormatException exception)
		{
			exception.printStackTrace();
		}
		return value;
	}

	public static void asleep(int millis) 
	{
		try
		{
			Thread.sleep(millis);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
