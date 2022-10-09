import { AccountDetails } from '../../models/i-account';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AccountService } from '../../services/account.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-account',
  templateUrl: './account.page.html',
  styleUrls: ['./account.page.scss'],
})
export class AccountPage implements OnInit {
  accountFormGroup: FormGroup;
  currentPage = 0;
  pageSize = 5;
  accountObservable!: Observable<AccountDetails> ;


  constructor(private formBuilder: FormBuilder, private accountService: AccountService ) { }

  ngOnInit() {
    this.accountFormGroup = this.formBuilder.group({
      accountId : this.formBuilder.control('')
    });

  }

  submitAccount(){
    let accounId: number = this.accountFormGroup.value.accountId;
    this.accountObservable = this.accountService.getAccount(accounId,this.currentPage,this.pageSize);
  }


}
