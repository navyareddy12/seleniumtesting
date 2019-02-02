package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class New {
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
	WebElement signin;
	public void login(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		signin.click();
	}
}
