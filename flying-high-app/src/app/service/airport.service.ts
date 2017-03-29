import { Injectable } from '@angular/core';
import { Http, Headers, URLSearchParams } from '@angular/http';
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

  getAirportByCode(code: string): Promise<Airport> {
    let params: URLSearchParams = new URLSearchParams();
    params.set('code', code);
    return this.http.get("http://localhost:8090/rest/api/airports/search/findByCode", {search: params})
        .toPromise()
        .then(response => {
          return new Airport(response.json().name, response.json().code, response.json().country)
        })
        .catch(this.handleError);
  }

  airportsWithFlightsFrom(departureCode: string): Promise<Airport[]> {
    let params: URLSearchParams = new URLSearchParams();
    params.set('departureCode', departureCode);

    return this.http.get("http://localhost:8090/rest/api/routes/from", {search: params})
      .toPromise()
      .then(response => {
        var airports = [];
        response.json().forEach(airport => {
          airports.push(new Airport(airport.name, airport.code, airport.country))
        });
        return airports;
      }).catch(this.handleError);
  }

  handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
