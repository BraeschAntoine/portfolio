import { Component, OnInit } from '@angular/core';
import { KeycloakService } from "keycloak-angular";

@Component({
  selector: 'app-anonymous',
  templateUrl: './anonymous.component.html',
  styleUrls: ['./anonymous.component.scss']
})
export class AnonymousComponent implements OnInit {

  constructor(private keycloakService: KeycloakService) {
  }

  logout() {
    this.keycloakService.logout();
  }

  ngOnInit(): void {
  }

}
