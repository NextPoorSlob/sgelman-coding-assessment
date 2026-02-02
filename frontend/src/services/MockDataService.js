const Products = [
  { id: 1, name: 'Laptop'},
  { id: 2, name: 'Smartphone'},
  { id: 3, name: 'Tablet'},
];

export function fetchProducts() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(Products);
    }, 500);
  })}

export default fetchProducts();
