import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import {Airport} from '../models/airport';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class AirportService {

  constructor(private http: Http) { }

  getAllAirports(): Promise<Airport[]> {
    return this.http.get("http://localhost:8090/rest/api/airports")
      .toPromise()
      .then(response => response.json() as Airport[])
      .catch(this.handleError);
  }

  handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
