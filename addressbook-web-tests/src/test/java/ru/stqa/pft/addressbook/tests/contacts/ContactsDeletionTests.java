package ru.stqa.pft.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactsDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.goTo().addNewPage();
      app.contact().create(new ContactsData().withFirstName("Иван").withLastName("Иванов"));
    }
  }

  @Test
  public void testContactsDeletion() {
    Contacts before = app.contact().all();
    ContactsData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()-1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));

  }

 }
