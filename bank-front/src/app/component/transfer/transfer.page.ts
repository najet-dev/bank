import { HttpClient } from '@angular/common/http';
import { IOperation, ITransfer } from '../../models/i-transfer';
import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AccountService} from '../../services/account.service';
import { AccountPage } from '../account/account.page' ;




@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.page.html',
  styleUrls: ['./transfer.page.scss'],
})
export class TransferPage implements OnInit {

  operation: IOperation = {
    accountId: 0,
    amount: 0,
  };

  transfer: ITransfer ={
    accountSource: 0,
    accountDestination: 0,
    amount: 0
  };


  constructor(private formBuilder: FormBuilder, private accountService: AccountService, private HttpClient: HttpClient ) { }
  transferFrom: FormGroup;
  isSubmitted = false;


  ngOnInit() {
    this.transferFrom = this.formBuilder.group({
      accountSource: this.formBuilder.control(0),
      accountDestination: this.formBuilder.control(0),
      amount : this.formBuilder.control(0),


    })


  }


  submitTransfer(){
    if (this.transferFrom.valid) {
      console.log(this.transferFrom.value)
      this.transfer.accountDestination = this.transferFrom.value['accountDestination']
      this.transfer.accountSource = this.transferFrom.value['accountSource']
      this.transfer.amount = this.transferFrom.value['amount']
      this.accountService.transfer(this.transfer).subscribe(response =>{
        console.log(response);
        this.transferFrom.reset();
      })

    }
  }
}





