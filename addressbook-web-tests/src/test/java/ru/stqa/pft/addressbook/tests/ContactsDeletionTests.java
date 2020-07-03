package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

public class ContactsDeletionTests extends TestBase{

  @Test
  public void testContactsDeletion() {
    if (! app.getContactsHelper().isThereAContact()) {
      app.goTo().gotoAddNewPage();
      app.getContactsHelper().createContact(new ContactsData("Иван", "Иванович", "Репина 37\n204", "89992001299", "Test1@gmail.com",
              "Test2@gmail.com", "Ульяноск"));
    }
    List<ContactsData> before = app.getContactsHelper().getContactList();
    app.getContactsHelper().selectContact(before.size()-1);
    app.getContactsHelper().deleteSelectedContact();
    app.getContactsHelper().closeAlertFromDelete();
    app.goTo().gotoHomePage();
    List<ContactsData> after = app.getContactsHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);

   before.remove(before.size()-1);
   Assert.assertEquals(before,after);

  }
}
