import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: '',
    component: TabsPage,
    children:[
      {
        path: 'connexion',
        loadChildren: () => import('../component/connexion/connexion.module').then( m => m.ConnexionPageModule)
      },

      {
        path: 'inscription',
        loadChildren: () => import('../component/inscription/inscription.module').then( m => m.InscriptionPageModule)
      },
      {
        path: 'account',
        loadChildren: () => import('../component/account/account.module').then( m => m.AccountPageModule)
      },

      {
        path: 'transfer',
        loadChildren: () => import('../component/transfer/transfer.module').then( m => m.TransferPageModule)
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabsPageRoutingModule {}
