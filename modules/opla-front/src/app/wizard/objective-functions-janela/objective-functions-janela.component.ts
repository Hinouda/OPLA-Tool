import { Component, ComponentRef, Input, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { ReviewObjectiveFunctionsComponent } from '../review-objective-functions/review-objective-functions.component';
import { StateService } from '../../services/state.service';
import { InserirPlaJanelaComponent } from '../inserir-pla-janela/inserir-pla-janela.component';

@Component({
  selector: 'app-objective-functions-janela',
  templateUrl: './objective-functions-janela.component.html',
  styleUrls: ['./objective-functions-janela.component.css']
})
export class ObjectiveFunctionsJanelaComponent {
  checkboxes: { name: string, checked: boolean, tooltip: string, recommendation: string }[] = [];
  selectedFunctions: string[] = [];
  accumulatedMessage: string = '';
  private componentRef: ComponentRef<any>;
  
  @ViewChild('host', { read: ViewContainerRef }) host: ViewContainerRef;
  functionNames = [
    "ACLASS", "COE", "ELEG", "SD", "CS", "ACOMP", "CM", "FM", "SV", "LFCC",
    "TV", "DC", "LCC", "TAM", "FDAC", "RCC", "EC", "EXT", "WOCSCLASS", "CIBF"
  ];

  tooltips = {
    "ACLASS": "Class Coupling: It aims to measure the number of input and output elements in which one class depends on another.",
    "COE": "Cohesion: It aims to measure the relational cohesion between classes.",
    "ELEG": "Elegance: It evaluates the simplicity and elegance of the system design.",
    "SD": "Software Dependability: It measures the reliability of the system.",
    "CS": "Class Size: It measures the size of classes in the system.",
    "ACOMP": "Abstractness and Componentization: It assesses the level of abstraction and componentization in the system.",
    "CM": "Component Modularity: It measures the modularity of the system's components.",
    "FM": "Functionality Management: It assesses how funcionalidades são gerenciadas no sistema.",
    "SV": "Structural Value: It measures the structural value of the system.",
    "LFCC": "Low Frequency Cohesive Components: It evaluates the cohesiveness of components used infrequently.",
    "TV": "Type Variety: It measures the variety of types in the system.",
    "DC": "Design Complexity: It measures the complexity of the system's design.",
    "LCC": "Low Coupling Components: It measures the coupling between components.",
    "TAM": "Type Abstraction and Modularity: It measures the abstraction and modularity of types.",
    "FDAC": "Functional Dependencies Among Components: It measures the dependencies among different components.",
    "RCC": "Reusability and Component Cohesion: It assesses the reusability and cohesion of components.",
    "EC": "Efficiency and Conciseness: It measures the efficiency and conciseness of the system.",
    "EXT": "Extensibility: It measures how easily the system can be extended.",
    "WOCSCLASS": "Weight of Complex Class: It evaluates the complexity of classes in the system.",
    "CIBF": "Cyclomatic Complexity and Behavioral Functions: It measures the cyclomatic complexity of functions."
  };
 


  constructor(private dialogService: DialogService, private stateService: StateService) {
    for (let name of this.functionNames) {
      this.checkboxes.push({
        name,
        checked: false,
        tooltip: this.tooltips[name],
        recommendation: "Our recommendation is: "
      });
    }
  }

  ngOnInit(): void {
    // Recupera os dados armazenados no StateService
    const state = this.stateService.getData('objectiveFunctions');
    if (state && state.selectedFunctions) {
      this.selectedFunctions = state.selectedFunctions;

      // Marca as caixinhas que foram selecionadas
      for (let checkbox of this.checkboxes) {
        checkbox.checked = this.selectedFunctions.includes(checkbox.name);
      }
    }
  }


  autofill() {
    for (let checkbox of this.checkboxes) {
      checkbox.checked = Math.random() < 0.5; // Randomly set some checkboxes to checked for demonstration
      checkbox.recommendation = `Our recommendation is: ${checkbox.checked ? 'Yes' : 'No'}`;
    }
  }

  updateRecommendation() {
    this.accumulatedMessage = "Updated recommendations based on selections.";
  }

  // 
  onNext() {
    this.selectedFunctions = this.checkboxes
      .filter(c => c.checked)
      .map(c => c.name);
  
    // Armazenando as funções selecionadas no StateService
    this.stateService.setData('objectiveFunctions', { selectedFunctions: this.selectedFunctions });
    
    // Fechar o diálogo atual
    this.dialogService.close(this.componentRef);
  
    // Abrir o próximo componente
    const componentRef = this.dialogService.open(ReviewObjectiveFunctionsComponent, this.host);
    componentRef.instance.setComponentRef(componentRef);
  }
  
  
  

  closeDialog() {
    this.dialogService.close(this.componentRef);
  }
  onBack() {
    this.dialogService.close(this.componentRef);
    const componentRef = this.dialogService.open(InserirPlaJanelaComponent, this.host); // Corrigir referência ao componente
    componentRef.instance.setComponentRef(componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;
  
   const state = this.stateService.getData('objectiveFunctions');
    if (state) {
      this.selectedFunctions = state.selectedFunctions;
    }
  }
}
