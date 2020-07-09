package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name ="addressbook")
public class ContactsData {

  @Id
  @Column(name ="id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name ="firstName")
  private String firstName;
  @Expose
  @Column(name ="lastName")
  private String lastName;
  @Expose
  @Column(name ="address")
  @Type(type = "text")
  private String address;
  @Expose
  @Column(name ="home")
  @Type(type = "text")
  private String homePhone;

  @Expose
  @Column(name ="mobile")
  @Type(type = "text")
  private String mobilePhone;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;
  @Expose
  @Type(type = "text")
  private String email;
  @Expose
  @Type(type = "text")
  private String email2;
  @Expose
  @Type(type = "text")
  private String email3;
  @Transient
  private String allPhones;
  @Transient
  private String allEmails;

  @Transient
  private String photo;

  @Transient
  private String group;
  /*
  private final String nickname;
  private final String company;
  private final String byear;
  private final String bday;
  private final String bmonth;
   */

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getEmail() {
    return email;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public File getPhoto() {
    return new File(photo);
  }

  public String getGroup() {
    return group;
  }

  public ContactsData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactsData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactsData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactsData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactsData withMobilePhone(String mobile) {
    this.mobilePhone = mobile;
    return this;
  }

  public ContactsData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactsData withHomePhone(String home) {
    this.homePhone = home;
    return this;
  }

  public ContactsData withWorkPhone(String work) {
    this.workPhone = work;
    return this;
  }

  public ContactsData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactsData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactsData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactsData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactsData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactsData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactsData that = (ContactsData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(address, that.address) &&
            Objects.equals(homePhone, that.homePhone) &&
            Objects.equals(mobilePhone, that.mobilePhone) &&
            Objects.equals(workPhone, that.workPhone) &&
            Objects.equals(email, that.email) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, address, homePhone, mobilePhone, workPhone, email, email2, email3);
  }

  @Override
  public String toString() {
    return "ContactsData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            '}';
  }

}


