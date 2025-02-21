import { Component, inject, signal, WritableSignal } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../common/product';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CurrencyPipe],
  templateUrl: './product-list-grid.component.html',
  styleUrl: './product-list.component.css',
})
export class ProductListComponent {
  products: WritableSignal<Product[]> = signal([]);

  private readonly productService: ProductService = inject(ProductService);

  ngOnInit(): void {
    this.productService.getProductList().subscribe((data: Product[]) => {
      this.products.set(data);
    });
  }
}
