<<<<<<< HEAD
import {AfterViewInit, Component, OnInit,  ViewChild, ViewContainerRef, Input} from '@angular/core';
=======
import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {STEPPER_GLOBAL_OPTIONS} from "@angular/cdk/stepper";
import {OptimizationDto} from "../dto/optimization-dto";
import {OptimizationInfo} from "../dto/optimization-info";
import {OptimizationService} from "../services/optimization.service";
import {MatStepper} from "@angular/material/stepper";
import {ExperimentService} from "../services/experiment.service";
import {InfoService} from "../services/info.service";
import {ObjectiveService} from "../services/objective.service";
import {ExperimentConfigurationService} from "../services/experiment-configuration.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";
import {InteractionDialogComponent} from "../dialogs/interaction/interaction-dialog.component";
import {MatDialog} from "@angular/material/dialog";
<<<<<<< HEAD
import { InserirPlaJanelaComponent } from '../wizard/inserir-pla-janela/inserir-pla-janela.component';
import { DialogService } from '../services/dialog.service';
import { StateService } from '../services/state.service';
=======

>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
@Component({
  selector: 'opla',
  templateUrl: './opla.component.html',
  styleUrls: ['./opla.component.css'],
  providers: [{
    provide: STEPPER_GLOBAL_OPTIONS, useValue: {displayDefaultIndicatorType: false}
  }]
})
export class OplaComponent implements OnInit, AfterViewInit {
<<<<<<< HEAD


=======
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
  title = 'static';
  isLinear = false;
  papyrusFormGroup: FormGroup;
  public static isOnInteraction = false;
  executionFormGroup: FormGroup;
  patternFormGroup: FormGroup;
  resultsFormGroup: FormGroup;
  experimentsFormGroup: FormGroup;
  logsFormGroup: FormGroup;
  optimizationDto: OptimizationDto = new OptimizationDto();
  @ViewChild('stepper', {static: true}) stepper: MatStepper;
  optimizationInfo: OptimizationInfo = OptimizationService.getOptimizationInfo();
  optimizationOptions: any;
  experiments: any;
<<<<<<< HEAD
  
  selectedFunctions: string[];
=======
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47

  constructor(private _formBuilder: FormBuilder,
              public optimizationService: OptimizationService,
              public userService: UserService,
              private router: Router,
              public experimentService: ExperimentService,
              public infoService: InfoService,
              public objectiveService: ObjectiveService,
              public experimentConfigurationService: ExperimentConfigurationService,
              public dialog: MatDialog,
<<<<<<< HEAD
              private snackBar: MatSnackBar, fb: FormBuilder,
              private dialogService: DialogService,
              private stateService: StateService,) {
=======
              private snackBar: MatSnackBar, fb: FormBuilder) {
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
    this.executionFormGroup = fb.group({
      mutation: ['', Validators.compose([Validators.required])],
      mutationProbability: ['', Validators.compose([Validators.required])],
      crossover: new FormControl(),
      crossoverProbability: new FormControl(),
      numberRuns: ['', Validators.compose([Validators.required])],
      maxEvaluations: ['', Validators.compose([Validators.required])],
      populationSize: ['', Validators.compose([Validators.required])],
      archiveSize: new FormControl(),
      maxInteractions: new FormControl(),
      firstInteraction: new FormControl(),
      intervalInteraction: new FormControl(),
      inputArchitecture: ['', Validators.compose([Validators.required])]
    });
    this.papyrusFormGroup = fb.group({
      pathToProfile: new FormControl(),
      pathToProfileConcern: new FormControl(),
      pathToProfilePatterns: new FormControl(),
      pathToProfileRelationships: new FormControl(),
      smarty: new FormControl(),
      feature: new FormControl(),
      patterns: new FormControl(),
      relationships: new FormControl()
    });
    this.patternFormGroup = fb.group({});
    optimizationService.getDto().subscribe(dto => {
      this.optimizationDto = dto
    });

    this.optimizationService.getOptimizationOptions().subscribe(options => {
      this.optimizationOptions = options;
    });

    this.optimizationInfo = OptimizationService.getOptimizationInfo();
    OptimizationService.onOptimizationInfo.asObservable().subscribe(optimizationInfo => {
      this.verifyInteraction(optimizationInfo);
      this.optimizationInfo = optimizationInfo;
    });

    this.experimentService.getAll().subscribe(experiments => {
      this.experiments = experiments.values;
    })
  }

<<<<<<< HEAD


=======
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
  verifyInteraction(optimizationInfo) {
    if (optimizationInfo && optimizationInfo.status === "INTERACT" && !OplaComponent.isOnInteraction) {
      OplaComponent.isOnInteraction = true;
      console.log("chamou no opla", OplaComponent.isOnInteraction, optimizationInfo)
      this.optimizationService.getInteraction(optimizationInfo.hash).subscribe(interaction => {
        if (interaction.solutionSet) {
          const dialogRef = this.dialog.open(InteractionDialogComponent, {
            panelClass: 'opla-dialog-full-panel',
            data: {info: optimizationInfo, interaction: interaction}
          });

          dialogRef.afterClosed().subscribe(result => {
            console.log("finish", result);
            this.optimizationService.postInteraction(optimizationInfo.hash, result).subscribe(putInt => {
              console.log("put", putInt);
              setTimeout(() => {
                OplaComponent.isOnInteraction = false;
              }, 1000)
            })
          });
        }
      });
    }
  }

  ngAfterViewInit(): void {
<<<<<<< HEAD
    this.verifyInteraction(this.optimizationInfo);
=======
    // this.verifyInteraction(this.optimizationInfo);
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
    this.stepper.selectedIndex = 0;
  }

  ngOnInit() {
<<<<<<< HEAD
    // Verifica os dados no StateService quando o componente é inicializado
    // this.updateSelectedFunctions();
  }
  
  updateSelectedFunctions() {
    // const state = this.stateService.getData('objectiveFunctions');
    // if (state && state.selectedFunctions) {
    //   this.selectedFunctions = state.selectedFunctions;
    //   console.log('Funções Objetivas Selecionadas:', this.selectedFunctions);
  
    //   // Preencha automaticamente os campos no formulário ou outros elementos do componente
    //   this.applySelectedFunctions();
    // }
  }
  
  applySelectedFunctions() {
    // Exemplo de preenchimento automático com as funções selecionadas
    if (this.selectedFunctions) {
      this.executionFormGroup.patchValue({
        // Atualize os campos do formulário com base nas funções selecionadas
      });
    }
  }
  

  
  
=======
  }
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47

  isRunning() {
    return OptimizationService.isRunning();
  }

  run(optimizationDto: OptimizationDto) {
    this.optimizationService.optimize(optimizationDto).subscribe(info => {
      this.snackBar.open("Optimization started", "View logs", {
        duration: 10000
      }).onAction().subscribe(() => {
        this.stepper.selectedIndex = 4
      })
    })
  }

  download(hash: string) {
    this.optimizationService.download(hash).subscribe(result => {
      this.snackBar.open("Your download is available", null, {
        duration: 2000
      });
      const blob = new Blob([result], {
        type: 'application/zip'
      });
      const url = window.URL.createObjectURL(blob);
      window.open(url);
      OptimizationService.clearOptimizationInfo();
    });
  }

  logout() {
    this.userService.logout();
    this.router.navigate(['/login']).then(r => {
      setTimeout(() => {
        OptimizationService.source.close();
        this.userService.logout();
      }, 1000);
    });
  }

  isValid() {
    return this.optimizationDto.objectiveFunctions.length > 0;
  }
<<<<<<< HEAD


  openDialog() {
    const componentRef = this.dialogService.open(InserirPlaJanelaComponent);
    componentRef.instance.setComponentRef(componentRef);
  
    // Monitora quando o diálogo é fechado para atualizar os dados
    componentRef.onDestroy(() => {
      this.updateSelectedFunctions();  // Atualiza os dados quando o diálogo fechar
    });
  }
  
=======
>>>>>>> df67688fc955e17143ab740d5656f0d0c8cc5b47
}
