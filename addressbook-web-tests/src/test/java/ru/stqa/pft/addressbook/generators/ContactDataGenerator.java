package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter ( names = "-f", description = "Target file")
  public String file;

  @Parameter ( names = "-d", description = "Data format")
  public String format;

  public static void main (String[] args) throws IOException {
    ContactDataGenerator generator= new ContactDataGenerator ();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactsData> contacts = generateContacts(count);
    switch (format) {
      case "csv":
        saveAsCsv(contacts, new File(file));
        break;
      case "xml":
        saveAsXml(contacts, new File(file));
        break;
      case "json":
        saveAsJson(contacts, new File(file));
        break;
      default:
        System.out.println("Unrecognized format " + format);
        break;
    }
  }

  private void saveAsJson(List<ContactsData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXml(List<ContactsData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactsData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<ContactsData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactsData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s\n",contact.getFirstName(),contact.getLastName(),contact.getAddress()
                                             ,contact.getMobilePhone(),contact.getEmail()));
    }
    writer.close();
  }

  private List<ContactsData> generateContacts(int count) {
    List<ContactsData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactsData().withFirstName(String.format("ftest%s", i)).withLastName(String.format("ltest%s", i))
                                     .withAddress(String.format("Ул. Репина д.%s", i)).withMobilePhone(String.format("33-3%s", i))
                                     .withEmail(String.format("test%s@gmail.com", i)));
    }
    return contacts;
  }
}

