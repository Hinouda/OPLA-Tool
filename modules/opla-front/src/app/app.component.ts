import {AfterViewInit, Component, OnInit} from '@angular/core';
import {STEPPER_GLOBAL_OPTIONS} from "@angular/cdk/stepper";
<<<<<<< HEAD
import { DialogService } from './services/dialog.service';
import { InserirPlaJanelaComponent } from './wizard/inserir-pla-janela/inserir-pla-janela.component';
=======

>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
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


<<<<<<< HEAD
  constructor(private dialogService: DialogService) {}
  
=======
  constructor() {

  }
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47

  ngAfterViewInit(): void {
  }

  ngOnInit(): void {
  }
<<<<<<< HEAD
  openDialog() {
    const componentRef = this.dialogService.open(InserirPlaJanelaComponent, { someData: 'data' });

    // Monitora quando o diálogo é fechado para fazer algo
    componentRef.instance.closeDialog = () => {
      this.dialogService.close(componentRef);
      console.log('Dialog closed!');
    };
  }
=======
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47

}
