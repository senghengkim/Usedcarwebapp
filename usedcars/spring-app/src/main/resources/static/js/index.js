document.addEventListener('DOMContentLoaded', function() {
    const makeSelect = document.getElementById('make');
    const modelSelect = document.getElementById('model');
    const minPriceSlider = document.getElementById('min-price');
    const maxPriceSlider = document.getElementById('max-price');
    const minPriceValue = document.getElementById('min-price-value');
    const maxPriceValue = document.getElementById('max-price-value');

    // Fetch and populate makes
    fetch('/api/cars/makes')
        .then(response => response.json())
        .then(makes => {
            const allMakesOption = document.createElement('option');
            allMakesOption.value = "";
            allMakesOption.textContent = "All Makes";
            makeSelect.appendChild(allMakesOption);

            makes.forEach(make => {
                const option = document.createElement('option');
                option.value = make;
                option.textContent = make;
                if (make === makeSelect.getAttribute('value')) {
                    option.selected = true;
                }
                makeSelect.appendChild(option);
            });

            // Trigger change event to populate models if a make is selected
            makeSelect.dispatchEvent(new Event('change'));
        })
        .catch(error => console.error('Error fetching makes:', error));

    // Event listener for make selection
    makeSelect.addEventListener('change', function() {
        const selectedMake = makeSelect.value;

        // Clear existing model options
        modelSelect.innerHTML = '<option value="">All Models</option>';

        if (selectedMake) {
            // Fetch and populate models based on selected make
            fetch(`/api/cars/models/${selectedMake}`)
                .then(response => response.json())
                .then(models => {
                    models.forEach(model => {
                        const option = document.createElement('option');
                        option.value = model;
                        option.textContent = model;
                        if (model === modelSelect.getAttribute('value')) {
                            option.selected = true;
                        }
                        modelSelect.appendChild(option);
                    });
                })
                .catch(error => console.error('Error fetching models:', error));
        } else {
            // Fetch and populate all models if no make is selected
            fetch('/api/cars/models')
                .then(response => response.json())
                .then(models => {
                    models.forEach(model => {
                        const option = document.createElement('option');
                        option.value = model;
                        option.textContent = model;
                        if (model === modelSelect.getAttribute('value')) {
                            option.selected = true;
                        }
                        modelSelect.appendChild(option);
                    });
                })
                .catch(error => console.error('Error fetching models:', error));
        }
    });

    // Update displayed min price value
    minPriceSlider.addEventListener('input', function() {
        minPriceValue.textContent = minPriceSlider.value;
    });

    // Update displayed max price value
    maxPriceSlider.addEventListener('input', function() {
        maxPriceValue.textContent = maxPriceSlider.value;
    });

    // Set initial values for min and max price sliders
    minPriceValue.textContent = minPriceSlider.value;
    maxPriceValue.textContent = maxPriceSlider.value;
});