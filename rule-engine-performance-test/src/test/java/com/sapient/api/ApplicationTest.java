package com.sapient.api;

import org.junit.Ignore;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(snippets= SnippetType.CAMELCASE, plugin = {"progress"}, monochrome = true, 
tags = {"@dev"})
@Ignore
public class ApplicationTest {

}
