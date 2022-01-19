import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { KeycloakAngularModule, KeycloakService } from "keycloak-angular";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxsReduxDevtoolsPluginModule } from "@ngxs/devtools-plugin";
import { NgxsModule } from "@ngxs/store";
import { NgxsRouterPluginModule } from "@ngxs/router-plugin";
import { GlobalState } from "./state/global.state";
import { environment } from "../environments/environment";
import { AnonymousComponent } from './features/anonymous/anonymous/anonymous.component';
import { AdminComponent } from './features/admin/admin/admin.component';
import { AuthGuard } from "./guard/auth.guard";
import { MatButtonModule } from "@angular/material/button";
import { HttpClientModule } from '@angular/common/http';
import { TranslocoRootModule } from './transloco-root.module';
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatIconModule } from "@angular/material/icon";

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:9001/auth',
        realm: 'Portfolio',
        clientId: 'portfolio_client_web'
      },
      initOptions: {
        // add this onLoad if all the app needs to be protected
        //onLoad: 'login-required',
        checkLoginIframe: false
      },
      //loadUserProfileAtStartUp: true,
      enableBearerInterceptor: true,
      bearerExcludedUrls: ['/assets']
    });
}

@NgModule({
  declarations: [
    AppComponent,
    AnonymousComponent,
    AdminComponent
  ],
  imports: [
    NgxsModule.forRoot([GlobalState], {
      developmentMode: !environment.production
    }),
    NgxsReduxDevtoolsPluginModule.forRoot(),
    NgxsRouterPluginModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule,
    BrowserAnimationsModule,
    MatButtonModule,
    HttpClientModule,
    TranslocoRootModule,
    MatToolbarModule,
    MatIconModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService]
    },
    AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
