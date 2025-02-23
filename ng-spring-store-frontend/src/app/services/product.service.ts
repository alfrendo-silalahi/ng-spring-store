import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private readonly baseUrl: string = 'http://localhost:8080/api/v1/products';

  private readonly httpClient: HttpClient = inject(HttpClient);

  getProductList(categoryId: number): Observable<Product[]> {
    return this.httpClient.get<Product[]>(
      `${this.baseUrl}?categoryId=${categoryId}`,
    );
  }
}
