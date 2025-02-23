import { Component } from '@angular/core';
import { ProductListComponent } from './components/product-list/product-list.component';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  imports: [RouterOutlet, RouterLink],
})
export class AppComponent {}
