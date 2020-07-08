package ru.stqa.pft.addressbook.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.goTo().addNewPage();
      app.contact().create(new ContactsData().withFirstName("Иван").withLastName("Иванов").withAddress("г. Ульяновск \\n Ул. Тестовая \\n д. 99 кв. 999")
              .withHomePhone("8 (939)").withMobilePhone("33-33-33").withWorkPhone("22 22")
              .withEmail("Test1@gmail.com").withEmail2("Test2@gmail.com").withEmail3("Test3@gmail.com"));
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().HomePage();
    ContactsData contact =app.contact().all().iterator().next();
    ContactsData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

  }

  private String mergePhones(ContactsData contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(this::cleaned)
            .collect(Collectors.joining("\n"));
    // "%3B   
  }


  public String cleaned(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
