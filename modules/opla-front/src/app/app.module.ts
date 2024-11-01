<<<<<<< HEAD
import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExecutionComponent, PapyrusSettingsDialog } from './execution/execution.component';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MatButtonModule } from "@angular/material/button";
import { MatStepperModule } from "@angular/material/stepper";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { PatternComponent } from './pattern/pattern.component';
import { ResultsComponent } from './results/results.component';
import { ExperimentsComponent } from './experiments/experiments.component';
import { LogsComponent } from './logs/logs.component';
import { MatCheckboxModule } from "@angular/material/checkbox";
import { MatRadioModule } from "@angular/material/radio";
import { MatSelectModule } from "@angular/material/select";
import { MatIconModule } from "@angular/material/icon";
import { MatGridListModule } from "@angular/material/grid-list";
import { MatCardModule } from "@angular/material/card";
import { MatSliderModule } from "@angular/material/slider";
import { MatDividerModule } from "@angular/material/divider";
import { MatTooltipModule } from "@angular/material/tooltip";
import { HttpClientModule } from "@angular/common/http";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { MatProgressBarModule } from "@angular/material/progress-bar";
import { DragDropDirectiveDirective } from './directives/drag-drop-directive.directive';
import { MatTableModule } from "@angular/material/table";
import { CommonModule } from "@angular/common";
import { MatExpansionModule } from "@angular/material/expansion";
import { MatListModule } from "@angular/material/list";
import { ReplaceallPipe } from './pipes/replaceall.pipe';
import { NgVarDirective } from './directives/ng-var.directive';
import { MatBadgeModule } from "@angular/material/badge";
import { LoginComponent } from "./login/login.component";
import { OplaComponent } from "./opla/opla.component";
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";
import { InteractionDialogComponent } from "./dialogs/interaction/interaction-dialog.component";
import { MatDialogModule } from "@angular/material/dialog";
import { MatChipsModule } from "@angular/material/chips";
import { MatAutocompleteModule } from "@angular/material/autocomplete";
import { DialogTooltipInfo, OplaI18nDirective } from "./directives/opla-i18n.directive";
import { SuggestionDialogComponent } from "./dialogs/suggestion/suggestion-dialog.component";
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
=======
import {BrowserModule} from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ExecutionComponent, PapyrusSettingsDialog} from './execution/execution.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule} from "@angular/material/button";
import {MatStepperModule} from "@angular/material/stepper";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {PatternComponent} from './pattern/pattern.component';
import {ResultsComponent} from './results/results.component';
import {ExperimentsComponent} from './experiments/experiments.component';
import {LogsComponent} from './logs/logs.component';
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatRadioModule} from "@angular/material/radio";
import {MatSelectModule} from "@angular/material/select";
import {MatIconModule} from "@angular/material/icon";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatCardModule} from "@angular/material/card";
import {MatSliderModule} from "@angular/material/slider";
import {MatDividerModule} from "@angular/material/divider";
import {MatTooltipModule} from "@angular/material/tooltip";
import {HttpClientModule} from "@angular/common/http";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {DragDropDirectiveDirective} from './directives/drag-drop-directive.directive';
import {MatTableModule} from "@angular/material/table";
import {CommonModule} from "@angular/common";
import {MatExpansionModule} from "@angular/material/expansion";
import {MatListModule} from "@angular/material/list";
import {ReplaceallPipe} from './pipes/replaceall.pipe';
import {NgVarDirective} from './directives/ng-var.directive';
import {MatBadgeModule} from "@angular/material/badge";
import {LoginComponent} from "./login/login.component";
import {OplaComponent} from "./opla/opla.component";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {InteractionDialogComponent} from "./dialogs/interaction/interaction-dialog.component";
import {MatDialogModule} from "@angular/material/dialog";
import {MatChipsModule} from "@angular/material/chips";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {DialogTooltipInfo, OplaI18nDirective} from "./directives/opla-i18n.directive";
import {SuggestionDialogComponent} from "./dialogs/suggestion/suggestion-dialog.component";
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47

@NgModule({
  declarations: [
    AppComponent,
    ExecutionComponent,
    PatternComponent,
    ResultsComponent,
    ExperimentsComponent,
    LogsComponent,
    DragDropDirectiveDirective,
    ReplaceallPipe,
    NgVarDirective,
    OplaI18nDirective,
    LoginComponent,
    OplaComponent,
    DialogTooltipInfo,
    InteractionDialogComponent,
    SuggestionDialogComponent,
<<<<<<< HEAD
    PapyrusSettingsDialog,
    InserirPlaJanelaComponent,
    ObjectiveFunctionsJanelaComponent,
    ReviewObjectiveFunctionsComponent,
    SettingsComponent,
    ReviewSettingsComponent,
    CrossoverOperatorsComponent,
    ReviewCrossoverOperatorsComponent,
    MutationOperatorsComponent,
    ReviewMutationOperatorsComponent,
    InteractionsComponent,
    ReviewInteractionsComponent
=======
    PapyrusSettingsDialog
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
  ],
  exports: [OplaI18nDirective],
  imports: [
    BrowserModule,
    AppRoutingModule,
<<<<<<< HEAD
    MatDialogModule,
=======
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
    BrowserAnimationsModule,
    MatButtonModule,
    MatStepperModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
<<<<<<< HEAD
    MatSelectModule,
=======
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
    MatRadioModule,
    MatSelectModule,
    MatIconModule,
    MatGridListModule,
    MatCardModule,
    MatSliderModule,
    FormsModule,
    MatDividerModule,
    MatTooltipModule,
    HttpClientModule,
    MatSnackBarModule,
    MatProgressBarModule,
    MatTableModule,
    CommonModule,
    MatExpansionModule,
    MatListModule,
    MatBadgeModule,
    AppRoutingModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatChipsModule,
    MatAutocompleteModule
  ],
<<<<<<< HEAD
=======
  entryComponents: [
    InteractionDialogComponent,
    SuggestionDialogComponent,
    DialogTooltipInfo,
    PapyrusSettingsDialog
  ],
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
<<<<<<< HEAD
export class AppModule { }
=======
export class AppModule {
}
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
