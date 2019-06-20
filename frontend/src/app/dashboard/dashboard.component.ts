import { Component, OnInit } from '@angular/core';
import {$} from 'protractor';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  // function() {
  //
  //   $('div#customer').hide();
  //   $('div#Item').hide();
  //   $('div#od').hide();
  //   $('div#emp').hide();
  //   $('div#dashboard').hide();
  //
  //   $('li#dash').click(() => {
  //     $('div#dashboard').show();
  //     $('div#Item').hide();
  //     $('div#customer').hide();
  //     $('div#od').hide();
  //     $('div#emp').hide();
  //   });
  //
  //   $('li#customers').click(() => {
  //     $('div#customer').show();
  //     $('div#dashboard').hide();
  //     $('div#Item').hide();
  //     $('div#od').hide();
  //     $('div#emp').hide();
  //   });
  //
  //   $('li#items').click(() => {
  //     $('div#Item').show();
  //     $('div#dashboard').hide();
  //     $('div#customer').hide();
  //     $('div#od').hide();
  //     $('div#emp').hide();
  //   });
  //
  //   $('li#orders').click(() => {
  //     $('div#od').show();
  //     $('div#dashboard').hide();
  //     $('div#Item').hide();
  //     $('div#customer').hide();
  //     $('div#empl').hide();
  //   });
  //
  //   $('li#employees').click(() => {
  //     $('div#emp').show();
  //     $('div#dashboard').hide();
  //     $('div#Item').hide();
  //     $('div#customer').hide();
  //     $('div#od').hide();
  //   });
  //
  //   $('a#c').click(() => {
  //     $('div#employeeDiv').hide();
  //     $('div#indexDiv').hide();
  //     $('div#itemDiv').hide();
  //     $('div#customerDiv').show();
  //     $('div#orderDiv').hide();
  //   });
  //
  // }
}
