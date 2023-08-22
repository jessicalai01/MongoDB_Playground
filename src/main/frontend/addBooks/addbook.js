document.addEventListener("DOMContentLoaded", () => {
    // Add event listener to a form submission
    const form = document.getElementById("book-form");
    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        // Get form data
        const author = document.getElementById("author-input").value;
        const title = document.getElementById("title-input").value;
        const rating = parseFloat(document.getElementById("rating-input").value);

        // Create a new book object
        const newBook = {
            author: author,
            title: title,
            rating: rating
        };

        // Send POST request to save the new book
        const response = await fetch("http://localhost:8081/book/save", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newBook)
        });

        if (response.ok) {
            // Clear form fields and perform any additional actions
            form.reset();
            // You can update the book list or show a success message here
        }
    });
});