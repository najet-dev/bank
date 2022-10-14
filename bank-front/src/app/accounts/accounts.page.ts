import { AccountService } from '../services/account.service';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  Validators,
  FormControl,
  FormArray,
  AbstractControl,
} from '@angular/forms';
import { IAccounts } from '../models/i-account';
import { ITransfer } from '../models/i-transfer';
import { HttpClient } from '@angular/common/http';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.page.html',
  styleUrls: ['./accounts.page.scss'],
})
export class AccountsPage implements OnInit {

  accountForm: FormGroup;
  employee: any[];

  account: IAccounts ={
    id: 0,
    type: "",
    balance: 0,
    createdAt: undefined
  };



  constructor( private accountService: AccountService, private httpClient: HttpClient,   public alertController: AlertController ) { }

  ngOnInit() {
    this.employee = [
      {id:1, Name:"Alex"},
      {id:2, Name:"Florent"},
      {id:3, Name:"Daniel"}


    ]

    this.accountForm  = new FormGroup({
      account: new FormArray([
        new FormControl(null, Validators.required),
      ]),
    });

  }

  }













