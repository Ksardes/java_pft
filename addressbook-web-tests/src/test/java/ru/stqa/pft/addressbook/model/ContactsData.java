package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactsData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String address;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String email;
  private String email2;
  private String email3;
  private String allPhones;
  private String allEmails;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactsData that = (ContactsData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    return "ContactsData{" +
            "firstname='" + firstName + '\'' +
            ", lastname='" + lastName + '\'' +
            '}';
  }

}


