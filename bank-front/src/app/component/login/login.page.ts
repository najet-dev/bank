import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  loginForm = {
    email:'',
    password:''
  };
  constructor() { }

  ngOnInit() {
  }

  login(){
    console.log('login clicked')
  }
}
