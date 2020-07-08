package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

public class ContactsDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().list().size() == 0) {
      app.goTo().addNewPage();
      app.contact().create(new ContactsData().withFirstName("Иван").withLastName("Иванов"));
    }
  }

  @Test
  public void testContactsDeletion() {
    List<ContactsData> before = app.contact().list();
    int index = before.size()-1;
    app.contact().delete(index);
    app.goTo().gotoHomePage();
    List<ContactsData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size()-1);

   before.remove(index);
   Assert.assertEquals(before,after);

  }

 }
