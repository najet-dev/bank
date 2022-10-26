import { IUser } from '../../models/i-user';
import { Component, OnInit } from '@angular/core';

import {
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
import { UserService } from '../../services/user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.page.html',
  styleUrls: ['./inscription.page.scss'],
})
export class InscriptionPage implements OnInit {
  user: IUser = {
    id: 0,
    code: 0,
    lastName: '',
    firstName: '',
    username: '',
    password: '',
  };

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

  get code() {
    return this.registrationForm.get('code');
  }
  get lastname() {
    return this.registrationForm.get('lastname');
  }

  get firstname() {
    return this.registrationForm.get('firstname');
  }

  get username() {
    return this.registrationForm.get('username');
  }

  get password() {
    return this.registrationForm.get('password');
  }
  public errorMessages = {
    code: [
      { type: 'required', message: 'Le code est requis' },
      { type: 'minlength', message: 'Le nom doit contenir au minimum 10 chiffres' },
      { type: 'pattern', message: 'Veuillez entrer 10 ciffres au maximum' },
    ],
    lastname: [
      { type: 'required', message: 'Le nom est requis' },
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
        code: [
          '',
          [
            Validators.required,
            Validators.minLength(10),
            Validators.pattern(/^[0-9\-]{10}$/),


          ],
        ],
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
  async onSubmit() {
    if (this.registrationForm.valid) {
      //console.log(this.registrationForm.value)
      this.user.code = this.registrationForm.value['code']
      this.user.lastName = this.registrationForm.value['lastname']
      this.user.firstName = this.registrationForm.value['firstname']
      this.user.username = this.registrationForm.value['username']
      this.user.password = this.registrationForm.value['password']
      this.userService.addUser(this.user).subscribe(response => {
        console.log(response);
        this.registrationForm.reset();

      });
    }
  }
}




