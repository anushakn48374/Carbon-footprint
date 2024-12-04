import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { NgxSpinnerService } from 'ngx-spinner';
import { IntergateService } from './intergate.service';
import { ToastrService } from 'ngx-toastr'; 
import { ActivatedRoute, Route, Router } from '@angular/router';
import { catchError, Observable, of, tap } from 'rxjs';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent  implements OnInit {
[x: string]: any;
  @ViewChild('fileInput') fileInput!: ElementRef;
  
  constructor(
    private http:HttpClient ,private route : ActivatedRoute,
    private spinner:NgxSpinnerService,
    private toastr: ToastrService,
    private router:Router
             
  ) {}
  
  
  username: string | null = '';
  travelForm!:FormGroup

  selectedTransport: string = ''; 


  ngOnInit() {

    this.travelForm = new FormGroup({
      from: new FormControl(''),
      to: new FormControl(''),
    
      // modeOfTransport : new FormControl('')
    });

    console.log("Initial Selected Transport Mode:", this.selectedTransport);

    this.route.paramMap.subscribe(params => {
      this.username = params.get('username');
      console.log('Username passed: ', this.username);
      this.toastr.success("Login Successfully "+  this.username)
    });
  
  
  
  }
  showSuccess() {
    this.toastr.success('This is a success message', 'Success', {
      timeOut: 3000, // Display for 3 seconds
      positionClass: 'toast-top-right',
      closeButton: true
    });
  }
  

  logSelectedValue(event: any) {
    this.selectedTransport = event.detail.value;  // Get the selected value from the event
    console.log("Selected Transport Mode:", this.selectedTransport);  // Log the value
  }



  //distanceUrl="https://maps.gomaps.pro/maps/api/distancematrix/json?"
  /* tripapiUrl="http://localhost:8083/api/trip/trips"
  distanceNumber:any
  distance:any
  calculate(){
    
    console.log(this.travelForm.value)
    const params = this.createParameter();
   
    this.http.get(this.distanceUrl,{params}).subscribe((response:any)=>{
      this.spinner.show()
      console.log("the resposne",response)

if (response && response.rows && response.rows.length > 0) {
  const row = response.rows[0]; // Get the first row
  if (row.elements && row.elements.length > 0) {
    const element = row.elements[0]; // Get the first element
    if (element.distance) {
      this.distance = element.distance.text; // Get the distance string (e.g., "38.7 km")

      // Remove ' km' and parse the number
      this.distanceNumber = parseFloat(this.distance.replace(' km', '').trim());
      console.log("The distance (numeric) =", this.distanceNumber); // This will log only the number (38.7)

      // Create the JSON for the trip
      const createJson = this.createJson();
      console.log("The trip JSON is", createJson);

      // Make the second API call (POST) with the trip data
      this.http.post(this.tripapiUrl, createJson).subscribe(
        (tripResponse) => {
          console.log("Trip reply", tripResponse);
          this.toastr.success("Trip Calculated Successfully")
          // Hide the spinner after both API calls are completed
          this.spinner.hide();
        },
        (tripError) => {
          console.error("Error in trip API:", tripError);

          // Show an error toastr message for trip API error
          this.toastr.error('Failed to create the trip. Please try again later.', 'Error');

          // Hide the spinner even in case of error
          this.spinner.hide();
        }
      );
    } else {
      console.error('Distance not found');
      this.toastr.error('Distance not found in the response. Please check the input.', 'Error');
      this.spinner.hide(); // Hide spinner if no distance is found
    }
  } else {
    console.error('No elements found in the row');
    this.toastr.error('No elements found in the response. Please try again later.', 'Error');
    this.spinner.hide(); // Hide spinner if no elements are found
  }
} else {
  console.error('No rows found in the response');
  this.toastr.error('No rows found in the response. Please check the data.', 'Error');
  this.spinner.hide(); // Hide spinner if no rows are found
}
},
(error) => {
console.error('Error fetching distance:', error);
// Show an error toastr message for the distance API error
this.toastr.error('Failed to fetch distance data. Please try again later.', 'Error');
this.spinner.hide(); // Hide spinner if the first API fails
}
    )        
  } instead of distance url use random function */


 tripapiUrl = "http://localhost:8083/api/trip/trips"; // Trip API URL
distanceNumber: any; // Store numeric distance
distance: any; // Store formatted distance string

calculate() {
  console.log(this.travelForm.value);
  const params = this.createParameter();

  // Simulate random distance generation between 20 and 40
  this.distanceNumber = Math.floor(Math.random() * (40 - 20 + 1)) + 20; // Generate random distance
  this.distance = `${this.distanceNumber} km`; // Format as a string to simulate API response

  console.log("Simulated Distance:", this.distance);

  // Create the JSON for the trip
  const createJson = this.createJson();
  console.log("The trip JSON is:", createJson);

  // Make the second API call (POST) with the trip data
  this.http.post(this.tripapiUrl, createJson).subscribe(
    (tripResponse) => {
      console.log("Trip reply:", tripResponse);
      this.toastr.success("Trip Calculated Successfully");
      // Hide the spinner after the API call is completed
      this.spinner.hide();
    },
    (tripError) => {
      console.error("Error in trip API:", tripError);
      // Show an error toastr message for trip API error
      this.toastr.error("Failed to create the trip. Please try again later.", "Error");
      // Hide the spinner in case of error
      this.spinner.hide();
    }
  );
}

  createJson(){
    const json = {
      "user_name":this.username,
      "distance_travel":this.distanceNumber,
      "trans_mode":this.selectedTransport
    }
    return json
  }

  createParameter(){
    let params = new HttpParams();

    params = params.append('origins', this.travelForm.get('from')?.value);
    params = params.append('destinations', this.travelForm.get('to')?.value);
    params = params.append('key', "AlzaSyrASbm9-tcMMJAI04T_y7Q4_-2PjXcxJ0Y");
  
   
    return params;
  }

selectedImage:any
pythonapi = 'https://busimageparsing.onrender.com/api/upload'; // Your API URL

onFileSelected(event: Event) {
  const fileInput = event.target as HTMLInputElement;
  this.selectedImage = fileInput.files?.[0] || null; // Get the selected file

  if (this.selectedImage) {
    console.log('File selected:', this.selectedImage);
    
    // Optionally, read the file as a base64 string if you want to preview or use it
    const reader = new FileReader();
    reader.readAsDataURL(this.selectedImage); // Read the file as a Data URL (base64)
  }
}

// Method to trigger the file input click event
uploadFile() {

if(this.selectedImage){
  const file = this.selectedImage
  const formData = new FormData;

  formData.append('file',file)

 this.http.post("https://busimageparsing.onrender.com/api/upload",file).subscribe((res:any)=>{
    console.log("the data ", res)
   },(error)=>{
     console.log(error )
   }
)


  this.toastr.info("Ticket is not Matching Todays Date")
}  

}






  leaderboardRoute(){
    console.log("button")
    this.router.navigate(['/leaderboard',this.username]);
   
  }

}
