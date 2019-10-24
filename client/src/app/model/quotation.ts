import { Level } from "./level";
import { Product } from "./product";

export class Quotation {
    public shop: string;
    public schoolName: string;
    public level: Level;
    public products: Array<Product>;
    public totalPrice: number;
}