package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;

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
    type(By.name("home"),contactsData.getHomePhone());
    type(By.name("mobile"),contactsData.getMobilePhone());
    type(By.name("work"),contactsData.getWorkPhone());
    type(By.name("email"),contactsData.getEmail());
    type(By.name("email2"),contactsData.getEmail2());
    type(By.name("email3"),contactsData.getEmail3());

    /*
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

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value ='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAlertFromDelete() {
    wd.switchTo().alert().accept();
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
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
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactsData contact) {
    initContactModificationById(contact.getId());
    fillContactsForm(contact);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactsData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
    closeAlertFromDelete();
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstName = cells.get(2).getText();
      String lastName = cells.get(1).getText();
      String allphones = cells.get(5).getText();
      contactCache.add(new ContactsData().withId(id).withFirstName(firstName).withLastName(lastName)
      .withAllPhones(allphones));
    }
    return new Contacts(contactCache);
  }

  public ContactsData infoFromEditForm(ContactsData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactsData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }
}
