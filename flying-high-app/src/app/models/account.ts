export class Account {
  accountNumber;
  firstName;
  lastName;
  homeAirportCode;

  getHomeCode() {
    return this.homeAirportCode;
  }

  getFirstName() {
    return this.firstName;
  }

  constructor(accountNumber: string, firstName: string, lastName: string, homeAirportCode: string) {
    this.accountNumber = accountNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.homeAirportCode = homeAirportCode;
  }

}
