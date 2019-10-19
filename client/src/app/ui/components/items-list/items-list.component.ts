import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../../../model/product';

@Component({
  selector: 'items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.scss']
})
export class ItemsListComponent implements OnInit {

  @Input()
  public items: Array<Product>;

  constructor() { }

  ngOnInit() {
  }

}
