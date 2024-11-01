import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AppGuardComponent} from "./app.guard.component";
import {AppComponent} from "./app.component";
import {OplaComponent} from "./opla/opla.component";
<<<<<<< HEAD
import { InserirPlaJanelaComponent } from './wizard/inserir-pla-janela/inserir-pla-janela.component';
import { ObjectiveFunctionsJanelaComponent } from './wizard/objective-functions-janela/objective-functions-janela.component';
import { ReviewObjectiveFunctionsComponent } from './wizard/review-objective-functions/review-objective-functions.component';
import { SettingsComponent } from './wizard/settings/settings.component';
import { ReviewSettingsComponent } from './wizard/review-settings/review-settings.component';
import { CrossoverOperatorsComponent } from './wizard/crossover-operators/crossover-operators.component';
import { ReviewCrossoverOperatorsComponent } from './wizard/review-crossover-operators/review-crossover-operators.component';
import { MutationOperatorsComponent } from './wizard/mutation-operators/mutation-operators.component';
import { ReviewMutationOperatorsComponent } from './wizard/review-mutation-operators/review-mutation-operators.component';
import { InteractionsComponent } from './wizard/interactions/interactions.component';
import { ReviewInteractionsComponent } from './wizard/review-interactions/review-interactions.component';



const routes: Routes = [
  { path: 'inserir-pla', component: InserirPlaJanelaComponent },
  { path: 'objective-functions', component: ObjectiveFunctionsJanelaComponent },
  { path: 'review-objective-functions', component: ReviewObjectiveFunctionsComponent },
  { path: 'settings', component: SettingsComponent },
  { path: 'review-settings', component: ReviewSettingsComponent },
  { path: 'crossover-operators', component: CrossoverOperatorsComponent },
  { path: 'review-crossover-operators', component: ReviewCrossoverOperatorsComponent },
  { path: 'mutation-operators', component: MutationOperatorsComponent },
  { path: 'review-mutation-operators', component: ReviewMutationOperatorsComponent },
  { path: 'interactions', component: InteractionsComponent },
  { path: 'review-interactions', component: ReviewInteractionsComponent },
=======


const routes: Routes = [
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
  {path: 'login', component: LoginComponent},
  {path: 'opla', component: OplaComponent, canActivate: [AppGuardComponent]},
  { path: '', redirectTo: '/opla', pathMatch: 'full' },
  { path: '**', component: OplaComponent }
<<<<<<< HEAD

=======
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  constructor() {
    console.log("router module")
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
