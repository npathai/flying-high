import { Component, OnInit } from '@angular/core';
import { Account } from '../models/account';
import { AccountService } from '../service/account.service';
import { Airport } from '../models/airport';
import { AirportService } from '../service/airport.service';

@Component({
  selector: 'app-myaccount',
  templateUrl: './myaccount.component.html',
  styleUrls: ['./myaccount.component.css'],
  providers: [ AccountService, AirportService ]
})
export class MyaccountComponent implements OnInit {
  account: Account;
  homeAirport: Airport;
  possibleDestinations: Airport[];
  selectedAirport: Airport;

  constructor(private accountService: AccountService, private airportService: AirportService) { }

  ngOnInit() {
    this.selectedAirport = new Airport("Select Destination", '', '');
    var account: Account;
    var homeAirport: Airport;
    // consider Sarah to be the current user till be have authentication in place
    this.accountService.getAccount("123456")
    .then(res => {
      account = res;
      return this.airportService.getAirportByCode(account.getHomeCode())
    })
    .then(res => {
      homeAirport = res;
      return this.airportService.airportsWithFlightsFrom(homeAirport.getCode())
    })
    .then(res => {
      this.account = account;
      this.homeAirport = homeAirport;
      this.possibleDestinations = res;
    });
  }

  selectAirport(selectedAirport: Airport) {
    this.selectedAirport = selectedAirport;
  }
}
