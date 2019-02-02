package com.multipledata;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="OHRM_login",glue= {"com.ohrmmultipledatalogin"})
public class Runner {

}
