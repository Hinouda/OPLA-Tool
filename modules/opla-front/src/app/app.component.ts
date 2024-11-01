import {AfterViewInit, Component, OnInit} from '@angular/core';
import {STEPPER_GLOBAL_OPTIONS} from "@angular/cdk/stepper";
import { DialogService } from './services/dialog.service';
import { InserirPlaJanelaComponent } from './wizard/inserir-pla-janela/inserir-pla-janela.component';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [{
    provide: STEPPER_GLOBAL_OPTIONS, useValue: {displayDefaultIndicatorType: false}
  }]
})
export class AppComponent implements OnInit, AfterViewInit {
  title = 'static';


  constructor(private dialogService: DialogService) {}
  

  ngAfterViewInit(): void {
  }

  ngOnInit(): void {
  }
  openDialog() {
    const componentRef = this.dialogService.open(InserirPlaJanelaComponent, { someData: 'data' });

    // Monitora quando o diálogo é fechado para fazer algo
    componentRef.instance.closeDialog = () => {
      this.dialogService.close(componentRef);
      console.log('Dialog closed!');
    };
  }

}
