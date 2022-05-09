package configReadExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfigDemo {

	Properties pro;

	public ReadConfigDemo() throws Exception {

		FileInputStream fis = new FileInputStream("./configFile/configData.properties");

		pro = new Properties();

		pro.load(fis);

	}

	public String getAppURL() {

		String appURL = pro.getProperty("appURL");
		return appURL;

	}
	
	public String getQAAppURL() {

		String appURL = pro.getProperty("QA_appURL");
		return appURL;

	}

	public String getAdminUser() {

		return pro.getProperty("userName");

	}

	public String getAdminPassword() {

		return pro.getProperty("password");

	}

}
