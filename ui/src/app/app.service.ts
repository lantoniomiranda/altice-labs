import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface ApiResponse {
  n: number;
  result: number;
}

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/labseq/'; 
  constructor(private http: HttpClient) {}

  calculate(value: number): Observable<ApiResponse> {
    const url = `${this.apiUrl}${value}`;
    return this.http.get<ApiResponse>(url); 
  }
}
