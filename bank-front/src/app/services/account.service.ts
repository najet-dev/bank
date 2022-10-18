import { IAccountByIdUser } from './../models/i-accountUser';
import { IOperation, ITransfer } from './../models/i-transfer';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { AccountDetails } from '../models/i-account';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class AccountService {
  apiUrl = environment.apiUrl;


  constructor(private httpClient: HttpClient) { }

  public getAccount(accountId: number, page: number, size: number) :Observable<AccountDetails>{
    return this.httpClient.get<AccountDetails>(this.apiUrl +'/'+ accountId + "/pageOperations?page/" + page + "&size="+size);

  }
 public getAccountByIdUser(userId: number){
  return this.httpClient.get<IAccountByIdUser>(`${this.apiUrl}/account/user/${userId}`)
 }

  public transfer(transfer: ITransfer){
    return this.httpClient.put(`${this.apiUrl}/transfer`, transfer);
  }

}
