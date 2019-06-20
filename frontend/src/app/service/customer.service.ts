import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CustomerDTO} from '../dto/CustomerDTO';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http: HttpClient) {
  }

  getAllCustomers(): Observable<CustomerDTO> {
    return this.http.get<CustomerDTO>('http://localhost:8082/AngularFrontEndPos/customers');
  }

  updateCustomer(customer: CustomerDTO[]) {
  }

  deleteCusomer(cid: any) {

  }
}
