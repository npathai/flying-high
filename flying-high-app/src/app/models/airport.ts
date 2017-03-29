export class Airport {
  name;
  code;
  country;

  constructor(name: string, code: string, country: string) {
    this.name = name;
    this.code = code;
    this.country = country;
  }

  getCode() : string {
    return this.code;
  }

  getName() : string {
    return this.name;
  }
}
