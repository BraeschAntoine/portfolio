import { GlobalActionsEnum } from "./global.actions.enum";

const PREFIX = '[GLOBAL] '

export class ToggleNavbar {
  static readonly type = PREFIX + GlobalActionsEnum.TOGGLE_NAVBAR;
}

export class LoadUser {
  static readonly type = PREFIX + GlobalActionsEnum.LOAD_USER;
}

export class Logout {
  static readonly type = PREFIX + GlobalActionsEnum.LOGOUT;

}
