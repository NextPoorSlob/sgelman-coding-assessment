const API_URL = "http://localhost:8080/product";

export async function fetchProducts() {
    const response = await fetch(API_URL + "/all");
    if (!response.ok) {
        throw new Error("Network response was not ok");
    }
    return await response.json();
}

export async function addProduct(product) {
    console.log(product);
    const response = await fetch(API_URL + "/add", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(product)
    });
    if (!response.ok) {
        throw new Error("Network response: " + response.status);
    }
    return response;
}
