import { Component, ComponentRef, ViewChild, ViewContainerRef, OnInit } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { ReviewMutationOperatorsComponent } from '../review-mutation-operators/review-mutation-operators.component';
import { ReviewCrossoverOperatorsComponent } from '../review-crossover-operators/review-crossover-operators.component';
import { StateService } from '../../services/state.service';

interface MutationResult {
  mutationRate: number;
  featureDriven: boolean;
  moveMethod: boolean;
  moveAttribute: boolean;
  moveOperation: boolean;
  addClass: boolean;
  addManagerClass: boolean;
  featureDrivenForClass: boolean;
}

@Component({
  selector: 'app-mutation-operators',
  templateUrl: './mutation-operators.component.html',
  styleUrls: ['./mutation-operators.component.css']
})
export class MutationOperatorsComponent implements OnInit {
  plaInfo: any;
  result: MutationResult;
  mutationRate: number = 0;
  featureDriven: boolean = false;
  moveMethod: boolean = false;
  moveAttribute: boolean = false;
  moveOperation: boolean = false;
  addClass: boolean = false;
  addManagerClass: boolean = false;
  featureDrivenForClass: boolean = false;
  private componentRef: ComponentRef<any>;

  @ViewChild('host', { read: ViewContainerRef }) host: ViewContainerRef;
  constructor(private dialogService: DialogService, private stateService: StateService) {
    this.result = {
      mutationRate: 0.5,
      featureDriven: true,
      moveMethod: false,
      moveAttribute: false,
      moveOperation: true,
      addClass: false,
      addManagerClass: true,
      featureDrivenForClass: false
    };
  }

  ngOnInit(): void {
    this.mutationRate = this.result.mutationRate * 10;

    // Recuperar o estado salvo
    const state = this.stateService.getData('mutationOperators');
    if (state) {
      this.mutationRate = state.mutationRate;
      this.featureDriven = state.featureDriven;
      this.moveMethod = state.moveMethod;
      this.moveAttribute = state.moveAttribute;
      this.moveOperation = state.moveOperation;
      this.addClass = state.addClass;
      this.addManagerClass = state.addManagerClass;
      this.featureDrivenForClass = state.featureDrivenForClass;
    }
  }

  onMutationRateChange(value: number) {
    this.mutationRate = value;
    const enabled = this.mutationRate > 0;
    this.featureDriven = enabled ? this.featureDriven : false;
    this.moveMethod = enabled ? this.moveMethod : false;
    this.moveAttribute = enabled ? this.moveAttribute : false;
    this.moveOperation = enabled ? this.moveOperation : false;
    this.addClass = enabled ? this.addClass : false;
    this.addManagerClass = enabled ? this.addManagerClass : false;
    this.featureDrivenForClass = enabled ? this.featureDrivenForClass : false;
  }

  autofillSettings() {
    this.mutationRate = this.result.mutationRate * 10;
    this.featureDriven = this.result.featureDriven;
    this.moveMethod = this.result.moveMethod;
    this.moveAttribute = this.result.moveAttribute;
    this.moveOperation = this.result.moveOperation;
    this.addClass = this.result.addClass;
    this.addManagerClass = this.result.addManagerClass;
    this.featureDrivenForClass = this.result.featureDrivenForClass;
  }

  onBack() {
    this.dialogService.close(this.componentRef);
    const componentRef = this.dialogService.open(ReviewCrossoverOperatorsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  onNext() {
    // Salvar o estado atual
    this.stateService.setData('mutationOperators', {
      mutationRate: this.mutationRate,
      featureDriven: this.featureDriven,
      moveMethod: this.moveMethod,
      moveAttribute: this.moveAttribute,
      moveOperation: this.moveOperation,
      addClass: this.addClass,
      addManagerClass: this.addManagerClass,
      featureDrivenForClass: this.featureDrivenForClass
    });

    this.dialogService.close(this.componentRef); // Fechar o diálogo atual
    const componentRef = this.dialogService.open(ReviewMutationOperatorsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }
  closeDialog() {
    this.dialogService.close(this.componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;
  }
}
