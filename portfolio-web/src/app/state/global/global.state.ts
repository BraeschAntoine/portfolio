import { Injectable } from '@angular/core';
import { Action, Selector, State, StateContext, StateToken } from '@ngxs/store';
import { KeycloakService } from "keycloak-angular";
import { KeycloakProfile } from "keycloak-js";
import { LoadUser, Logout, ToggleNavbar } from "./global.actions";
import { Navigate } from "@ngxs/router-plugin";

export interface GlobalStateModel {
  navbarVisible: boolean;
  user: KeycloakProfile | null
}

const GLOBAL_STATE_TOKEN = new StateToken<GlobalStateModel>('global')

@State<GlobalStateModel>({
  name: GLOBAL_STATE_TOKEN,
  defaults:
    {
      navbarVisible: false,
      user: null,
    }
})
@Injectable()
export class GlobalState {

  constructor(private keycloakService: KeycloakService) {
  }


  @Action(ToggleNavbar)
  toogleNavbar(ctx: StateContext<GlobalStateModel>) {
    const state = ctx.getState();
    ctx.setState({
      ...state,
        navbarVisible: !state.navbarVisible
    })
  }

  @Action(LoadUser)
  loadUser(ctx : StateContext<GlobalStateModel>){
    this.keycloakService.loadUserProfile().then(user => {
      ctx.patchState({ user })
    })
  }

  @Action(Logout)
  logout(ctx : StateContext<GlobalStateModel>) {
    this.keycloakService.logout('http://localhost:4200/')
  }
}
