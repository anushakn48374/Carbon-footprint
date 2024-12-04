import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IntergateService {
 

  constructor(private http:HttpClient) { }

  private distanceUrl="https://maps.gomaps.pro/maps/api/distancematrix/json?"


  public distanceMatrix(prams:HttpParams){
    console.log(this.distanceUrl+{prams})
    return this.http.get(this.distanceUrl+{prams})
  
  }
}
