
export async function fetchBooks(endpoint) {
    try{
        const response = await fetch(endpoint);
        if(!response.ok){
            throw new Error(response.statusText);
        }
        const books = await response.json();
        return books;

} catch (error) {
    console.log(error);
    return [];
}