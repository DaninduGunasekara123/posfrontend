import { Component, OnInit } from '@angular/core';
import {CustomerDTO, customers} from '../dto/CustomerDTO';
import {CustomerService} from '../service/customer.service';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  private manually: boolean;
  constructor(private customerService: CustomerService) {
    this.customerlist.push(new CustomerDTO('Danindu', '22', '0719747315', '500000'));
    this.customerlist.push(new CustomerDTO('Tharindu', '21', '0714598524', '400000'));
    this.customerlist.push(new CustomerDTO('Pasindu', '20', '0754123451', '300000'));
    this.customerlist.push(new CustomerDTO('Harindu', '19', '0769874125', '200000'));
  }

  customerlist: CustomerDTO[] = customers;
  selectedCustomer: CustomerDTO = new CustomerDTO('', '', '', '');

  customer: CustomerDTO[] = [];
  customera: CustomerDTO  ;

  // iii = 0;
  //
  // var = this.i;
  // i;

  ngOnInit() {
    this.customerService.getAllCustomers().subscribe(cust => {
      console.log(cust);
    });
  }

  addCustomer(name, age, tp, salary) {
    this.customerlist.push(new CustomerDTO(name, age, tp, salary));
  }

  updateCustomer(): void {
    this.customerService.updateCustomer(this.customer).subscribe(
      (result) => {

        alert('Updated Successfully...');
        this.manually = true;

        this.allCustomer();
        this.clear();
      }
    );
  }


  deleteCustomer(): void {



    this.customerService.deleteCusomer(this.customera.name).subscribe(
      (result) => {

        alert('Customer Successfully Deleted...');
        this.allCustomer();

        this.clear();
      }
    );
  }


// addCustomer(customerName, customerAge, customerTp, customerSalary) {
//     const customerObjrct = new Customer(customerName, customerAge, customerTp, customerSalary);
//     this.customer.push(customerObjrct);
//
//   }
// serachCustomer(customerName) {
//     for (this.iii = 0; this.iii < this.customer.length; this.iii++) {
//       if (this.customer[i].getCustomerName() === customerName) {
//         const cusname = customer[i].getCustomerName();
//         const cusage = customer[i].getCustomerAge();
//         const custp = customer[i].getCustomerTp();
//         const cussal = customer[i].getCustomerSalary();
//         const cusTemp = new Customer(cusname, cusage, custp, cussal);
//         return cusTemp;
//       }
//     }
//
//     this.iii = 0;
//   }
// deleteCustomer(customerName) {
//     for (this.iii = 0; this.iii < this.customer.length; this.iii++) {
//       if (customer[i].getCustomerName() === customerName) {
//         this.customer.splice(i, 1);
//         return true;
//       }
//     }
//     this.iii = 0;
//   }
// updateCustomer(deleteN, customerName, customerAge, customerTp, customerSalary) {
//     for (this.iii = 0; this.iii < customer.length; this.iii++) {
//       if (customer[i].getCustomerName() === deleteN) {
//         this.customer.splice(i, 1);
//         addCustomer(customerName, customerAge, customerTp, customerSalary);
//
//       }
//     }
//     this.iii = 0;
//   }
// getAllCustomers() {
//     return customer;
//   }
// cusSearching() {
//     cusSection();
//
//     alert($('#cse').val().trim());
//     if (serachCustomer($('#searchtxt').val().trim())) {
//
//       const ajaxConfig = {
//         url: 'http://loca;host:8082/POS1/customers',
//         method: 'GET',
//         async: true,
//         data: {
//           cusName: $('#cname').val()
//         }
//       };
//
//       const temV = serachCustomer($('#searchtxt').val().trim());
//       const cusname = temV.getCustomerName();
//       const cusage = temV.getCustomerAge();
//       const custp = temV.getCustomerTp();
//       const cussal = temV.getCustomerSalary();
//       // showwing in a panel
//       $.ajax(ajaxConfig).done(response => {
//         const customer = JSON.parse(response);
//         if (!$.isEmptyObject(customer)) {
//           $('#cname1').text(cusname);
//           $('#cage1').text(cusage);
//           $('#cutp1').text(custp);
//           $('#csalary1').text(cussal);
//           $('#cusSearR').fadeIn(1000);
//           fadeA();
//         } else {
//           $('#cname1').text('');
//           $('#cage1').text('');
//           $('#cutp1').text('');
//           $('#csalary1').text('');
//           $('#cusSearR').fadeIn(1000);
//         }
//       });
//     } else {
//       alert('No Customer Registerd For That Name..!');
//       fadeO();
//       $('#searchtxt').val('');
//     }
//
//   }
// cusSection() {
//     fadeO();
//     $('#cusSearR').fadeOut(1000);
//   }

// $('#crd'; ).click(function() {
//     deleteCustomer($('#searchtxt').val().trim());
//     viewAllCus();
//     cusSection();
//   })

  // viewAllCus() {
  //   const temp = getAllCustomers();
  //   $('#tbo').empty();
  //   for (this.iii = 0;
  //   i < temp.length;)  { }
  //   this.iii = 0;
  //   }


  // const cusname = temp[i].getCustomerName();
  // const cusage = temp[i].getCustomerAge();
  // const custp = temp[i].getCustomerTp();
  // const cussal = temp[i].getCustomerSalary();
  // $('#tab1').append('<tr><td>' + cusname + '</td><td>' + cusage + '</td><td>' + custp + '</td><td>' + cussal + '</td></tr>');


// $('window'; ).ready(function() {
//     for (let i = 0; i < 3; i++) {
//       $('#tabl').append('<tr><td>Sanu Vithanage</td><td>20</td><td>0770516653</td><td>70 000</td></tr>');
//       $('#tab2').append('<tr><td>Lux Soap</td><td>50</td><td>200</td></tr>');
//     }
//   })
  // Customer validations
// $('#delcus'; ).click(function() {
//     if (boolcus == true) {
//       $('#cusDelete').modal('toggle');
//       $('#cusDelete').modal('show');
//     } else {
//       $('#searchtxt').focus();
//       alert('Select a Customer Before Delete..!');
//     }
// // $('#cusDel').modal('hide');// how to hide a model
//   })$('#editcus'; ).click(function() {
//     if (boolcus === true) {
//       loadUpdateCustomerDetails();
//
//       $('#cusEdit').modal('toggle');
//       $('#cusEdit').modal('show');
//     } else {
//       $('#searchtxt').focus();
//       alert('Select a Customer Before Delete..!');
//     }
//   })

// loadUpdateCustomerDetails(); {
//     $('#cname').text($('#cname1').text());
//     $('#cage').text($('#cage1').text());
//     $('#cutp').text($('#cutp1').text());
//     $('#csalary').text($('#csalary1').text());
// }
//
// $('#cusUpdate'; ).click(function() {
//     function updateCustomer(text: any, s: string, s2: string, s3: string, s4: string) {
//     }
//
//     if ($('#custName').val() === '') {
//       $('#custName').focus();
//     } else if ($('#custAge').val() === '') {
//       $('#custAge').focus();
//     } else if ($('#custTp').val() === '') {
//       $('#custTp').focus();
//     } else if ($('#custSalary').val() === '') {
//       $('#custSalary').focus();
//     } else {
//       this.viewAllCus();
//       $('#custName').val('');
//       $('#custAge').val('');
//       $('#custTp').val('');
//       $('#custSalary').val('');
//       cusSection();
//       $('#cusEdit').modal('hide');
//     }
//   })

// customerAdd(); {
//     // alert("s");
//     const cusName = $('#cusNameTxt').val();
//     const cusAge = $('#cusAgeTxt').val();
//     const cusTp = $('#cusTptxt').val();
//     const cusSalary = $('#cusSalTxt').val();
//
//     const ajaxConfig = {
//       url: 'http://loca;host:8082/POS1/customers',
//       method: 'GET',
//       async: true,
//       data: {
//         cusName: $('#cusNameTxt').val(),
//         cusAge: $('#cusAgeTxt').val(),
//         cusTp: $('#custTp').val(),
//         cusSalary: $('#cusSalTxt').val()
//       }
//     };
//
//     if (cusName === '') {
//       $('#cusNameTxt').focus();
//     } else if (cusAge === '') {
//       $('#cusAgeTxt').focus();
//     } else if (cusTp === '') {
//       $('#cusTptxt').focus();
//     } else if (cusSalary === '') {
//       $('#cusSalTxt').focus();
//     } else {
//       addCustomer(cusName, cusAge, cusTp, cusSalary);
//       viewAllCus();
//       $('.modal').modal('hide');
//       clearTextFiles();
//     }
//
//     $.ajax(ajaxConfig).done(response => {
//       const customer = JSON.parse(response);
//       if (!$.isEmptyObject(customer)) {
//         $('#cname1').text(cusname);
//         $('#cage1').text(cusage);
//         $('#cutp1').text(custp);
//         $('#csalary1').text(cussal);
//         $('#cusSearR').fadeIn(1000);
//         fadeA();
//       } else {
//         $('#cname1').text('');
//         $('#cage1').text('');
//         $('#cutp1').text('');
//         $('#csalary1').text('');
//         $('#cusSearR').fadeIn(1000);
//       }
//     });

// clearTextFiles(); {
//     $('#cusNameTxt').val('');
//     $('#cusAgeTxt').val('');
//     $('#cusTptxt').val('');
//     $('#cusSalTxt').val('');
//   }
  private allCustomer() {
  }

  private clear() {

  }
}
