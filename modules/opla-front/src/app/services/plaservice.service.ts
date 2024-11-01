import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PersistenceService} from "./persistence.service";
import {Observable} from "rxjs";
import {UserService} from "./user.service";
import {catchError} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PLAService extends PersistenceService {
  private apiUrl = 'http://localhost:8080/opla';

  constructor(http: HttpClient) {
    super('pla', http); 
  }

  uploadFile(file: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);

    return this.http.post(`${UserService.baseUrl}/${this.collection}/upload`, formData)
      .pipe(catchError(this.errorHandler));
  }
}
