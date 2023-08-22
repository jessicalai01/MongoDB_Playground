document.addEventListener("DOMContentLoaded",
    () => {fetchBooks();

async function fetchBooks(){
    const response = await fetch(
    "http://localhost:8081/book/myList",
    {
    method: 'GET',
    headers: {
              'Content-Type': 'text/javascript'},
    body: null});
    const books = await response.json();
    const bookTable = document.getElementById("book-table")
    console.log(books)

    books.forEach(book => {
        const row = document.createElement("tr");
        const titleCell = document.createElement("td");
        titleCell.innerText = book.title;
        row.appendChild(titleCell);

        const authorCell = document.createElement("td");
        authorCell.innerText = book.author;
        row.appendChild(authorCell);

        const ratingCell = document.createElement("td");
        ratingCell.innerText = book.rating;
        row.appendChild(ratingCell);

        privateBookTable.appendChild(row);
    }

});