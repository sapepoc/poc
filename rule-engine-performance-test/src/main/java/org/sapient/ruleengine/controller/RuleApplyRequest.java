package org.sapient.ruleengine.controller;

public final class RuleApplyRequest 
{
	private final int noBunsinessObjects;
	
	public RuleApplyRequest() 
	{
		this(0);
	}

	public RuleApplyRequest(int noBunsinessObjects) 
	{
		this.noBunsinessObjects = noBunsinessObjects;
	}
	
	public int getNoBunsinessObjects()
	{
		return noBunsinessObjects;
	}

	@Override
	public String toString() {
		return "RuleApplyRequest [noBunsinessObjects=" + noBunsinessObjects + "]";
	}
}
