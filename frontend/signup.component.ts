import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  public user={
    username:"",
    password:"",
    firstname:"",
    lastname:"",
    email:"",
    phone:""

  };

  formSubmit(){
   
    console.log(this.user);
    if(this.user.username=="" || this.user.username==null) {
      alert("username is required!!");
      return;
    }

    this.userService.addUser(this.user).subscribe(
      (data)=>{
        console.log(data);
        alert("success");
      },
      (error)=>{
        console.log(error);
        alert("Something went wrong");
      }
    )
  }

}
