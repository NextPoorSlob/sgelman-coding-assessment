import React, { useState, useEffect } from "react";
import ProductLine from "./ProductLine";
import { fetchProducts } from "../services/DataService";
import Product from "../models/Product";

function ProductList() {
    const [products, setProducts] = useState([]);
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        const loadData = async () => {
            try {
                const json = await fetchProducts();
                const results = json.map(p => Object.assign(new Product(), p));
                setProducts(results);
            } catch (err) {
                setError(err);
            } finally {
                setIsLoading(false);
            }
        };

        loadData();
    }, []);

    if (isLoading) return <div>Loading...</div>;
    if (error) return <div>Error: {error.message}</div>;

    return (
        <div>
            <h2>Product List</h2>
            <ol>
                {products.map((product) => (
                    <ProductLine key={product.productId} name={product.productName}/>
                ))}
            </ol>
        </div>
    );
}

export default ProductList;
