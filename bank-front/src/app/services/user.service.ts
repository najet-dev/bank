import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from "../../environments/environment";


import {IUser } from '../models/i-user';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  apiUrl = environment.apiUrl;

  constructor(public httpClient: HttpClient) { }

 /* public getUsers(): Observable<IUser[]> {
    return this.httpClient.get<IUser[]>(`${this.apiUrl}/users`);
  }

  public getUser(userId: number): Observable<IUser> {
    return this.httpClient.get<IUser>(`${this.apiUrl}/user/${userId}`);
  }*/

  public addUser(user: IUser) {
  return this.httpClient.post<IUser>(`${this.apiUrl}/api/auth/signup`, user);
  }

  /*public updateUser(user: IUser) {
  return this.httpClient.put<IUser>(`${this.apiUrl}/user/update`, user);
  }
  public deleteUser(id: number){
  this.httpClient.delete(`${this.apiUrl}/user/${id}`);
  }*/

}

