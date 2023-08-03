package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basecla {
	public static WebDriver driver;
	static Actions a;
	static Robot y;
	private static String Name;
	public static void chromebrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
	public static void passurl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
    }
	 
		public static void time(int a) {
			driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
		}
	public static void title() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	public static void currenturl() {
		String u = driver.getCurrentUrl();
		System.out.println(u);
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static void switchToUrl() {
		String windowHandle = driver.getWindowHandle();
	}
	public static void swithToNewUrl() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String allPage : windowHandles) {
			driver.switchTo().window(allPage);

		}
	}
	public static void closing() {
		driver.close();
	}
	public static void box(WebElement user,String txt) {
		user.sendKeys(txt);
	}
	public static void button(WebElement cl) {
		cl.click();
	}
	public static void jsTrue(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);	
	} 
	public static void jsFalse(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", e);

	}
	public static void jsSendkeys(String s,WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+s+"')", e);
	}
	public static void drog(WebElement scr,WebElement tg) {
		Actions a=new Actions(driver);
		a.dragAndDrop(scr, tg);
	}
	public static void doub(WebElement tg) {

		a.doubleClick().perform();
	}
	public static void key() throws AWTException {

		Robot y=new Robot();
		y.keyPress(KeyEvent.VK_DOWN);
		y.keyRelease(KeyEvent.VK_DOWN);
		}
	public  static void name() {
		
		y.keyPress(KeyEvent.VK_DOWN);
		y.keyRelease(KeyEvent.VK_DOWN);
	}
	public static void roEnter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void roCtrlA() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public static void roBackSpace() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
	}
	public static void roPageDown() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);

	}
	public static void roPageUp() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
	}
	public static void roTap() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	public static Alert alertOk() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}
	public static Alert alertDis() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert;
	}
	public static void moveToEle(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	}
	public static void clickTar(WebElement e) {
		Actions a=new Actions(driver);
		a.click(e).perform();
	}
	 
	public static void selectByIndex(WebElement e,int a) {
		Select s=new Select(e);
		s.selectByIndex(a);
	}
	public static void sendKeys(WebElement e,String value){
		e.sendKeys(value);
	}
	public static void click(WebElement e){
		e.click();
	}
	public static void deselectIndex(WebElement e,int a) {
		Select s=new Select(e);
		s.selectByIndex(a);	
	}
    public static String readExcel(String Sheet,int row,int cell) throws IOException {
      
    	
    	File  k=new File("C:\\Users\\durga\\eclipse-workspace\\Maven\\Excel\\Durga.xlsx");
		
		//2
		FileInputStream j2=new FileInputStream(k);
		
		//3
		
		Workbook w=new XSSFWorkbook(j2);
		
		//4
		Sheet y = w.getSheet(Sheet);
		
		Row e = y.getRow(row);
		Cell h = e.getCell(cell);
		
		int si = h.getCellType();
		String Name;
		
		if (si==1) {
			Name = h.getStringCellValue();
			
		}
		else if (DateUtil.isCellDateFormatted(h)) {
			Date hii = h.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat();
			Name = sim.format(hii);
			
		}
		else {
			double d=h.getNumericCellValue();
			long he=(long)d;
			Name = String.valueOf(1);
		}
		return Name;
			
		
    }
   
	
	public static String text(WebElement e) {
		String text = e.getText();
		return text;
	}
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;	
	}
	public static String getText(WebElement e) {
		String attribute = e.getAttribute("innerText");
		return attribute;
	}	
	public static void jsClick(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", e);
	}
	public static void clearE(WebElement e) {
		e.clear();
	}
	public static void doubleClick(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e);
	}
	public static void quit() {
		driver.quit();
	}
}
		
		
				
				
				
			
			
		
	
    

