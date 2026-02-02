const API_URL = "http://localhost:8080/product/all";

export async function fetchProducts() {
  const response = await fetch(API_URL);
  if (!response.ok) {
    throw new Error("Network response was not ok");
  }
  return await response.json();
}
