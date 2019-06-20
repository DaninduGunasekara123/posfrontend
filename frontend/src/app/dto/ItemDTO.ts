export class ItemDTO {
  name: string;
  price: number;
  qty: number;

  constructor( public name: string, public price: string, public qty: string) {
  }
}

export let items: ItemDTO[] = [
  new ItemDTO('Samba Hall', '120', '10'),
  new ItemDTO('Sudu Kakulu Hall', '115', '10'),
  new ItemDTO('Keeri Samba Hall', '112', '10'),
  new ItemDTO('Red Kakulu Hall', '115', '10'),
];
