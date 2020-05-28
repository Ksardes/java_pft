package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testContactsCreation() throws Exception {
    app.getNavigationHelper().gotoAddNewPage();
    app.getContactsHelper().fillContactsForm(new ContactsData("Иван", "Иванович", "Репина 37\n204", "89992001299", "Test1@gmail.com", "Test2@gmail.com", "Ульяноск", "Artem", "Morishki", "1990", "10", "May"));
    app.getContactsHelper().submitContactsCreation();
    app.getContactsHelper().returnToHomePage();

  }

}
