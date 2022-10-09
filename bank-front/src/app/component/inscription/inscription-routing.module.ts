import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule} from '@angular/forms';


import { InscriptionPage } from './inscription.page';

const routes: Routes = [
  {
    path: '',
    component: InscriptionPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule, CommonModule, FormsModule, ReactiveFormsModule],
})
export class InscriptionPageRoutingModule {}
