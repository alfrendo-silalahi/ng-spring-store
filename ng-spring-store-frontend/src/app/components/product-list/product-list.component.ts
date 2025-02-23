import { Component, inject, signal, WritableSignal } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../common/product';
import { CurrencyPipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CurrencyPipe],
  templateUrl: './product-list-grid.component.html',
  styleUrl: './product-list.component.css',
})
export class ProductListComponent {
  private readonly productService: ProductService = inject(ProductService);
  private readonly route: ActivatedRoute = inject(ActivatedRoute);

  products: WritableSignal<Product[]> = signal([]);
  categoryId: WritableSignal<number> = signal(1);

  ngOnInit(): void {
    this.route.paramMap.subscribe((): void => this.getProductList());
  }

  getProductList(): void {
    this.categoryId.set(
      parseInt(this.route.snapshot.paramMap.get('id') ?? '1')
    );
    this.productService
      .getProductList(this.categoryId())
      .subscribe((data: Product[]): void => this.products.set(data));
  }
}
