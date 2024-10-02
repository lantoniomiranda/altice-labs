import { Component } from '@angular/core';
import { ApiService } from './app.service';

@Component({
  selector: 'app-number-input',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class NumberInputComponent {
  inputNumber: number | null = null;
  apiResult: { n: number; result: number } | null = null;
  errorMessage: string | null = null;

  constructor(private apiService: ApiService) {}

  onSubmit() {
    if (this.inputNumber !== null && this.inputNumber >= 0) {
      this.apiService.calculate(this.inputNumber).subscribe(
        (response) => {
          this.apiResult = response;
          this.errorMessage = null;
        },
        (error) => {
          console.error('API call error:', error);
          this.errorMessage = 'Error calling the API';
          this.apiResult = null;
        }
      );
    } else {
      this.errorMessage = 'Please enter a positive number';
      this.apiResult = null;
    }
  }
}
