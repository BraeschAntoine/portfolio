import { Component, OnInit } from '@angular/core';
import { Select, Store } from "@ngxs/store";
import { LoadUser, Logout } from "../../../state/global.actions";
import { Observable } from "rxjs";
import { KeycloakProfile } from "keycloak-js";
import { GlobalState } from "../../../state/global.state";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  @Select(GlobalState.user) $user: Observable<KeycloakProfile>;

  constructor(private store: Store) { }

  ngOnInit(): void {
    this.loadUser();
  }

  loadUser() {
    this.store.dispatch(LoadUser);
  }

  logout(){
    this.store.dispatch(Logout)
  }

}
