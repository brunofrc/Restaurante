import { Injectable } from "@angular/core";
import { Http } from "@angular/http";
import { Restaurante } from "../entity/restaurante";
import { Observable } from 'rxjs';
import { URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import 'rxjs/Rx'; 

@Injectable()
export class RestauranteService {

    restURL = "http://localhost:9999/api/restaurante";

    constructor(private http: Http) {

    }
   readByExample(restaurante:Restaurante): Promise<any> {
        return this.http.post(this.restURL + "/readByExample", restaurante)
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    create(restaurante:Restaurante): Promise<any> {
        return this.http.post(this.restURL + "/create",restaurante)
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    readAll(): Promise<any> {
        return this.http.get(this.restURL + "/readAll")
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    update(restaurante:Restaurante): Promise<any> {
        return this.http.put(this.restURL + "/update",restaurante)
        .toPromise()
        .then(res => res.json())
        .catch(this.handleError);
    }
    

    private handleError(error: any): Promise<any> {
       return Promise.reject(error.message || error);
	}
}
