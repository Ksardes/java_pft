package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsHelper extends HelperBase {

  public ContactsHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactsCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactsForm(ContactsData contactsData, boolean creation) {
    type(By.name("firstname"),contactsData.getFirstname());
    type(By.name("lastname"),contactsData.getLastname());
    type(By.name("address"),contactsData.getAddress());
    type(By.name("mobile"),contactsData.getMobile());
    type(By.name("email"),contactsData.getEmail());
    type(By.name("email2"),contactsData.getEmail2());
    type(By.name("address2"),contactsData.getAddress2());
    type(By.name("nickname"),contactsData.getNickname());
    type(By.name("company"),contactsData.getCompany());
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactsData.getBday());
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactsData.getBmonth());
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(contactsData.getByear());

    if (creation) {
      new Select (wd.findElement(By.name("new_group"))).selectByVisibleText(contactsData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void selectContcat() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlertfromDelete() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("(//img[@alt='Edit'])[2]"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }
}
