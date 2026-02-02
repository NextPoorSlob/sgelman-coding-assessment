import React from "react";
import {addProduct} from "../services/DataService";
import Product from "../models/Product";

const AddProduct = props => {

    const [inputValue, setInputValue] = React.useState('');

    const handleAddItem = async () => {
        try {
            const newProduct = new Product({productId: null, productName: inputValue});
            await addProduct(newProduct);
            setInputValue('');
            props.onClick();
        } catch (err) {
            props.onError.setError(err);
        }
    }

    return (<div>
            <input
                type="text"
                value={inputValue}
                onChange={(e) => setInputValue(e.target.value)}
            />
            <button onClick={handleAddItem}>Add Item</button>
        </div>
    );
}

export default AddProduct;