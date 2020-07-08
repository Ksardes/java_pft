package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactsData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String address;
  private String mobile;
  private String email;
  /*
  private final String email2;
  private final String address2;
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

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
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

  public ContactsData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactsData withEmail(String email) {
    this.email = email;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactsData that = (ContactsData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return "ContactsData{" +
            "firstname='" + firstName + '\'' +
            ", lastname='" + lastName + '\'' +
            '}';
  }

}


