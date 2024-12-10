// // script.js

// // List of cars and their image URLs
// const cars = [
//     { name: 'Toyota Camry', imageUrl: 'images/toyota_camry.jpg' },
//     { name: 'Honda Accord', imageUrl: 'images/honda_accord.jpg' },
//     { name: 'Ford Mustang', imageUrl: 'images/ford_mustang.jpg' },
//     // Add more cars as needed
// ];

// // Function to display cars
// function displayCars() {
//     const container = document.getElementById('car-container');

//     cars.forEach((car) => {
//         // Create a div for each car
//         const carDiv = document.createElement('div');
//         carDiv.className = 'car';

//         // Create an h2 element for the car name
//         const carName = document.createElement('h2');
//         carName.textContent = car.name;

//         // Create an img element for the car image
//         const carImage = document.createElement('img');
//         carImage.src = car.imageUrl;
//         carImage.alt = car.name;

//         // Append the name and image to the car div
//         carDiv.appendChild(carName);
//         carDiv.appendChild(carImage);

//         // Append the car div to the container
//         container.appendChild(carDiv);
//     });
// }

// // Call the function after the DOM is loaded
// document.addEventListener('DOMContentLoaded', displayCars);