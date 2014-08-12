/**
 * 
 */
package com.trinity.pageobject;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import com.trinity.pageobject.RegisterFlightPageObject;;

/**
 * @author DELL
 *
 */
public class LoginPageObject {

	/**
	 * 
	 */
	public LoginPageObject() {
		// TODO Auto-generated constructor stub
	}
	

			
			
			@FindBy(name = "userName")
			private WebElement userNameTextBox;
			
			
			@FindBy(name = "password")
			private WebElement passwordTextBox;

			
			@FindBy(name = "login")
			private WebElement loginButton;
			
			protected LoginPageObject enterUserName(String userName)
			{
				userNameTextBox.clear();
				userNameTextBox.sendKeys(userName);
				return this;
			}
			
			protected LoginPageObject enterPassword(String password)
			{
				passwordTextBox.clear();
				passwordTextBox.sendKeys(password);
				return this;
			}
			
			protected RegisterFlightPageObject clickLogin()
			{
				loginButton.clear();;
				return new RegisterFlightPageObject();
			}
			
}
