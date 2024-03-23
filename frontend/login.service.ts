import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  //current user which is logged in
  public getCurrentUser(){
    return this.http.get("http://localhost:8080/current-user");
  }

  public generateToken(loginData:any){

    return this.http.post("http://localhost:8080/generate-token",loginData);

  }

  public loginUser(token:any) {

    localStorage.setItem("token",token);
    return true;
  }

  public isLoggedin(){
    let tokenStr=localStorage.getItem("token");
    if(tokenStr==undefined || tokenStr=="" || tokenStr==null){
      return false;
    }else{
      return true;
    }
  }

  public logOut(){
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
    return true;
  }

  public getToken(){
    return localStorage.getItem("token");
  }

  public setUser(user: any){
    localStorage.setItem("user",JSON.stringify(user));
  }

  public getUser(){
    let userStr=localStorage.getItem("user");
    if(userStr!=null){
      return JSON.parse(userStr);
    }else{
      this.logOut();
      return null;
    }
  }

  public getUserRole(){
    let user=this.getUser();
    return user.authorities[0].authority;
  }
}
