import { IAccountByIdUser } from './../models/i-accountUser';

import { UserService } from './../services/user.service';
import { AccountService } from '../services/account.service';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  Validators,
  FormControl,
  FormArray,
  AbstractControl,
  FormBuilder,
} from '@angular/forms';
import { AccountDetails } from '../models/i-account';
import { IOperation, ITransfer } from '../models/i-transfer';
import { HttpClient } from '@angular/common/http';
import { AlertController } from '@ionic/angular';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.page.html',
  styleUrls: ['./accounts.page.scss'],
})
export class AccountsPage implements OnInit {
  accountFormGroup: FormGroup;
  userid: number = 1;
  //userAccounts: IAccountByIdUser;
  userAccounts: any;


  currentPage: number = 0;
  pageNumber : number = 0;
  pageSize : number = 5;
  accountObservable!: Observable<AccountDetails> ;
  totalPages : number;
  page: number = 0;

  accountByIdUser: IAccountByIdUser ={
    id: 0,
    userName: '',
    name: '',
    type: '',
    balance: 0
  }
  constructor(private formBuilder: FormBuilder, private accountService: AccountService ) { }

  ngOnInit() {
    this.accountService.getAccountByIdUser(this.userid).subscribe((data) => {
      this.userAccounts = data;
      console.log(data)
    });
    this.accountFormGroup = this.formBuilder.group({
      accountId : this.formBuilder.control('')
    });

  }

  submitAccount(){
    let accounId: number = this.accountFormGroup.value.accountId;
    this.accountObservable = this.accountService.getAccount(accounId,this.currentPage,this.pageSize);
  }


}
