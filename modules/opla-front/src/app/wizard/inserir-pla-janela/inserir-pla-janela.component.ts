import { Component, ComponentRef } from '@angular/core';
import { DialogService } from '../../services/dialog.service';
import { ObjectiveFunctionsJanelaComponent } from '../objective-functions-janela/objective-functions-janela.component';
import { StateService } from '../../services/state.service';
import { PLAService } from '../../services/plaservice.service';

@Component({
  selector: 'app-inserir-pla-janela',
  templateUrl: './inserir-pla-janela.component.html',
  styleUrls: ['./inserir-pla-janela.component.css']
})
export class InserirPlaJanelaComponent {
  selectedFile: File | null = null;
  fileName: string = 'No file selected yet';
  private componentRef: ComponentRef<any>;

  constructor(private dialogService: DialogService, private stateService: StateService, private PLAService: PLAService) {}

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    if (file && file.name.endsWith('.smty')) {
      this.selectedFile = file;

      // Definir o observer
      const observer = {
        next: (response: any) => {
          console.log('Arquivo processado com sucesso:', response);
          // Aqui você pode manipular a resposta do backend se necessário
        },
        error: (error: any) => {
          console.error('Erro ao processar arquivo:', error);
        },
        complete: () => {
          console.log('Processamento do arquivo concluído.');
        }
      };

      // Usar o observer no subscribe
      this.PLAService.uploadFile(file).subscribe(observer);
      
    } else {
      this.selectedFile = null;
      this.fileName = 'The file path isn\'t a .smty file';
      alert('The file path isn\'t a .smty file');
    }
  }

  openObjectiveFunctions() {
    if (!this.selectedFile) {
      alert('You have to select a .smty path file to continue');
      return;
    }

    // Salvar o estado atual
    this.stateService.setData('inserirPla', { selectedFile: this.selectedFile, fileName: this.fileName });

    this.dialogService.close(this.componentRef); // Fechar o diálogo atual
    const componentRef = this.dialogService.open(ObjectiveFunctionsJanelaComponent);
    componentRef.instance.setComponentRef(componentRef);
  }

  closeDialog() {
    this.dialogService.close(this.componentRef);
  }

  setComponentRef(ref: ComponentRef<any>) {
    this.componentRef = ref;

    // Recuperar o estado salvo
    // const state = this.stateService.getData('inserirPla');
    // if (state) {
    //   this.selectedFile = state.selectedFile;
    //   this.fileName = state.fileName;
    // }
  }
}
