package com.POMframework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.WebElementHandler;
import org.openqa.selenium.support.FindBy;

public class Welcomemercurytoursobjectrepository {
@FindBy(linkText="SIGN-ON")
WebElement signon;
public void signon()
{
	signon.click();
}
@FindBy(linkText="REGISTER")
WebElement register;
public void register()
{
	register.click();
}
@FindBy(name="userName")
WebElement username;
@FindBy(name="password")
WebElement password;
@FindBy(name="login")
WebElement login;

public void login(String user, String pwd)
{
	username.sendKeys(user);
	password.sendKeys(pwd);
	login.click();
}
@FindBy(linkText="SUPPORT")
WebElement support;
public void support()
{
	support.click();
}
@FindBy(linkText="CONTACT")
WebElement contact;
public void contact()
{
	contact.click();
}
@FindBy(linkText="Home")
WebElement home;
public void home()
{
	home.click();
}
@FindBy(linkText="Flights")
WebElement flights;
public void flights()
{
	flights.click();
}
@FindBy(linkText="Hotels")
WebElement hotels;
public void hotels()
{
	hotels.click();
}
@FindBy(linkText="Car Rentals")
WebElement car;
public void car()
{
	car.click();
}
@FindBy(linkText="Cruises")
WebElement c;
public void c()
{
	c.click();
}
@FindBy(linkText="Destinations")
WebElement d;
public void d()
{
	d.click();
}
@FindBy(linkText="Vacations")
WebElement vac;
public void vac()
{
	vac.click();
}
@FindBy(linkText="your destination")
WebElement your;
public void your()
{
	your.click();
}
@FindBy(linkText="featured vacation destinations")
WebElement f;
public void f()
{
	f.click();
}
@FindBy(linkText="Register here")
WebElement here;
public void here()
{
	here.click();
}
@FindBy(linkText="Business Travel @ About.com")
WebElement business;
public void business()
{
	business.click();
}
@FindBy(linkText="Salon Travel")
WebElement salon;
public void salon()
{
	salon.click();
}
}
