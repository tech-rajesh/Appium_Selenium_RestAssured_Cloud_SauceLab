package testsNOP;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	
	@Test
	public void login_with_userNameBlank() {
		//userName
		//password: admin
		//click on login button
		//validate something
		lp.enterEmail("");
		
		
	}
	
	
	@Test
	public void verifyEmailLabel() {
		
		lp.verifyEmailLabel();
		
		
	}
	
	@Test
	public void verifyEmailLabelText() {
		
		lp.verifyEmailLabelText("Email");
		
		
	}
	
	@Test
	public void login_with_passwordBlank() {
		//userName: 
		//password: 
		
		System.out.println("login_with_passwordBlank");
		
		
	}
	
	
	@Test(priority = 1)
	public void login_with_validcred() {
		//userName: 
		//password: 
		
		lp.enterEmail("admin@yourstore.com");
		
		
	}
	
	
}
