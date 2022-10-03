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

  getUsers(): Observable<IUser[]> {
    return this.httpClient.get<IUser[]>(`${this.apiUrl}/users`);
  }

  getUser(id: number): Observable<IUser> {
    return this.httpClient.get<IUser>(`${this.apiUrl}/user/${id}`);
  }

  postUser(user: IUser) {
  return this.httpClient.post(`${this.apiUrl}/user/add`, user);
  }

  patchUser(user: IUser) {
  return this.httpClient.patch(`${this.apiUrl}/user/update`, user).subscribe((data) => data);
  }
  deleteUser(id: number) {
  this.httpClient.delete(`${this.apiUrl}/user/${id}`).subscribe();
  }

}

