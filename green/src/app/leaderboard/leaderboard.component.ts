import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.scss'],
})
export class LeaderboardComponent  implements OnInit {
breadCrumbItems: any;
 constructor(private http:HttpClient,private route:ActivatedRoute,
             private router:Router
 ) { }

 leaderboardUrl= "http://localhost:8083/api/board/leaderboard"
 leaderboardUrlWeekly= "http://localhost:8083/api/board/leaderboard/weekly"
 leaderBoardData:any
 totalLeadPoints: number=0;
 profileImages: string[] = [
  'assets/profile1.png',
  'assets/profile2.png',
  'assets/profile3.png',
  'assets/profile4.png',
  'assets/profile5.png'
];
username: string | null = '';
ngOnInit():void {

    this.route.paramMap.subscribe(params => {
      this.username = params.get('username');
      console.log('Username passed leaderboard: ', this.username);
    });

  this.board();

  this.boardWeekly();


  }


  board(){
    this.http.get(this.leaderboardUrl).subscribe(
      (response) => {
        this.leaderBoardData=response
        this.assignRandomProfileImages();
        this.convertEmissionsToPercentage();
        console.log(this.leaderBoardData)
        console.log("ALL");
         const totalLeadPoints = this.calculateTotalLeadPoints();
      console.log('Total Leadpoints:', totalLeadPoints);
      },
      
      (error) => {
        console.error('Error occurred:', error); // Log any errors that occur
      
      }
    );
  }
  calculateTotalLeadPoints() {
 let totalLeadPoints = 0;

this.leaderBoardData.forEach((user: { lead_points: number }) => {
  if (typeof user.lead_points === 'number' && !isNaN(user.lead_points)) {
    totalLeadPoints += user.lead_points; // Add each user's lead_points to the total
  } else {
    console.warn('Invalid leadpoints value for user:', user);
  }
});

console.log('Total Leadpoints:', totalLeadPoints);
}

  boardWeekly(){
    this.http.get(this.leaderboardUrlWeekly).subscribe(
      (response) => {
        this.leaderBoardData=response
        this.assignRandomProfileImages();
        this.convertEmissionsToPercentage();
        console.log(this.leaderBoardData)
        console.log("Weekly");
      },
      (error) => {
        console.error('Error occurred:', error); // Log any errors that occur
      
      }
    );
  }
  
  assignRandomProfileImages(): void {
    // Assign a random profile image to each user
    this.leaderBoardData.forEach((user: { profileImage: string; }) => {
      const randomIndex = Math.floor(Math.random() * this.profileImages.length);
      user.profileImage = this.profileImages[randomIndex]; // Assign the random image URL
    });
  }

  convertEmissionsToPercentage(): void {
    // Find the maximum carbon emission in the leaderboard data
    const maxEmission = Math.max(...this.leaderBoardData.map((user: { carbon_emission: string; }) => parseFloat(user.carbon_emission.replace('gm', '').trim())));
    
    // Convert each user's emission to a percentage
    this.leaderBoardData.forEach((user: { carbon_emission: string; carbon_emission_percentage: string; }) => {
      const emissionInGrams = parseFloat(user.carbon_emission.replace('gm', '').trim());
      // Add percentage to user data
    });
  }

back(){
  console.log("Button")
  this.router.navigate(['/form',this.username]);
}
}
