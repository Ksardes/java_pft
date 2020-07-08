package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.ArrayList;
import java.util.List;

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

  public void fillContactsForm(ContactsData contactsData) {
    type(By.name("firstname"),contactsData.getFirstName());
    type(By.name("lastname"),contactsData.getLastName());
    type(By.name("address"),contactsData.getAddress());
    type(By.name("mobile"),contactsData.getMobile());
    type(By.name("email"),contactsData.getEmail());
    /*
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
     */
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlertFromDelete() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int index) {
    List<WebElement> elements = wd.findElements(By.xpath("(//img[@alt='Edit'])"));
    elements.get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactsData contact) {
    fillContactsForm(contact);
    submitContactsCreation();
    returnToHomePage();
  }

  public void modify(int index, ContactsData contact) {
    initContactModification(index);
    fillContactsForm(contact);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
    closeAlertFromDelete();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactsData> list() {
    List<ContactsData> contacts = new ArrayList<ContactsData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
        String firstName = cells.get(2).getText();
        String lastName = cells.get(1).getText();
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
        contacts.add(new ContactsData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }
}
