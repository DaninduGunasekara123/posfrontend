import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ItemDTO} from '../dto/ItemDTO';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(public http: HttpClient) {
  }

  getAllItems(): Observable<ItemDTO> {
    return this.http.get<ItemDTO>('http://localhost:8082/AngularFrontEndPos/items');
  }

  updateItem(item: ItemDTO[]) {
  }

  deleteItem(name: any) {
  }
}
