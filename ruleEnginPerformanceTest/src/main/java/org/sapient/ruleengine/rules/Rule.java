package org.sapient.ruleengine.rules;

import java.util.List;

import org.sapient.ruleengine.trade.model.TradeData;

public interface Rule
{
	boolean fireRule(List<TradeData> tradeDatas);
}
