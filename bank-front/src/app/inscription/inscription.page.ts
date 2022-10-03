import { IUser } from './../models/i-user';
import { Component, OnInit } from '@angular/core';

import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  FormsModule,
  ValidationErrors,
  ValidatorFn,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AlertController, NavController } from '@ionic/angular';
import { UserService } from '../services/user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.page.html',
  styleUrls: ['./inscription.page.scss'],
})
export class InscriptionPage implements OnInit {
  user: IUser = {};

  constructor(
    public formBuilder: FormBuilder,
    private router: Router,
    private navCtrl: NavController,
    private userService: UserService,
    private http: HttpClient,
    private alertCtrl: AlertController,
  ) { }

  registrationForm: FormGroup;
  isSubmitted = false;

  get lastname() {
    return this.registrationForm.get('lastname');
  }

  get firstname() {
    return this.registrationForm.get('firstname');
  }

  get username() {
    return this.registrationForm.get('username');
  }



  get email() {
    return this.registrationForm.get('email');
  }

  get password() {
    return this.registrationForm.get('password');
  }

  public errorMessages = {
    lastname: [
      { type: 'required', message: 'Lastname est requis' },
      { type: 'minlength', message: 'Le nom doit contenir au minimum 1 caractères' },
      { type: 'maxlength', message: 'Le nom doit contenir au maximum 30 caractères' },
      { type: 'pattern', message: 'Entrez un nom valide' },
    ],
    firstname: [
      { type: 'required', message: ' Le prénom est requis' },
      { type: 'minlength', message: 'Le prénom doit contenir au minimum 1 caractères' },
      { type: 'maxlength', message: 'Le prénom doit contenir au maximum 30 caractères' },
      { type: 'pattern', message: 'Entrez un prénom valide' },
    ],
    username: [
      { type: 'required', message: ' Le pseudo est requis' },
      { type: 'pattern', message: 'Entrez un pseudo valide' },
      { type: 'minlength', message: 'Le pseudo doit contenir au minimum 4 caractères' },
      { type: 'maxlength', message: 'Le pseudo doit contenir au maximum 20 caractères' },
    ],
    email: [
      { type: 'required', message: ' Email requis' },
      { type: 'email', message: 'Email doit être valide' },
    ],
    password: [
      { type: 'minlength', message: ' Le mot de passe doit contenir au minimum 8 caractères' },
      { type: 'required', message: ' Le mot de passe est requis' },
      {
        type: 'pattern',
        message:
          'Le mot de passe doit contenir une lettre majuscule, une lettre minuscule, un chiffre et un caractère spécial au minimum',
      },
    ],


  };


  ngOnInit() {
    this.registrationForm = this.formBuilder.group(
      {
        lastname: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(30),
            Validators.pattern(/^[A-Za-z\-]{1,30}$/),
          ],
        ],
        firstname: [
          '',
          [
            Validators.required,
            Validators.minLength(1),
            Validators.maxLength(30),
            Validators.pattern(/^[A-Za-z\-]{1,30}$/),
          ],
        ],
        username: [
          '',
          [
            Validators.required,
            Validators.maxLength(20),
            Validators.minLength(4),
            Validators.pattern(/^[A-Za-z1-9_.-]{4,20}$/),
          ],
        ],
        email: [
          '',
          [
            Validators.required,
            Validators.email,
            Validators.pattern(/^[a-z-0-9._%+-]+@[a-z-0-9.-]+\.[a-z]{2,4}$/),
          ],
        ],
        password: [
          '',
          [
            Validators.required,
            Validators.minLength(8),
            Validators.pattern(/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^_/:&*-]).{8,}$/),
          ],
        ],

      }
    )
    }
   /* onSubmit() {
      console.log(this.registrationForm.value);
    }*/
    async onSubmit() {
      if (this.registrationForm.valid) {
        this.user.lastName = this.registrationForm.value['lastName']
        this.user.firstName = this.registrationForm.value['firstName']
        this.user.email = this.registrationForm.value['email']
        this.user.username = this.registrationForm.value['username']
        this.user.password = this.registrationForm.value['password']
        this.userService.postUser(this.user).subscribe();
      }
    }
  }




