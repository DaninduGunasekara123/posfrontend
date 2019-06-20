export class CustomerDTO {
  name: string;
  age: number;
  tp: number;
  salary: number;

  constructor(public name: string, public age: string, public tp: string, public salary: string) {
  }

}

export let customers: CustomerDTO[] = [
  new CustomerDTO('Danindu', '22', '0719747315', '500000'),
  new CustomerDTO('Tharindu', '21',    '0714598524', '400000'),
  new CustomerDTO('Pasindu', '20',  '0754123451', '300000'),
  new CustomerDTO('Harindu', '19',   '0769874125', '200000'),
];
