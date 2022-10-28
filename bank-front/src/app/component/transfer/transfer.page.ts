import { IAccountBalance } from './../../models/i-transfer';
import { AccountDetails } from './../../models/i-account';
import { HttpClient } from '@angular/common/http';
import { IOperation, ITransfer } from '../../models/i-transfer';
import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';
import {AccountService} from '../../services/account.service';
import { AlertController, ModalController } from '@ionic/angular';
import { AccountPage } from '../account/account.page' ;
import { Observable } from 'rxjs';
import { IAccountByIdUser } from 'src/app/models/i-accountUser';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';




@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.page.html',
  styleUrls: ['./transfer.page.scss'],
})
export class TransferPage implements OnInit {
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
  accountDestination: [
    { type: 'required', message: ' Le account destination est requis' },
    { type: 'pattern', message: 'Entrez un numéro valide' },
  ],
  amount: [
    { type: 'required', message: ' Le montant est requis' },
    { type: 'pattern', message: 'Entrez un moutant valide' },
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
      accountDestination: [
        '',
        [
          Validators.required,
        ],
      ],
      amount: [
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
    this.transfer.accountDestination = this.transferFrom.value["accountDestination"];
    this.transfer.amount = this.transferFrom.value['amount'];

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
    header: '',
    subHeader: '',
    message: message,
    buttons: ['OK'],
  });
  await alert.present();
}


}




















