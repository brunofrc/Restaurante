import { Component, OnInit } from '@angular/core';
import { Restaurante } from '../entity/restaurante';
import { RestauranteService } from 'app/restaurante/restaurante.service';

@Component({
  selector: 'app-restaurante',
  templateUrl: './restaurante.component.html',
  styleUrls: ['./restaurante.component.css']
})
export class RestauranteComponent implements OnInit {
  restaurantes: Array<Restaurante>;
  restauranteSearch = new Restaurante();
  newRestaurante = new Restaurante();
  msg:string;
  constructor(private restauranteService: RestauranteService) { }

  ngOnInit() {
    this.readAll();
  }
  pesquisarRestaurante(restaurante: Restaurante) {
    this.restauranteService.readByExample(restaurante)
      .then(
        data => {
        this.restaurantes = data;
        }
      );
  }
  readAll(){
    this.restauranteService.readAll()
    .then(
      data => {
      this.restaurantes = data;
      }
    );
  }
  create(restaurante: Restaurante) {
    this.restauranteService.create(restaurante)
      .then(
        data => {
        this.newRestaurante = data[1];
        this.msg = data[2];
        }
      );
  }
  update(restaurante: Restaurante) {
    this.restauranteService.update(restaurante)
      .then(
        data => {
        this.newRestaurante = data[1];
        this.msg = data[2];
        }
      );
  }
}
