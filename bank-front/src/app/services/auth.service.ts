import { BehaviorSubject, from, Observable, of} from 'rxjs';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { map, switchMap } from "rxjs/operators";
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Platform } from '@ionic/angular';

const helper = new JwtHelperService();
const TOKEN_KEY = 'jwt_token';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  userInfo = new BehaviorSubject(null);
  jwtHelper = new JwtHelperService();

  constructor(private storage: Storage, private httpClient: HttpClient, private platform: Platform, private router: Router) {
  }
  useLogin(login: any): Observable<boolean> {
    if (login && login.email && login.password) {
     var sampleJwt =
     "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IlRlc3QiLCJzdWIiOjIsImlhdCI6MTYwNDMwOTc0OSwiZXhwIjoxNjA0MzA5ODA5fQ.jHez9kegJ7GT1AO5A2fQp6Dg9A6PBmeiDW1YPaCQoYs";

     return of(sampleJwt).pipe(
     map((token) => {
       if (!token) {
       return false;
       }
       this.storage.set('access_token',token);
       var decodedUser = this.jwtHelper.decodeToken(token);
       this.userInfo.next(decodedUser);
       console.log(decodedUser);
       return true;
     })
     );
    }
    return of(false);
   }
  }
