import { LevelResource } from "./level.resource";
import { ProductResource } from "./product.resource";

export class QuotationResource {
    public shop: string;
    public schoolName: string;
    public level: LevelResource;
    public products: Array<ProductResource>;
    public totalPrice: number;
}