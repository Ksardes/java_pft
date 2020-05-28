package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase{

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void Login(String username, String password) {
    wd.get("http://localhost/addressbook/");
    type(By.name("user"),username);
    type(By.name("pass"),password);
    click(By.xpath("//input[@value='Login']"));
  }

}