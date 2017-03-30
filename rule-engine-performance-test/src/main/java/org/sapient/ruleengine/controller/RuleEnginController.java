package org.sapient.ruleengine.controller;

import java.util.List;

import org.sapient.ruleengine.RuleEnginService;
import org.sapient.ruleengine.observers.FxTradeEventObserver;
import org.sapient.ruleengine.report.PerformanceMonitor;
import org.sapient.ruleengine.report.PerformanceReport;
import org.sapient.ruleengine.trade.model.TradeData;
import org.sapient.ruleengine.utils.MockTradeDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applyRules")
public class RuleEnginController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RuleEnginController.class);
	
	private RuleEnginService  ruleEnginService;
	private PerformanceMonitor performanceMonitor;
	private FxTradeEventObserver fxTradeEventObserver;
	
	@Autowired
	public RuleEnginController(RuleEnginService  ruleEnginService, PerformanceMonitor performanceMonitor,
			FxTradeEventObserver fxTradeEventObserver)
	{
		this.ruleEnginService = ruleEnginService;
		this.fxTradeEventObserver = fxTradeEventObserver;
		this.ruleEnginService.register(fxTradeEventObserver);
		this.performanceMonitor = performanceMonitor;
		
	}
	
	@GetMapping(produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> applyRules() 
	{
		LOGGER.info("applyRules-Enter");
		return new ResponseEntity<String>("Hello RuleEngin", HttpStatus.OK);
	}
	
	@PostMapping(consumes =MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PerformanceReport> applyRules(@RequestBody RuleApplyRequest ruleApplyRequest) 
	{
		LOGGER.info("applyRules-Enter", ruleApplyRequest);
		List<TradeData> tradeData = MockTradeDataProvider.createAllDummyWashTrades(ruleApplyRequest.getNoBunsinessObjects());
		System.gc();
		performanceMonitor.startMonitoring();
		
		ruleEnginService.applyRule(tradeData);
		
		PerformanceReport performanceReport = performanceMonitor.stopMonitoring();
		LOGGER.info("applyRules-Leave ,performanceReport={} ,No Of Alerts Generated={}", performanceReport , 
				fxTradeEventObserver.getAlarmEvents().size());
		return new ResponseEntity<PerformanceReport>(performanceReport, HttpStatus.OK);
	}
}