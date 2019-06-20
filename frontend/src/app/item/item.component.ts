import { Component, OnInit } from '@angular/core';
import {ItemDTO, items} from '../dto/ItemDTO';
import {ItemService} from '../service/item.service';
import {CustomerDTO} from '../dto/CustomerDTO';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  itemlist: ItemDTO[] = items;

  item: ItemDTO[] = [];
  itema: CustomerDTO  ;
  private manually: boolean;
  constructor(private itemService: ItemService) {
    this.item.push( new ItemDTO('Samba Hall', '120', '10'));
    this.item.push( new ItemDTO('Sudu Kakulu Hall', '115', '10'));
    this.item.push( new ItemDTO('Keeri Samba Hall', '112', '10'));
    this.item.push( new ItemDTO('Red Kakulu Hall', '115', '10'));
  }

  ngOnInit() {
    this.itemService.getAllItems().subscribe(item => {
      console.log(item);
    });
  }

  addItem(name, price, qty) {
    this.item.push(new ItemDTO(name, price, qty));
  }

  updateCustomer(): void {
    this.itemService.updateItem(this.item).subscribe(
      (result) => {

        alert('Updated Successfully...');
        this.manually = true;

        this.allItem();
        this.clear();
      }
    );
  }


  deleteItem(): void {



    this.itemService.deleteItem(this.itema.name).subscribe(
      (name, price, qty) => {

        alert('Customer Successfully Deleted...');
        this.addItem(name, price, qty);

        this.clear();
      }
    );
  }

  private allItem() {

  }

  private clear() {

  }
}
