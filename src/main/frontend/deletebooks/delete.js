
document.addEventListener("DOMContentLoaded", () => {
    // Add event listener to a form submission
    const deleteForm = document.getElementById("delete-form");
    deleteForm.addEventListener("submit", async (event) => {
    event.preventDefault();
    const titleToDelete = document.getElementById("title-delete-input").value;
    const bookToDelete = {
        title: titleToDelete
    };
    try{
        const response = await fetch("http://localhost:8081/book/delete", {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(bookToDelete)
            });
            if (response.ok) {
                // Clear form fields and perform any additional actions
                deleteForm.reset();
                // You can update the book list or show a success message here
                console.log("Book deleted");
            } else {
                console.log("Error deleting book");
            }
        } catch (error) {
            console.log(error);
        }
    });

 });
