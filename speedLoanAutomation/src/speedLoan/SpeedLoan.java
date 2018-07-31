package speedLoan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class SpeedLoan extends DataFactory {
  public static WebDriver driver;
  public static String custPortalUrl= "http://192.168.0.113:4200/";
  public static String adminPortalUrl = "http://192.168.0.126:4200/qlap/home";
  public static String investorPortalUrl= "http://192.168.0.126:4020/";
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSpeedLoan() throws Exception {
	    //Customer apply for loan
	    customerFillForm();
	    newTab();
	    changeToAdminTab();
	    newInvestorInAdmin();
	    newTab();
	    changeToInvestorTab();
	    applicationScreenInInvestor();
	    
	    //Assign application to Investor(admin portal)
	    changeToAdminTab();
	    assignApplication();
	    changeToCustTab();
	    refreshBrowser();
	    
	   //reject application(investor portal)
	    changeToInvestorTab();
	    refreshBrowser();
	    //applicationScreenInInvestor();
	    rejectApplication();
	    refreshBrowser();
	    
	  //Assign application to Investor(admin portal)
	    changeToAdminTab();
	    refreshBrowser();
	    assignApplication();
	    
	    //approve application
	    changeToInvestorTab();
	    refreshBrowser();
	    //applicationScreenInInvestor();
	    approveApplication();
	    refreshBrowser();
	    changeToCustTab();
	    refreshBrowser();
	    changeToAdminTab();
	    refreshBrowser();
	    applicationScreenAdmin();
	    
	  //Loan Lent
	    changeToInvestorTab();
	    loanLent();
	    refreshBrowser();
	    changeToAdminTab();
	    refreshBrowser();
	    changeToCustTab();
	    refreshBrowser();
	    
	    //Loan Received
	    loanReceived();
	    refreshBrowser();
	    changeToAdminTab();
	    refreshBrowser();
	    changeToInvestorTab();
	    refreshBrowser();
	    
	    //Loan Repaid
	    changeToCustTab();
	    loanRepaid();
	    refreshBrowser();
	    changeToAdminTab();
	    refreshBrowser();
	    changeToInvestorTab();
	    refreshBrowser();
	    
	    //Loan Cleared
	    loanCleared();
	    refreshBrowser();
	    changeToCustTab();
	    refreshBrowser();
	    changeToAdminTab();
	    refreshBrowser();
  }
  
  public void loanLent() throws InterruptedException{
	  for(int i=31;i<=36;i++){
		  try{
			  driver.findElement(By.id("loanLent_"+i+"")).click();
	  break;
		  }catch (Exception e) {
			  System.out.println("Searching for current id");
		  }
		}
  }
  
  public void loanReceived() throws InterruptedException{
	  for(int i=31;i<=36;i++){
		  try{
			  driver.findElement(By.id("loanReceived_"+i+"")).click();
	  break;
		  }catch (Exception e) {
			  System.out.println("Searching for current id");
		  }
		}  
  }
  
  public void loanRepaid() throws InterruptedException{
	  for(int i=31;i<=36;i++){
		  try{
			  driver.findElement(By.id("loanRepaid_"+i+"")).click();
	  break;
		  }catch (Exception e) {
			  System.out.println("Searching for current id");
		  }
		}
  }
  
public void loanCleared() throws InterruptedException{
	for(int i=31;i<=36;i++){
		  try{
			  driver.findElement(By.id("loanCleared_"+i+"")).click();
	  break;
		  }catch (Exception e) {
			  System.out.println("Searching for current id");
		  }
		}
  }
  
  public void customerFillForm() throws InterruptedException{
	    driver.get(custPortalUrl);
	    driver.findElement(By.linkText("Get your loan now!")).click();
	    driver.findElement(By.id("firstName")).sendKeys(getNameString());
	    driver.findElement(By.id("lastName")).sendKeys("John");
	    driver.findElement(By.id("middleName")).sendKeys("Doe");
	    new Select(driver.findElement(By.id("maritalStatus"))).selectByVisibleText("SINGLE");
	    new Select(driver.findElement(By.id("bestTimeToCall"))).selectByVisibleText("AFTERNOON");
	    driver.findElement(By.id("doB")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("body > bs-datepicker-container > div > div > div > div > bs-days-calendar-view > bs-calendar-layout > div.bs-datepicker-body > table > tbody > tr:nth-child(1) > td:nth-child(3) > span")).click();//
	    driver.findElement(By.id("licenseNumber")).sendKeys("452145");
	    new Select(driver.findElement(By.id("licState"))).selectByVisibleText("MAHARASHTRA");
	    driver.findElement(By.id("licIssueDate")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("body > bs-datepicker-container > div > div > div > div > bs-days-calendar-view > bs-calendar-layout > div.bs-datepicker-body > table > tbody > tr:nth-child(1) > td:nth-child(4)")).click();
	    driver.findElement(By.id("licExpirationDate")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("body > bs-datepicker-container > div > div > div > div > bs-days-calendar-view > bs-calendar-layout > div.bs-datepicker-body > table > tbody > tr:nth-child(1) > td:nth-child(4)")).click();
	    driver.findElement(By.id("userdetailbtn")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("address")).sendKeys("Pune, Maharashtra");
	    driver.findElement(By.id("city")).sendKeys("Pune");
	    new Select(driver.findElement(By.id("state"))).selectByVisibleText("MAHARASHTRA");
	    driver.findElement(By.id("zipCode")).sendKeys("411245");
	    new Select(driver.findElement(By.id("country"))).selectByVisibleText("INDIA");
	    driver.findElement(By.id("monthsInCurrentaddress")).sendKeys("11");
	    new Select(driver.findElement(By.id("stayType"))).selectByVisibleText("RENT");
	    driver.findElement(By.id("yrsInCurrentaddress")).sendKeys("6");
	    Thread.sleep(3000);
	    driver.findElement(By.id("addressdetailsbtn")).click();
	    driver.findElement(By.id("abaOrRoutingNumber")).sendKeys("123456789");
	    driver.findElement(By.id("accountNumber")).sendKeys("2314567890");
	    new Select(driver.findElement(By.id("accountType"))).selectByVisibleText("SAVING");
	    driver.findElement(By.id("bankName")).sendKeys("SBI");
	    driver.findElement(By.id("bankPhone")).sendKeys("7788945612");
	    driver.findElement(By.id("durationOfBankAccount")).sendKeys("24");
	    driver.findElement(By.id("monthlyIncome")).sendKeys("20000");
	    Thread.sleep(3000);
	    driver.findElement(By.id("bankdetailsbtn")).click();
	    String temp = getEmailString();
	    driver.findElement(By.id("emailId")).sendKeys(temp);
	    driver.findElement(By.id("confirmEmailId")).sendKeys(temp);
	    String temp2 = getPasswordString();
	    driver.findElement(By.id("password")).sendKeys(temp2);
	    driver.findElement(By.id("confirmPassword")).sendKeys(temp2);
	    driver.findElement(By.id("cellPhone2")).sendKeys("9876543210");
	    driver.findElement(By.id("cellPhone1")).sendKeys("9866543210");
	    driver.findElement(By.id("homePhone1")).sendKeys("9856543210");
	    driver.findElement(By.id("cellPhone3")).sendKeys("9146543210");
	    driver.findElement(By.id("homePhone3")).click();
	    driver.findElement(By.id("homePhone3")).sendKeys("0712114587");
	    driver.findElement(By.id("homePhone2")).sendKeys("0712458474");
	    new Select(driver.findElement(By.id("residentialStatus"))).selectByVisibleText("OWN");
	    driver.findElement(By.id("workPhone")).sendKeys("0712223355");
	    driver.findElement(By.id("dateOfMove")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("body > bs-datepicker-container > div > div > div > div > bs-days-calendar-view > bs-calendar-layout > div.bs-datepicker-body > table > tbody > tr:nth-child(1) > td:nth-child(4)")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("contactdetailsbtn")).click();
	    driver.findElement(By.id("companyName")).sendKeys("ABC Services");
	    new Select(driver.findElement(By.id("incomeType"))).selectByVisibleText("EMPLOYMENT");
	    driver.findElement(By.id("companyAddress")).sendKeys("Pune, maharashtra");
	    driver.findElement(By.id("employerName")).sendKeys("ABC Services");
	    driver.findElement(By.id("jobTitle")).sendKeys("Software Developer");
	    driver.findElement(By.id("currentEmployedDuration")).sendKeys("22");
	    driver.findElement(By.id("employerPhone")).sendKeys("9766522448");
	    Thread.sleep(3000);
	    driver.findElement(By.id("employmentdetailsbtn")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("loanAmount")).sendKeys("2000");
	    driver.findElement(By.id("loanPurpose")).sendKeys("Personal");
	    driver.findElement(By.id("deadlineDate")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("body > bs-datepicker-container > div > div > div > div > bs-days-calendar-view > bs-calendar-layout > div.bs-datepicker-body > table > tbody > tr:nth-child(1) > td:nth-child(4)")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("loandetailsbtn")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("paymentFrequency")).sendKeys("1");
	    driver.findElement(By.id("nexTPayDay")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("body > bs-datepicker-container > div > div > div > div > bs-days-calendar-view > bs-calendar-layout > div.bs-datepicker-body > table > tbody > tr:nth-child(1) > td:nth-child(4)")).click();
	    driver.findElement(By.id("sortCode")).sendKeys("2");
	    driver.findElement(By.id("monthlyIncome1")).sendKeys("20000");
	    driver.findElement(By.id("bankAccount")).sendKeys("SBT");
	    driver.findElement(By.id("monthlyExpenses")).sendKeys("15000");
	    new Select(driver.findElement(By.id("incomeSource"))).selectByVisibleText("JOB");
	    driver.findElement(By.id("secondPayDay")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("body > bs-datepicker-container > div > div > div > div > bs-days-calendar-view > bs-calendar-layout > div.bs-datepicker-body > table > tbody > tr:nth-child(1) > td:nth-child(4)")).click();
	    new Select(driver.findElement(By.id("paymentMethod"))).selectByVisibleText("CHEQUE");
	   driver.findElement(By.name("submit")).click();
	    System.out.println("Customer Application Submited");
	    Thread.sleep(10000);
  }

  public void refreshBrowser() throws InterruptedException{
	   driver.navigate().refresh();
	   Thread.sleep(2000);
  }
  
  public void newInvestorInAdmin() throws InterruptedException{
	  
	  driver.get(adminPortalUrl);
	  driver.findElement(By.xpath("//li[5]/a/p")).click();
	  Thread.sleep(4000);
	   driver.findElement(By.cssSelector("button.btn-simple")).click();
	   driver.findElement(By.id("companyName")).sendKeys("ABC Services");
	   driver.findElement(By.id("companyEmailId")).sendKeys("info@abc.com");
	   Thread.sleep(1000);
	   driver.findElement(By.id("cellPhone1")).sendKeys("9944888756");
	   driver.findElement(By.id("cellPhone2")).sendKeys("9964888756");
	   driver.findElement(By.id("companyWebsite")).sendKeys("abc.com");
	   Thread.sleep(1000);
	   driver.findElement(By.id("workPhone1")).sendKeys("8770123456");
	   driver.findElement(By.id("workPhone2")).sendKeys("0770123456");
	   driver.findElement(By.id("companyAddress")).sendKeys("Pune");
	   Thread.sleep(1000);
	   driver.findElement(By.id("companyCity")).sendKeys("Pune");
	   driver.findElement(By.id("companyState")).sendKeys("Maharashtra");
	   driver.findElement(By.id("companyCountry")).sendKeys("India");
	   Thread.sleep(1000);
	   driver.findElement(By.id("companyZipCode")).sendKeys("123456");
	   driver.findElement(By.id("abaOrRoutingNumber")).sendKeys("1");
	   driver.findElement(By.id("accountNumber")).sendKeys("1234567890");
	   Thread.sleep(1000);
	   driver.findElement(By.id("accountType")).sendKeys("1");
	   driver.findElement(By.id("bankName")).sendKeys("SBI");
	   driver.findElement(By.id("bankPhone")).sendKeys("0710123456");
	   Thread.sleep(1000);
	   driver.findElement(By.id("durationOfBankAccount")).sendKeys("12");
	   driver.findElement(By.id("rateOfInterest")).sendKeys("13");
	   new Select(driver.findElement(By.id("loanRange"))).selectByVisibleText("Up to 10000");
	   Thread.sleep(1000);
	   driver.findElement(By.id("totalLoanLent")).sendKeys("0");
	   driver.findElement(By.id("submitButton")).click();
	   System.out.println("new Investor created");
	   Thread.sleep(3000);
  }
  
  public void newTab(){
	  JavascriptExecutor je = (JavascriptExecutor) driver;
	  String a = "window.open('about:blank','_blank');";
	  je.executeScript(a);
  }
  
  public void changeToInvestorTab() throws InterruptedException {
		ArrayList<String> a = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(a.get(2));
		Thread.sleep(3000);
	}
  
  public void changeToAdminTab() throws InterruptedException {
		ArrayList<String> a = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(a.get(1));
		Thread.sleep(2000);
	}

	public void changeToCustTab() throws InterruptedException {
		ArrayList<String> a = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(a.get(0));
		Thread.sleep(3000);
	}
  
  public void assignApplication() throws InterruptedException, IOException{
	  applicationScreenAdmin();
	  for(int i=31;i<=36;i++){
		  try{
	  new Select(driver.findElement(By.xpath("//*[@id='"+i+"']"))).selectByVisibleText("42");
	  break;
		  }catch (Exception e) {
			  System.out.println("Searching for next dropdown");
		  }
		}
	  System.out.println("Dropdown selected");
	  Thread.sleep(5000);
	  screenshot("Application Assigned");
	  refreshBrowser();
	  System.out.println("Application has been Assigned");
	  Thread.sleep(3000);
  }
  
  public void applicationScreenAdmin() throws InterruptedException{
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//li[2]/a/p")).click();
	  Thread.sleep(5000);
  }
  
  public void approveApplication() throws InterruptedException, IOException{
	  for(int i=31;i<=36;i++){
		  try{
			  driver.findElement(By.id("accept_"+i+"")).click();
	  break;
		  }catch (Exception e) {
			  System.out.println("Searching for current id");
		  }
		}
	    screenshot("Application Approved");
	    System.out.println("Application has been approved");
	    Thread.sleep(5000);
  }
  
  public void applicationScreenInInvestor() throws InterruptedException{
	  driver.get(investorPortalUrl);
	    driver.findElement(By.cssSelector("input.form-control.border-input")).sendKeys("admin");
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("admin");
	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	    driver.findElement(By.linkText("Applications")).click();
	    Thread.sleep(7000);
  }
  
public void rejectApplication() throws InterruptedException, IOException{
	for(int i=31;i<=36;i++){
		  try{
			  driver.findElement(By.id("reject_"+i+"")).click();
			  System.out.println("Application Rejected");
	  break;
		  }catch (Exception e) {
			  System.out.println("Searching for current id");
		  }
		}
  }

public void applicationStatus() throws InterruptedException, IOException{
	 driver.get(adminPortalUrl);
	 driver.findElement(By.xpath("//li[2]/a/p")).click();
	 Thread.sleep(3000);
	 screenshot("Application Status");
}
  
public static void screenshot(String str) throws IOException{
    File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File dest=new File("screenshots/"+str+".png");
    FileUtils.copyFile(scr, dest);
  }

public void changeToCustomerTab() throws InterruptedException {
	ArrayList<String> a = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(a.get(0));
	Thread.sleep(3000);
}

public void deleteInvestor() throws InterruptedException{
	  driver.findElement(By.xpath("//tr[2]/td[9]/button[2]")).click(); 
	    refreshBrowser();
	    Thread.sleep(4000);
}

public void blockUnblockInvestor() throws InterruptedException{
	  driver.findElement(By.xpath("//li[5]/a/p")).click();
	    driver.findElement(By.xpath("//tr[2]/td[9]/button")).click();
	    refreshBrowser();
	    Thread.sleep(4000);
}

public void deleteCust() throws InterruptedException{
	  driver.findElement(By.xpath("//button[2]")).click();
	    refreshBrowser();
}

public void blockUnblockCust() throws InterruptedException{
	  driver.findElement(By.xpath("//li[4]/a/p")).click();
	  refreshBrowser();
}

public void newUserFillForm() throws InterruptedException{
	 driver.findElement(By.xpath("//li[3]/a/p")).click();
	 driver.findElement(By.id("newuserLink")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.id("firstNameInput")).sendKeys("abc");
	    Thread.sleep(2000);
	    driver.findElement(By.id("lastNameInput")).sendKeys("pqr");
	    Thread.sleep(2000);
	    driver.findElement(By.id("ageInput")).sendKeys("44");
	    Thread.sleep(2000);
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys("abc@mail.com");
	    Thread.sleep(2000);
	    driver.findElement(By.id("exampleInputPassword")).sendKeys("password");
	    Thread.sleep(2000);
	    driver.findElement(By.id("submitButton")).click();
	    Thread.sleep(2000);
}

public void deleteUser() throws InterruptedException{
	 driver.findElement(By.xpath("//li[4]/a/p")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//button")).click();
	 refreshBrowser();
}


  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
//       driver.quit();
       String verificationErrorString = verificationErrors.toString();
       if (!"".equals(verificationErrorString)) {
       fail(verificationErrorString);
    }
  }
}
