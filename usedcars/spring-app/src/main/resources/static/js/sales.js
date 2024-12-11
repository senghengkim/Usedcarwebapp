document.addEventListener('DOMContentLoaded', function() {
    const addSaleButton = document.getElementById('add-sale-button');
    const addSaleForm = document.getElementById('add-sale-form');

    // Show the add sale form when the button is clicked
    addSaleButton.addEventListener('click', function() {
        addSaleForm.style.display = 'block';
    });

    // Handle sale form submission
    addSaleForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData(addSaleForm);
        const saleData = Object.fromEntries(formData.entries());

        const queryString = new URLSearchParams(saleData).toString();

        fetch('/api/sales/createCustom?' + queryString, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        })
        .then(response => {
            if (response.ok) {
                alert('Sale added successfully!');
                window.location.reload();
            } else {
                alert('Failed to add sale.');
            }
        })
        .catch(error => console.error('Error adding sale:', error));
    });
});