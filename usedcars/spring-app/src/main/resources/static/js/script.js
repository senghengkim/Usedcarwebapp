document.addEventListener('DOMContentLoaded', function() {
    const addCarButton = document.getElementById('add-car-button');
    const addCarForm = document.getElementById('add-car-form');
    const updateCarButton = document.getElementById('update-car-button');
    const updateCarForm = document.getElementById('update-car-form');
    const updateCarId = document.getElementById('update-car-id');
    const updateMake = document.getElementById('update-make');
    const updateModel = document.getElementById('update-model');
    const updateYear = document.getElementById('update-year');
    const updateColor = document.getElementById('update-color');
    const updateMileage = document.getElementById('update-mileage');
    const updateVin = document.getElementById('update-vin');
    const updateStatus = document.getElementById('update-status');
    const updatePrice = document.getElementById('update-price');
    const deleteCarButton = document.getElementById('delete-car-button');
    const deleteCarForm = document.getElementById('delete-car-form');
    const deleteCarId = document.getElementById('delete-car-id');

    // Show the add car form when the button is clicked
    addCarButton.addEventListener('click', function() {
        addCarForm.style.display = 'block';
    });

    // Handle add car form submission
    addCarForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData(addCarForm);
        const carData = Object.fromEntries(formData.entries());

        fetch('/api/cars', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(carData)
        })
        .then(response => {
            if (response.ok) {
                alert('Car added successfully!');
                window.location.reload();
            } else {
                alert('Failed to add car.');
            }
        })
        .catch(error => console.error('Error adding car:', error));
    });

    // Show the update car form when the button is clicked
    updateCarButton.addEventListener('click', function() {
        updateCarForm.style.display = 'block';
    });

    // Handle update car form submission
    updateCarForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const carId = updateCarId.value;
        fetch(`/api/cars/${carId}`)
            .then(response => response.json())
            .then(car => {
                updateMake.value = car.make;
                updateModel.value = car.model;
                updateYear.value = car.year;
                updateColor.value = car.color;
                updateMileage.value = car.mileage;
                updateVin.value = car.vin;
                updateStatus.value = car.status;
                updatePrice.value = car.price;
            })
            .catch(error => console.error('Error fetching car:', error));

        const formData = new FormData(updateCarForm);
        const carData = Object.fromEntries(formData.entries());

        fetch(`/api/cars/${carData.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(carData)
        })
        .then(response => {
            if (response.ok) {
                alert('Car updated successfully!');
                window.location.reload();
            } else {
                alert('Failed to update car.');
            }
        })
        .catch(error => console.error('Error updating car:', error));
    });

    // Show the delete car form when the button is clicked
    deleteCarButton.addEventListener('click', function() {
        deleteCarForm.style.display = 'block';
    });

    // Handle delete car form submission
    deleteCarForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const carId = deleteCarId.value;

        fetch(`/api/cars/${carId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            if (response.ok) {
                alert('Car deleted successfully!');
                window.location.reload();
            } else {
                alert('Failed to delete car.');
            }
        })
        .catch(error => console.error('Error deleting car:', error));
    });
});