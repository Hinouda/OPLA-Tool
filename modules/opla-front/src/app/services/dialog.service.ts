// import { Injectable, ApplicationRef, Injector, ComponentRef, Type, ViewContainerRef } from '@angular/core';

// @Injectable({
//   providedIn: 'root',
// })
// export class DialogService {
//   constructor(
//     private appRef: ApplicationRef,
//     private injector: Injector
//   ) {}

//   open<T>(component: Type<T>, viewContainerRef: ViewContainerRef, data?: any): ComponentRef<T> {
//     // Directly create the component without resolving the factory
//     const componentRef = viewContainerRef.createComponent(component, { injector: this.injector });

//     if (data) {
//       Object.assign(componentRef.instance, data);
//     }

//     return componentRef;
//   }

//   close(componentRef: ComponentRef<any>) {
//     this.appRef.detachView(componentRef.hostView);
//     componentRef.destroy();
//   }
// }
import { Injectable, ComponentFactoryResolver, ApplicationRef, Injector, EmbeddedViewRef, ComponentRef } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DialogService {
  constructor(
    private componentFactoryResolver: ComponentFactoryResolver,
    private appRef: ApplicationRef,
    private injector: Injector
  ) {}

  open(component: any, data?: any): ComponentRef<any> {
    const componentRef = this.componentFactoryResolver.resolveComponentFactory(component).create(this.injector);

    if (data) {
      Object.assign(componentRef.instance, data);
    }

    this.appRef.attachView(componentRef.hostView);

    const domElem = (componentRef.hostView as EmbeddedViewRef<any>).rootNodes[0] as HTMLElement;
    document.body.appendChild(domElem);

    return componentRef;
  }

  close(componentRef: ComponentRef<any>) {
    this.appRef.detachView(componentRef.hostView);
    componentRef.destroy();
  }
}
