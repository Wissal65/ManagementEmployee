const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
    container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
    container.classList.remove("sign-up-mode");
});
document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector('.sign-in-form');

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent default form submission

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const data = {
            username: username,
            password: password
        };

        fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    // If authentication succeeds, redirect to the dashboard page
                    window.location.href = '/dashboard';
                } else {
                    // If authentication fails, handle error (optional)
                    console.error('Authentication failed');
                }
            })
            .catch(error => {
                // Handle error
                console.error('Error:', error);
            });
    });
});
