import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import {Account} from '../models/account';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class AccountService {

  constructor(private http: Http) { }

  getAccount(id: string): Promise<Account> {
    return this.http.get("http://localhost:8091/rest/api/accounts/" + id)
      .toPromise()
      .then(response => {
        return new Account(response.json().accountNumber, response.json().firstName,
                            response.json().lastName, response.json().homeAirportCode);
      })
      .catch(this.handleError);
  }

  handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
