package ru.stqa.pft.addressbook.model;

public class ContactsData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String mobile;
  private final String email;
  private final String email2;
  private final String address2;
  private final String nickname;
  private final String company;
  private final String byear;
  private final String bday;
  private final String bmonth;

  public ContactsData(String firstname, String lastname, String address, String mobile, String email, String email2, String address2, String nickname, String company, String byear, String bday, String bmonth) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.email2 = email2;
    this.address2 = address2;
    this.nickname = nickname;
    this.company = company;
    this.byear = byear;
    this.bday = bday;
    this.bmonth = bmonth;
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

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getByear() {
    return byear;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }
}
