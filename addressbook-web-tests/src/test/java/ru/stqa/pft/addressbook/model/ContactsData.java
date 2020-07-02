package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactsData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String mobile;
  private final String email;
  private final String email2;

  private final String address2;
  /*
  private final String nickname;
  private final String company;
  private final String byear;
  private final String bday;
  private final String bmonth;
   */


  public ContactsData( String firstname, String lastname, String address, String mobile, String email, String email2, String address2) {
    this.id = 0;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.email2 = email2;
    this.address2 = address2;
  }

  public ContactsData(int id, String firstname, String lastname, String address, String mobile, String email, String email2, String address2) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.email2 = email2;
    this.address2 = address2;
    /*
    this.nickname = nickname;
    this.company = company;
    this.byear = byear;
    this.bday = bday;
    this.bmonth = bmonth;
     */
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
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

  public String getEmail2() {
    return email2;
  }

  public String getAddress2() {
    return address2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactsData that = (ContactsData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }

  @Override
  public String toString() {
    return "ContactsData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}


