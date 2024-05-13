import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styles: [
  ]
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  title = 'Mean Stack Agency';
  nums=[10,20]
  sum=()=>{
    return this.nums[0]+this.nums[1];
  }
  red="color:red";
  green="color:green";

  pinkb=" background-color:pink";
  purpleb="background-color:purple";

  message=""
  clickMe=(val)=>{
    console.log(val)
    this.message=val;
  }

  show=true
  toggle=()=>{
    this.show=!this.show
  }
  list=["Red","Blue","Yellow","Orange","Pink","Green"]
}
