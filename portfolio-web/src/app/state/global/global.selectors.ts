import { Selector } from "@ngxs/store";
import { GlobalState, GlobalStateModel } from "./global.state";

export class GlobalSelectors {

  @Selector([GlobalState])
  static user(state: GlobalStateModel) {
    return state.user;
  }
}
