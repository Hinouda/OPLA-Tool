import { Component, ComponentRef, Input, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { InteractionsComponent } from '../interactions/interactions.component';
import { StateService } from '../../services/state.service';

@Component({
  selector: 'app-review-interactions',
  templateUrl: './review-interactions.component.html',
  styleUrls: ['./review-interactions.component.css']
})
export class ReviewInteractionsComponent implements OnInit {
  clusteringAlgorithm: string = '';
  clusteringMoment: string = '';
  maxInteractions: number = 0;
  firstInteraction: number = 0;
  interval: number = 0;
  interact: boolean = false;
  private componentRef: ComponentRef<any>;
  @ViewChild('host', { read: ViewContainerRef }) host: ViewContainerRef;
  constructor(private dialogService: DialogService, private stateService: StateService) {}

  ngOnInit(): void {
    // Recuperar o estado salvo
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

  onBack() {
    this.dialogService.close(this.componentRef);
    const componentRef = this.dialogService.open(InteractionsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  onNext() {
    // Salvar o estado atual
    this.stateService.setData('reviewInteractions', {
      clusteringAlgorithm: this.clusteringAlgorithm,
      clusteringMoment: this.clusteringMoment,
      maxInteractions: this.maxInteractions,
      firstInteraction: this.firstInteraction,
      interval: this.interval,
      interact: this.interact
    });

    this.dialogService.close(this.componentRef); // Fechar o diálogo atual
  }

  closeDialog() {
    this.dialogService.close(this.componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;
  }
}
