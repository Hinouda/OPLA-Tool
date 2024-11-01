import { Component, ComponentRef, Input, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { SettingsComponent } from '../settings/settings.component';
import { StateService } from '../../services/state.service';
import { ObjectiveFunctionsJanelaComponent } from '../objective-functions-janela/objective-functions-janela.component';

@Component({
  selector: 'app-review-objective-functions',
  templateUrl: './review-objective-functions.component.html',
  styleUrls: ['./review-objective-functions.component.css']
})
export class ReviewObjectiveFunctionsComponent implements OnInit {
  selectedFunctions: string[] = [];
  private componentRef: ComponentRef<any>;
  @ViewChild('host', { read: ViewContainerRef }) host: ViewContainerRef;
  constructor(private dialogService: DialogService, private stateService: StateService) {}
  
  ngOnInit(): void {
    const state = this.stateService.getData('objectiveFunctions');
    if (state && state.selectedFunctions) {
      this.selectedFunctions = state.selectedFunctions;
    }
  }
  

  onBack() {
    this.dialogService.close(this.componentRef);
    const componentRef = this.dialogService.open(ObjectiveFunctionsJanelaComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  onNext() {
    // Salvar o estado atual
    this.stateService.setData('reviewObjectiveFunctions', { selectedFunctions: this.selectedFunctions });

    this.dialogService.close(this.componentRef); // Fechar o diálogo atual
    const componentRef = this.dialogService.open(SettingsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }

  closeDialog() {
    this.dialogService.close(this.componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;
  }
}
