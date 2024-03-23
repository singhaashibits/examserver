import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData={
    username:"",
    password:""
  };

  constructor(private login:LoginService) { }

  ngOnInit(): void {
  }

  formSubmit(){
    console.log("login form submitted");

    if(this.loginData.username.trim()=="" || this.loginData.username==null) {
      alert("username is required");
      return;
    }

    if(this.loginData.password.trim()=="" || this.loginData.password==null) {
      alert("password is required");
      return;
    }

    this.login.generateToken(this.loginData).subscribe((data:any)=>{
      console.log("success");
      console.log(data);

      //login...

      this.login.loginUser(data.token);
      this.login.getCurrentUser().subscribe((user:any)=>{
        this.login.setUser(user);
        console.log(user);

        //redirect..admin
        //redirect..normal
        if(this.login.getUserRole()=="ADMIN"){
            //admin dashboard
            window.location.href="/admin";
        }
        else if( this.login.getUserRole()=="NORMAL"){
           //user dashboard 
           window.location.href="/user-dashboard";
        }
        else{
          this.login.logOut();
          
        }
      });
    },
    (error)=>{
      console.log(error);
      console.log("error");
  
    }
    );
  }

 
}
