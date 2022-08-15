package com.appium.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * Runs cucumber every detected feature as separated test
 */
public class TestNGCucumberExecutable {
	
    private TestNGCucumberRunner testNGCucumberRunner;
    public static Properties Config;
    public static Properties LoginOR;
    public static FileInputStream fs;
    public static String filePath ;
    public static File file;
    public static HashMap<String,String> map; 
    
    
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        initPropertyFiles();
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    /**
     * @return returns two dimensional array of {@link CucumberFeatureWrapper} objects.
     */
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
    
    public static boolean initPropertyFiles() throws IOException
   	{
   		try {
       	//System.out.println(System.getProperty("user.dir"));
   		
   		//Config
       	filePath=System.getProperty("user.dir") + "/src/Config/config.properties";
   		fs = new FileInputStream(filePath);
   		Config = new Properties();
   		Config.load(fs);
   		String newPackageName =Config.get("package").toString();
   		String newEnvironment = Config.get("environment").toString();
   		System.out.println("New package :"+newPackageName);
   		System.out.println("New environment :"+newEnvironment);
   		
   		//Login OR 
   		filePath=System.getProperty("user.dir") + "/src/test/java/com/pages/CDAndroid/AndroidCDAppLoginOR.properties";
   		file = new File(filePath);
   		
   		initEnvironmentVariables(file);
   		modifyPropertyFile(newPackageName,newEnvironment,file);
   		
   		// Send Money OR 
   		filePath=System.getProperty("user.dir") + "/src/test/java/com/pages/CDAndroid/AndroidCDAppSendMoney.properties";
   	    file = new File(filePath);
   	    modifyPropertyFile(newPackageName,newEnvironment,file);
   		
   		// Wallet OR
   		filePath=System.getProperty("user.dir") + "/src/test/java/com/pages/CDAndroid/AndroidCDAppWalletOR.properties";
   		file = new File(filePath);
   		modifyPropertyFile(newPackageName,newEnvironment,file);
   		
   		// Account OR
   		filePath=System.getProperty("user.dir") + "/src/test/java/com/pages/CDAndroid/AndroidCDAppAccountOR.properties";
   		file = new File(filePath);
   		modifyPropertyFile(newPackageName,newEnvironment,file);
   		
   		// Recipients OR
   		filePath=System.getProperty("user.dir") + "/src/test/java/com/pages/CDAndroid/AndroidCDAppRecipients.properties";
   		file = new File(filePath);
   		modifyPropertyFile(newPackageName,newEnvironment,file);
   		
   		
   		// Registration OR
   		filePath=System.getProperty("user.dir") + "/src/test/java/com/pages/CDAndroid/AndroidCDAppRegistration.properties";
   		file = new File(filePath);
   		modifyPropertyFile(newPackageName,newEnvironment,file);
   		
   		// Dashboard OR
   		filePath=System.getProperty("user.dir") + "/src/test/java/com/pages/CDAndroid/AndroidDashOR.properties";
   		file = new File(filePath);
   		modifyPropertyFile(newPackageName,newEnvironment,file);
   		
   		
   		// ExternalApp OR
   		filePath=System.getProperty("user.dir") + "/src/test/java/com/pages/CDAndroid/AndroidExternalAppOR.properties";
   		file = new File(filePath);
   		modifyPropertyFile(newPackageName,newEnvironment,file);
   		
   		return true;
   		}catch (Exception e){
   			System.out.println(e.getMessage());
   		return false;
   		}

   	}
       
   	public static boolean initEnvironmentVariables(File file) {
//*[@resource-id='com.bnt.currencydirect.sit:id/lottie_layout']
   		String[] dataArray;
   		String oldPackageName ="";
   		String oldEnvironmentName="";
   		map = new HashMap<String, String>();
   		// Reading first line xpath from loginOR file
   		Scanner scanner = null;
   		try {
   			scanner = new Scanner(file);
   			String value = scanner.nextLine();

   			if (value.isEmpty()) {
   				while (scanner.hasNextLine()) {
   					value = scanner.nextLine();
   					if (!value.isEmpty()) {
   						break;
   					}
   				}
   			}

   			dataArray = value.split("=");
   			dataArray = dataArray[1].split(":");
   			value = dataArray[0].substring(1, dataArray[0].length()); // to remove (')
   			dataArray = value.split("[.]");
   			for (int i = 0; i < dataArray.length; i++) { // to separate package name and environment name
   				if (i == dataArray.length - 1) {
   					oldEnvironmentName = dataArray[i];
   					map.put("oldEnvironmentName", oldEnvironmentName);
   				} else {
   					if(oldPackageName.isEmpty()){
   						oldPackageName = oldPackageName + dataArray[i];
   					}else{
   						oldPackageName = oldPackageName + "." + dataArray[i];
   					}
   				}
   			}
   			System.out.println("Old pacakge :"+oldPackageName);
   			System.out.println("Old enviornment :"+oldEnvironmentName);
   			map.put("oldPackageName", oldPackageName);
   			map.put("newPackageName", Config.get("package").toString());

   		} catch (FileNotFoundException e) {
   			System.out.println(e.getMessage());

   		}
   		return true;
   	}
      
   	public static  boolean  modifyPropertyFile(String pacakge, String env, File file) throws IOException{
    			String oldContent="";
   			BufferedReader reader = null;
   			FileWriter writer = null;
   			try {
   			reader = new BufferedReader(new FileReader(file));
   			String line = reader.readLine();
   			
   			while (line != null){
   				oldContent = oldContent + line + System.lineSeparator();
   				line = reader.readLine();
   			}
   			String oldEnvironmentName = map.get("oldEnvironmentName");
   			String oldPackageName = map.get("oldPackageName");
   			String newContent= oldContent.replaceAll(oldEnvironmentName,env);
   			newContent=newContent.replaceAll(oldPackageName, pacakge);
   			writer = new FileWriter(file);
   			writer.write(newContent);
   			System.out.println("New xpath changes updated in file :"+file.getName());
   			return true;
   		} catch (IOException e) {
   			System.out.println(e.getMessage());
   			return false;
   		}finally{
   			reader.close(); 
   			writer.close();
   		}
       	
       }
}