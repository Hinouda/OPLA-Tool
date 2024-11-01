import { Component, ComponentRef, OnInit, Input } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { ReviewCrossoverOperatorsComponent } from '../review-crossover-operators/review-crossover-operators.component';
import { ReviewSettingsComponent } from '../review-settings/review-settings.component';
import { StateService } from '../../services/state.service';

interface CrossoverResult {
  crossoverRate: number;
  featureDrivenCrossover: boolean;
  complementaryCrossover: boolean;
  modularCrossover: boolean;
}

@Component({
  selector: 'app-crossover-operators',
  templateUrl: './crossover-operators.component.html',
  styleUrls: ['./crossover-operators.component.css']
})
export class CrossoverOperatorsComponent implements OnInit {
  @Input() plaInfo: any;
  result: CrossoverResult;
  crossoverRate: number = 0;
  featureDriven: boolean = false;
  complementary: boolean = false;
  modular: boolean = false;
  private componentRef: ComponentRef<any>;

  constructor(private dialogService: DialogService, private stateService: StateService) {
    this.result = {
      crossoverRate: 0.5,
      featureDrivenCrossover: true,
      complementaryCrossover: false,
      modularCrossover: true
    };
  }
  

  ngOnInit(): void {
    this.crossoverRate = this.result.crossoverRate * 10;
  }
  
  onCrossoverRateChange(value: number) {
    this.crossoverRate = value;
    const enabled = this.crossoverRate > 0;
    this.featureDriven = enabled ? this.featureDriven : false;
    this.complementary = enabled ? this.complementary : false;
    this.modular = enabled ? this.modular : false;
  }

  autofillSettings() {
    this.crossoverRate = this.result.crossoverRate * 10;
    this.featureDriven = this.result.featureDrivenCrossover;
    this.complementary = this.result.complementaryCrossover;
    this.modular = this.result.modularCrossover;
  }

  onBack() {
    this.dialogService.close(this.componentRef);
    const componentRef = this.dialogService.open(ReviewSettingsComponent);
    componentRef.instance.setComponentRef(componentRef);
  }a

  onNext() {
    // Salvar o estado atuala
    this.stateService.setData('crossoverOperators', {
      crossoverRate: this.crossoverRate,
      featureDriven: this.featureDriven,
      complementary: this.complementary,
      modular: this.modular
    });

    this.dialogService.close(this.componentRef); // Fechar o diálogo atual
    const componentRef = this.dialogService.open(ReviewCrossoverOperatorsComponent);
    componentRef.instance.setComponentRef(componentRef);
  }

  closeDialog() {
    this.dialogService.close(this.componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;
  }
}
