import { Component, ComponentRef, Input, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { ReviewInteractionsComponent } from '../review-interactions/review-interactions.component';
import { ReviewMutationOperatorsComponent } from '../review-mutation-operators/review-mutation-operators.component';
import { StateService } from '../../services/state.service';

@Component({
  selector: 'app-interactions',
  templateUrl: './interactions.component.html',
  styleUrls: ['./interactions.component.css']
})
export class InteractionsComponent implements OnInit {
  @Input() plaInfo: any;
  result: any; // Defina a estrutura do resultado apropriada aqui
  interact: boolean = false;
  clusteringAlgorithm: string = 'KMEANS';
  clusteringMoment: string = 'INTERACTIVE';
  maxInteractions: number = 0;
  firstInteraction: number = 0;
  interval: number = 0;
  private componentRef: ComponentRef<any>;

  @ViewChild('host', { read: ViewContainerRef }) host: ViewContainerRef;

  constructor(private dialogService: DialogService, private stateService: StateService) {
    this.result = {
      interact: true,
      clusteringAlgorithm: 'KMEANS',
      clusteringMoment: 'INTERACTIVE',
      maxInteractions: 10,
      firstInteraction: 1,
      interval: 2
    };
  }

  ngOnInit(): void {
    const state = this.stateService.getData('interactions');
    if (state) {
      this.clusteringAlgorithm = state.clusteringAlgorithm;
      this.clusteringMoment = state.clusteringMoment;
      this.maxInteractions = state.maxInteractions;
      this.firstInteraction = state.firstInteraction;
      this.interval = state.interval;
      this.interact = state.interact;
    }
  }

  autofillSettings() {
    this.interact = this.result.interact;
    this.clusteringAlgorithm = this.result.clusteringAlgorithm;
    this.clusteringMoment = this.result.clusteringMoment;
    this.maxInteractions = this.result.maxInteractions;
    this.firstInteraction = this.result.firstInteraction;
    this.interval = this.result.interval;
  }

  onBack() {
    this.dialogService.close(this.componentRef);
    const componentRef = this.dialogService.open(ReviewMutationOperatorsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  onNext() {
    this.stateService.setData('interactions', {
      clusteringAlgorithm: this.clusteringAlgorithm,
      clusteringMoment: this.clusteringMoment,
      maxInteractions: this.maxInteractions,
      firstInteraction: this.firstInteraction,
      interval: this.interval,
      interact: this.interact
    });

    this.dialogService.close(this.componentRef);
    const componentRef = this.dialogService.open(ReviewInteractionsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  closeDialog() {
    this.dialogService.close(this.componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;
  }
}
