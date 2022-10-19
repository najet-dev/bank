import { AccountDetails } from '../../models/i-account';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AccountService } from '../../services/account.service';
import { Observable } from 'rxjs';
import { ITransfer } from 'src/app/models/i-transfer';

@Component({
  selector: 'app-account',
  templateUrl: './account.page.html',
  styleUrls: ['./account.page.scss'],
})
export class AccountPage implements OnInit {

  userAccounts: any;
  userid: number = 1;
  accountFormGroup: FormGroup;
  currentPage: number = 0;
  pageNumber : number = 0;
  pageSize : number = 5;
  accountObservable!: Observable<AccountDetails> ;
  totalPages : number;
  page: number = 0;

  transfer: ITransfer ={
    accountSource: 0,
    id: 0,
    accountDestination: 0,
    amount: 0
  };


  constructor(private formBuilder: FormBuilder, private accountService: AccountService ) { }


  ngOnInit() {
    this.accountService.getAccountByIdUser(this.userid).subscribe((data) => {
      this.userAccounts = data;
      console.log("userAccounts", this.userAccounts)
    });

    this.accountFormGroup = this.formBuilder.group({
      accountId : this.formBuilder.control('')
    });

  }

  submitAccount(){
    console.dir(this.accountFormGroup);
    let accounId: number = this.accountFormGroup.value.accountId;
    this.accountObservable = this.accountService.getAccount(accounId,this.currentPage,this.pageSize);

  }


}
