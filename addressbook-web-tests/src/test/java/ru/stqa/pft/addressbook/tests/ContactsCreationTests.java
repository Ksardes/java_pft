package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Comparator;
import java.util.List;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testContactsCreation() throws Exception {
    List<ContactsData> before = app.getContactsHelper().getContactList();
    app.getNavigationHelper().gotoAddNewPage();
    ContactsData contact = new ContactsData("Иван", "Иванович", "Репина 37\n204", "89992001299", "Test1@gmail.com",
            "Test2@gmail.com", "Ульяноск");
    app.getContactsHelper().createContact(contact);
    List<ContactsData> after = app.getContactsHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);

    before.add(contact);
    Comparator<? super ContactsData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
