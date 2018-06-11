package com.weborder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {
	public static int randNumber(int a, int b) {
		Random rd = new Random();
		return rd.nextInt(b + 1 - a) + a;
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/adiletkolanov/Documents/selenium dependencies/drivers/chromedriver");
		
		WebDriver dr = new ChromeDriver();
		dr.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		WebElement user = dr.findElement(By.name("ctl00$MainContent$username"));
		WebElement pswrd = dr.findElement(By.name("ctl00$MainContent$password"));
		
		user.sendKeys("Tester");
		Thread.sleep(1000);
		
		pswrd.sendKeys("test");
		Thread.sleep(1000);
		
		dr.findElement(By.name("ctl00$MainContent$login_button")).click();
		Thread.sleep(1000);
		
		dr.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
		Thread.sleep(1000);
		
		dr.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct")).sendKeys("FamilyAlbum");
		Thread.sleep(1500);
		
	
		dr.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(randNumber(1,100)+"");
		Thread.sleep(1500);
		List<String> lst = new ArrayList<>();
		
		String fn = "John";
		String ln = "Smith";
		
		FileReader fr = new FileReader("names.txt");
		BufferedReader br = new BufferedReader(fr);
		String str = "";
		while((str = br.readLine())!=null) {
			lst.add(str);
		}
		int rr = randNumber(1,9);
		String mid = lst.get(rr);
		dr.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(fn+" "+mid+" "+ln);
		Thread.sleep(1500);
		dr.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		Thread.sleep(1500);
		dr.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
		Thread.sleep(1500);
		dr.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		Thread.sleep(1500);
		dr.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("22314");
		Thread.sleep(1500);
		
		int rand1 = randNumber(1,3);
		
		switch(rand1) {
		case 1: dr.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
				Thread.sleep(1500);
				dr.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("4400888634662585");
				dr.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("12/22");
				break;
		case 2: dr.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();		
				Thread.sleep(1500);
				dr.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("5500884334663671");
				dr.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("01/21");

				break;
		case 3: dr.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
				Thread.sleep(1500);	
				dr.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("330088433466219");
				dr.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("08/19");

				break;
		default: System.out.println("wrong card");		
		Thread.sleep(1500);
		

		}
		dr.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		Thread.sleep(1500);
		String text = dr.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText();
		if(text.equals("New order has been successfully added.")) {
			System.out.println("success");
		}else {
			System.out.println("failed");
		}
		
	}

}
