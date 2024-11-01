import { Component, ComponentRef, Input, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { InteractionsComponent } from '../interactions/interactions.component';
import { StateService } from '../../services/state.service';
import { MutationOperatorsComponent } from '../mutation-operators/mutation-operators.component';

@Component({
  selector: 'app-review-mutation-operators',
  templateUrl: './review-mutation-operators.component.html',
  styleUrls: ['./review-mutation-operators.component.css']
})
export class ReviewMutationOperatorsComponent implements OnInit {
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
  constructor(private dialogService: DialogService, private stateService: StateService) {}

  ngOnInit(): void {
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

  onBack() {
    this.dialogService.close(this.componentRef);
    const componentRef = this.dialogService.open(MutationOperatorsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  onNext() {
    // Salvar o estado atual
    this.stateService.setData('reviewMutationOperators', {
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
    const componentRef = this.dialogService.open(InteractionsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  closeDialog() {
    this.dialogService.close(this.componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;
  }
}
