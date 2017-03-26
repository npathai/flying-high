import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Airport } from '../models/airport';
import { AirportService } from '../service/airport.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [AirportService]
})
export class HomeComponent implements OnInit {
  selectedAirport: Airport;
  airports: Airport[];
  constructor(private airportService: AirportService) {
    this.airports = [];
  }

  ngOnInit() {
    this.selectedAirport = new Airport("Select Destination", '', '');

    this.airportService.getAllAirports().then(
      airports => {
        console.log('Received rest answer: ');
        console.log(airports);
        this.airports = airports
      }
    );

    // this.airports = [
    // ];
    // this.airports.push(new Airport('Los Angeles', 'LAX', 'USA'));
    // this.airports.push(new Airport('San Francisco', 'SFO', 'USA'));
    // this.airports.push(new Airport('Brisbane', 'BNE', 'Australia'));
    // this.airports.push(new Airport('Sydney', 'SYD', 'Australia'));
    // this.airports.push(new Airport('Melbourne', 'MEL', 'Australia'));
  }

  selectAirport(airport: Airport) {
    this.selectedAirport = airport;
  }

}
