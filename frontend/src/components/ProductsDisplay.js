import React from "react";

const productsBase = [
    { id: 1, name: "Product A" },
    { id: 2, name: "Product B" },
    { id: 3, name: "Product C" },
];

const {products, setProducts} = React.useState(productsBase);

const ProductsDisplay = () => {
    return (
        products.map((product) => (
            <ProductCard key={product.id} name={product.name} />
        ))
    )
}

const ProductCard = (props) => {

    const {inEditMode, setInEditMode} = React.useState(false);
    const {newName, setNewName} = React.useState('');

    const handleEdit = (id) => {

    }

    return (
        <>
        <div className="product-card">
            {(inEditMode)
                ? <input value={props.name} on />
                : <p>{props.name}</p> }
        </div>

        <button onClick={() => handleEdit(props.id)}>Edit</button>
        </>
    );
}

export default ProductsDisplay;