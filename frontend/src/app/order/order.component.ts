import { Component, OnInit } from '@angular/core';
import {$} from 'protractor';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

//   $('#itsl').dblclick(function() {
//     $('#itsl option').remove();
//     let allItemO = getAllItem();
//     for (let i = 0; i < allItemO.length; i++) {
//       $('#itsl').append('<option>' + allItemO[i].getItemName() + '</option>');
//     }
//
//   })
//
// // Custoemer Combo
//
//   $('#sele').dblclick(function() {
//     $('#sele option').remove();
//     let cusD = getAllCustomers();
//     for (let i = 0; i < cusD.length; i++) {
//       $('#sele').append('<option>' + cusD[i].getCustomerName() + '</option>');
//     }
//
//   })
//
//
// // Filling After Chozen in Item
//   $('#itsl').change(function() {
//     alert('Item Clicked');
//
//     let items = $('#itsl').find(':selected').text();
//
//     let itemOb = searchItem(items);
//     // alert(itemOb)
//
//     $('#pru').val(itemOb.getItemPrice());
//     $('#qun').val(itemOb.getItemQun());
//     // alert('After find Values in Item')
//
//     // $('#pru').val("250");
//     // $('#qun').val("25");
//   })
//
// // Filling After Chozen in Customer
//
//   $('#sele').change(function() {
//     alert('Customer Clicked');
//     let conceptName = $('#sele').find(':selected').text();
//     // var customerSo = serachCustomer(conceptName);
//
//     // $('#addr').val("Galle");
//     // $('#tel').val(customerSo.getCustomerTp());
//     // $('#cref').val(customerSo.getCustomerSalary());
//
//     $('#addr').val('Aluthgama');
//     $('#tel').val('119');
//     $('#cref').val('15000');
//
//   })
//
// // Adding Order to Panel
// function addOrd() {
//     alert('addd order Clicked');
//
//     let orderID = $('#oids').val();
//     let itemName = $('#itsl').val().trim();
//     let itemPrice = parseInt($('#pru').val());
//     let itemQuntity = parseInt($('#oqun').val());
//     let available = parseInt($('#qun').val());
//     let total = itemPrice * itemQuntity;
//

//     let orderrow = '<tr>' +
//       '<td>' + itemName + '</td>' +
//       '<td>' + itemPrice + '</td>' +
//       '<td>' + itemQuntity + '</td>' +
//       '<td>' + total + '</td>' +
//       '</tr>';
//
//     $('#tab5').append(orderrow);
//
//     // alert('After Append')
//     genarateTotal();
//     alert('After generatetotal metohd');
//
//   }
//
//
// function genarateTotal() {
//     let realtot = 0;
//     $('#tab5 tbody tr td:last-child').each(function() {
//       realtot = realtot + parseInt($(this).text());
//       displayTotal(realtot);
//     });
//   }
//
// function displayTotal(a) {
//     $('#totalP').text(a);
//   }
//
// $('#mainB').click(function() {
//     let totalvalue = $('#tab5 tbody tr td:last-child');
//     alert('Submit Order Clicked');
//     // var customercredit=
//     //     inputC
//
//   });
//
//
// function SUBMIT() {
//     let totalvalue = $('#tab5 tbody tr td:last-child');
//     alert('Submit Order Clicked');
//     // var customercredit=
//     //     inputC
//
//   }
//
// function  fulltc() {
//     $('#addr').val('');
//     $('#tel').val('');
//     $('#cref').val('');
//     $('#pru').val('');
//     $('#qun').val('');
//     $('#oqun').val('');
//     $('#oids').val('');
//     $('#totalP').text('0.00');
//     $('#inputC').val('');
//     // $('#balanceD').val('');
//     // $('#disc').val('');
//     // $('#tab4').find('tr:gt(0)').remove();
//     // idgen();
//
//   }
}
