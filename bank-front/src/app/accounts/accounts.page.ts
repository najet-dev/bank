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
  message = "";
  userAccounts: any;
  userid: number = 1;
  accountByIdUser: IAccountByIdUser ={
    id: 0,
    userName: '',
    name: '',
    type: '',
    balance: 0
  }
  transfer: ITransfer ={
    accountSource: 0,
    accountDestination: 0,
    amount: 0,
    id: 0
  };
accountFormGroup: FormGroup<any>;

  constructor(private formBuilder: FormBuilder, private accountService: AccountService, private httpClient: HttpClient,   public alertController: AlertController, public userService: UserService) { }
  transferFrom: FormGroup;
  isSubmitted = false;

  get accountSource() {
    return this.transferFrom.get('accountSource');
  }

  get accountDestination() {
    return this.transferFrom.get('accountDestination');
  }
  get amount() {
    return this.transferFrom.get('amount');
  }

  public errorMessages = {
    accountSource: [
      { type: 'required', message: 'Le nom est requis' },
      { type: 'pattern', message: 'Entrez un numéro valide' },
    ],

  }
  ngOnInit() {
    this.accountService.getAccountByIdUser(this.userid).subscribe((data) => {
      this.userAccounts = data;
      console.log(data)
    });
    this. transferFrom = this.formBuilder.group(
      {
        accountSource: [
          '',
          [
            Validators.required,
          ],
        ],
      },
    )
  }

  async submitTransfer(){
    if (this.transferFrom.valid) {
      // console.log(this.transferFrom.value);
      this.transfer.accountSource = this.transferFrom.value['accountSource'];


      if(this.transfer.accountSource === this.transfer.accountDestination){
        this.transferFrom.reset();
        this.presentAlert("Transfert vers le même compte impossible")
      }
      else {
        this.accountService.transfer(this.transfer).subscribe(response =>{

        // let message = response['message'];
          console.log(response);
          this.transferFrom.reset();
          this.presentAlert(response['message'])
          console.log(this.presentAlert(response['message'])
          )
        });
      }
    }
  }
  async presentAlert(message:string) {
    const alert = await this.alertController.create({
      header: 'Alert',
      subHeader: '',
      message: message,
      buttons: ['OK'],
    });
    await alert.present();
  }


  }




















