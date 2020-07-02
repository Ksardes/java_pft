package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Comparator;
import java.util.List;

public class ContcactsModificationTests extends TestBase {

  @Test
  public void testContactsDeletion() {
    if (! app.getContactsHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactsHelper().createContact(new ContactsData("Иван", "Иванович", "Репина 37\n204", "89992001299", "Test1@gmail.com",
              "Test2@gmail.com", "Ульяноск"));
    }
    List<ContactsData> before = app.getContactsHelper().getContactList();
    app.getContactsHelper().selectContact(before.size()-1);
    app.getContactsHelper().initContactModification();
    ContactsData contact = new ContactsData(before.get(before.size() -1).getId(),"Иван", "Иванович", "Репина 37\n204", "89992001299", "Test1@gmail.com",
            "Test2@gmail.com", "Ульяноск");
    app.getContactsHelper().fillContactsForm(contact);
    app.getContactsHelper().submitContactModification();
    app.getContactsHelper().returnToHomePage();
    List<ContactsData> after = app.getContactsHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactsData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
