import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { RestauranteComponent } from './restaurante/restaurante.component';
import { PratoComponent } from './prato/prato.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import {Routes, RouterModule, Router} from "@angular/router";
import { RestauranteService } from './restaurante/restaurante.service';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', redirectTo: 'home'},
  {path: 'restaurante', component: RestauranteComponent},
  {path: 'prato', component: PratoComponent},
  {path: '**', component: HomeComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    RestauranteComponent,
    PratoComponent,
    HeaderComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(routes, {useHash: true})
  ],
  providers: [RestauranteService],
  bootstrap: [AppComponent]
})
export class AppModule { }