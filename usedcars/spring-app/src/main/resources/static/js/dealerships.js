document.addEventListener('DOMContentLoaded', function() {
    const addDealershipButton = document.getElementById('add-dealership-button');
    const addDealershipForm = document.getElementById('add-dealership-form');

    // Show the add dealership form when the button is clicked
    addDealershipButton.addEventListener('click', function() {
        addDealershipForm.style.display = 'block';
    });

    // Handle dealership form submission
    addDealershipForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData(addDealershipForm);
        const dealershipData = Object.fromEntries(formData.entries());

        fetch('/api/dealerships/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dealershipData)
        })
        .then(response => {
            if (response.ok) {
                alert('Dealership added successfully!');
                window.location.reload();
            } else {
                alert('Failed to add dealership.');
            }
        })
        .catch(error => console.error('Error adding dealership:', error));
    });
});