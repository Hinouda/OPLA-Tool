import { Component, ComponentRef, Input, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { ReviewSettingsComponent } from '../review-settings/review-settings.component';
import { StateService } from '../../services/state.service';
import { PLAService } from '../../services/plaservice.service';
import { ReviewObjectiveFunctionsComponent } from '../review-objective-functions/review-objective-functions.component';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {
  @Input() plaInfo: any;
  private componentRef: ComponentRef<any>;
  runs: number;
  evaluations: number;
  population: number;
  algorithm: string;
  recommendedAlgorithm: string;
  algorithms: string[] = ["NSGAII", "NSGAIII", "PAES", "Best of 2", "Best of 12", "No Choice", "Until Best", "NSGAII ASP"];
  @ViewChild('host', { read: ViewContainerRef }) host: ViewContainerRef;

  constructor(private dialogService: DialogService, private stateService: StateService, private plaService: PLAService) {}

  ngOnInit(): void {
    // Recuperar o estado salvo
    const state = this.stateService.getData('settings');
    if (state) {
      this.algorithm = state.algorithm;
      this.runs = state.runs;
      this.evaluations = state.evaluations;
      this.population = state.population;
    }
  }

  onBack() {
    this.dialogService.close(this.componentRef);
    const componentRef = this.dialogService.open(ReviewObjectiveFunctionsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  onNext() {
    if (this.validateInputs()) {
      this.dialogService.close(this.componentRef); // Fecha o diálogo atual
      const componentRef =   this.dialogService.open(ReviewSettingsComponent, {
        algorithm: this.algorithm,
        runs: this.runs,
        evaluations: this.evaluations,
        population: this.population,
        plaInfo: this.plaInfo
      }); // Abre o próximo componente ReviewSettingsComponent
      componentRef.instance.setComponentRef(componentRef); // Passa o componentRef para o próximo componente
    } else {
      alert("Please fill in all the required fields.");
    }
  }

  closeDialog() {
    this.dialogService.close(this.componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;
  }

  autofill() {
    // console.log("Autofill called with plaInfo:", this.plaInfo); // Log para depuração
    // if (!this.plaInfo) {
    //   console.error('plaInfo is undefined');
    //   return;
    // }

    // this.plaService.getSettings(this.plaInfo).subscribe({
    //   next: (settings: any) => {
    //     console.log("Settings received:", settings); // Log para depuração
    //     if (settings) {
    //       this.runs = settings.runs;
    //       this.evaluations = settings.numberOfFitnessEvaluations;
    //       this.population = settings.populationSize;
    //     } else {
    //       console.error('Settings response is undefined');
    //     }
    //   },
    //   error: (error) => {
    //     console.error('Erro ao buscar configurações:', error);
    //   }
    // });
  }

  validateInputs() {
    return this.runs && this.evaluations && this.population;
  }
}
