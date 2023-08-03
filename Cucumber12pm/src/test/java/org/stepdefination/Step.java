package org.stepdefination;

import org.helper.Basecla;
import org.testng.internal.BaseClassFinder;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.POJONode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step extends Basecla {
	@Given("User have to enter facebook login through Chrome browser")
	public void user_have_to_enter_facebook_login_through_Chrome_browser() {
	   chromebrowser();
	   passurl("https://www.facebook.com/");
	
	}

	@When("User have to enter Vaild email and Invaild Password")
	public void user_have_to_enter_Vaild_email_and_Invaild_Password() {
	  
	}

	@When("User have to click login button")
	public void user_have_to_click_login_button() {
	    System.out.println("Actions step");
	}

	@Then("User have to reach invaild credentanils page")
	public void user_have_to_reach_invaild_credentanils_page() {
	    System.out.println("Browser close....");
	}


}
