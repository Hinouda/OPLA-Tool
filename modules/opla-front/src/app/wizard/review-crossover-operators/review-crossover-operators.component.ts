import { Component, ComponentRef, Input, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { MutationOperatorsComponent } from '../mutation-operators/mutation-operators.component';
import { StateService } from '../../services/state.service';
import { CrossoverOperatorsComponent } from '../crossover-operators/crossover-operators.component';

@Component({
  selector: 'app-review-crossover-operators',
  templateUrl: './review-crossover-operators.component.html',
  styleUrls: ['./review-crossover-operators.component.css']
})
export class ReviewCrossoverOperatorsComponent implements OnInit {
  crossoverRate: number = 0;
  featureDriven: boolean = false;
  complementary: boolean = false;
  modular: boolean = false;
  private componentRef: ComponentRef<any>;
  @ViewChild('host', { read: ViewContainerRef }) host: ViewContainerRef;
  constructor(private dialogService: DialogService, private stateService: StateService) {}

  ngOnInit(): void {
    // Recuperar o estado salvo
    const state = this.stateService.getData('crossoverOperators');
    if (state) {
      this.crossoverRate = state.crossoverRate;
      this.featureDriven = state.featureDriven;
      this.complementary = state.complementary;
      this.modular = state.modular;
    }
  }

  onBack() {
    this.dialogService.close(this.componentRef);
    const componentRef = this.dialogService.open(CrossoverOperatorsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  onNext() {
    // Salvar o estado atual
    this.stateService.setData('reviewCrossoverOperators', {
      crossoverRate: this.crossoverRate,
      featureDriven: this.featureDriven,
      complementary: this.complementary,
      modular: this.modular
    });

    this.dialogService.close(this.componentRef); // Fechar o diálogo atual
    const componentRef = this.dialogService.open(MutationOperatorsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  closeDialog() {
    this.dialogService.close(this.componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;
  }
}
