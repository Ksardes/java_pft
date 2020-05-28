package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsDeletionTests extends TestBase{

  @Test
  public void testContactsDeletion() {
    app.getContactsHelper().selectContcat();
    app.getContactsHelper().deleteSelectedContact();
    app.getContactsHelper().closeAlertfromDelete();

  }

}
