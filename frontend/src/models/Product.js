export default class Product {
    constructor({ productId = null, productName = ""} = {}) {
        this.productId = productId;
        this.productName = productName;
    }

    // convert a plain object to a Product instance
    static fromJSON(obj) {
        return new Product(obj || {});
    }

    // convert an array of plain objects to Product instances
    static fromArray(arr = []) {
        return arr.map(Product.fromJSON);
    }

    // optional: serialize back to plain object
    toJSON() {
        return { productId: this.productId, productName: this.productName };
    }
}
