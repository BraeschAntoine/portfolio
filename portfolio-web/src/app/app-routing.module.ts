import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from "./app.component";
import { KeycloakAuthGuard } from "keycloak-angular";
import { AuthGuard } from "./guard/auth.guard";
import { AnonymousComponent } from "./features/anonymous/anonymous/anonymous.component";
import { AdminComponent } from "./features/admin/admin/admin.component";

const routes: Routes = [
  {
    path: '',
    component: AnonymousComponent
  },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AuthGuard],
    data: { roles: ['admin']}
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  providers: [AuthGuard],
  exports: [RouterModule]
})
export class AppRoutingModule { }
