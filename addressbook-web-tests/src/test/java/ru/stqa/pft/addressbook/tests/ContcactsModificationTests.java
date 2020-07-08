package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Comparator;
import java.util.List;

public class ContcactsModificationTests extends TestBase {

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
    ContactsData contact = new ContactsData()
            .withId(before.get(index).getId()).withFirstName("Иван").withLastName("Иванов").withAddress("ул.Тестовая").withMobile("899999999").withEmail("Test@gmail.com");
    app.contact().modify(index, contact);
    List<ContactsData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactsData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
