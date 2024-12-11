document.addEventListener('DOMContentLoaded', function() {
    const addListingButton = document.getElementById('add-listing-button');
    const addListingForm = document.getElementById('add-listing-form');

    // Show the add listing form when the button is clicked
    addListingButton.addEventListener('click', function() {
        addListingForm.style.display = 'block';
    });

    // Handle form submission
    addListingForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData(addListingForm);
        const listingData = Object.fromEntries(formData.entries());

        const queryString = new URLSearchParams(listingData).toString();

        fetch('/api/listings/create?' + queryString, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        })
        .then(response => {
            if (response.ok) {
                alert('Listing added successfully!');
                window.location.reload();
            } else {
                alert('Failed to add listing.');
            }
        })
        .catch(error => console.error('Error adding listing:', error));
    });
});