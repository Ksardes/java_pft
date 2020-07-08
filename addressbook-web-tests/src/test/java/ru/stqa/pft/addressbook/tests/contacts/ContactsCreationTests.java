package ru.stqa.pft.addressbook.tests.contacts;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testContactsCreation() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().addNewPage();
    ContactsData contact = new ContactsData().withFirstName("Иван").withLastName("Иванов");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
