import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private url:string="http://localhost:8080/sendEmail"

  constructor(private http:HttpClient) { }

  sendEmail(data: any){

    return this.http.post('${this.url}',data);
  }
}
