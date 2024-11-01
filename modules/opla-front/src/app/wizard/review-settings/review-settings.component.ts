import { Component, ComponentRef, Input, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { CrossoverOperatorsComponent } from '../crossover-operators/crossover-operators.component';
import { StateService } from '../../services/state.service';
import { SettingsComponent } from '../settings/settings.component';

@Component({
  selector: 'app-review-settings',
  templateUrl: './review-settings.component.html',
  styleUrls: ['./review-settings.component.css']
})
export class ReviewSettingsComponent implements OnInit {
  algorithm: string = '';
  runs: number = 0;
  evaluations: number = 0;
  population: number = 0;
  private componentRef: ComponentRef<any>;
  @ViewChild('host', { read: ViewContainerRef }) host: ViewContainerRef;
  constructor(private dialogService: DialogService, private stateService: StateService) {}

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
    const componentRef = this.dialogService.open(SettingsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  onNext() {
    // Salvar o estado atual
    this.stateService.setData('reviewSettings', { algorithm: this.algorithm, runs: this.runs, evaluations: this.evaluations, population: this.population });

    this.dialogService.close(this.componentRef); // Fechar o diálogo atual
    const componentRef = this.dialogService.open(CrossoverOperatorsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  closeDialog() {
    this.dialogService.close(this.componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;
  }
}
