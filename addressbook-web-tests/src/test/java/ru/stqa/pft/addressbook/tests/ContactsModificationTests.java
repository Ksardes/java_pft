package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactsModificationTests extends TestBase {

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
    ContactsData modifiedContact = before.iterator().next();
    ContactsData contact = new ContactsData()
            .withId(modifiedContact.getId()).withFirstName("Иван").withLastName("Иванов").withAddress("ул.Тестовая").withMobile("899999999").withEmail("Test@gmail.com");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(),before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
