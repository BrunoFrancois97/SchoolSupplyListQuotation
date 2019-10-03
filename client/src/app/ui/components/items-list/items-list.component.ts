import { Component, OnInit, Input } from '@angular/core';
import { Item } from '../../../model/item';

@Component({
  selector: 'items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.scss']
})
export class ItemsListComponent implements OnInit {

  @Input()
  public items: Array<Item>;

  constructor() { }

  ngOnInit() {
  }

}
