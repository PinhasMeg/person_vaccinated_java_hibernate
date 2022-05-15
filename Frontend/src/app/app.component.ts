import { Component, OnInit, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Person } from './persons.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  count=0;
  title = 'myPersons';
   totalAngularPackages: any;
   personsVaccinated:Person[]=[]

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<any>('http://localhost:8082/api/v1/persons').subscribe(data => {
      this.personsVaccinated = data;
      console.log(this.personsVaccinated)
  })
  }


  n(){

  this.count+=1
  return this.count;

  }

}
