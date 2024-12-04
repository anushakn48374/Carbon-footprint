import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent  implements OnInit {

  constructor(private router: Router,private http:HttpClient,private spiner: NgxSpinnerService) {}

  loginForm!: FormGroup

  ngOnInit(){
    this.loginForm = new FormGroup({
      name: new FormControl(''),
      email:new FormControl(''),
      mobileNumber :new FormControl('')
    });
  }

  createDetails(){
    const userDetails={
      "user_name":this.loginForm.get('name')?.value,
      "email_id":this.loginForm.get('email')?.value,
      "mobile_no":this.loginForm.get('mobileNumber')?.value
    }
    return userDetails;
  }

  userLink="http://localhost:8083/api/user/users"

  getLogin(){
    
    this.spiner.show()
    if (this.loginForm.valid) {
      const username = this.loginForm.value.name;
      console.log("Form Data:", this.loginForm.value);

      const details = this.createDetails(); // Assuming this is a method to create the details

      console.log(details);

      this.http.post(this.userLink, details).subscribe(
        (reply: any) => {
          console.log(reply, "this is the reply");
            this.router.navigate(['/form', username]);
        },
     
      )
      this.spiner.hide()
    }}



}
