// const ctx = document.getElementById('myBarChart');
//
//   new Chart(ctx, {
//     type: 'bar',
//     data: {
//       labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
//       datasets: [{
//         label: '# of Votes',
//         data: [12, 19, 3, 5, 2, 3],
//         borderWidth: 1
//       }]
//     },
//     options: {
//       scales: {
//         y: {
//           beginAtZero: true
//         }
//       }
//     }
//   });

document.addEventListener("DOMContentLoaded", function() {
  fetch('/chart/personnesdata') // Endpoint to fetch personne data
      .then(response => response.json())
      .then(data => {
        console.log('Data:', data); // Log fetched data to check its format

        const personnes = data; // Assuming data is an array of personnes
        const labels = personnes.map(personne => personne.nom);
        const initialSalaires = personnes.map(personne => personne.initialSalaire);
        const finalSalaires = personnes.map(personne => personne.salaireFinal);

        var ctx = document.getElementById('myBarChart');
        if (!ctx) {
          console.error('Canvas element not found');
          return;
        }

        var myChart = new Chart(ctx, {
          type: 'bar',
          data: {
            labels: labels,
            datasets: [{
              label: 'Initial Salary',
              data: initialSalaires,
              backgroundColor: 'rgba(255, 99, 132, 0.2)',
              borderColor: 'rgba(255, 99, 132, 1)',
              borderWidth: 1
            }, {
              label: 'Final Salary',
              data: finalSalaires,
              backgroundColor: 'rgba(54, 162, 235, 0.2)',
              borderColor: 'rgba(54, 162, 235, 1)',
              borderWidth: 1
            }]
          },
          options: {
            scales: {
              y: {
                beginAtZero: true
              }
            }
          }
        });
      })
      .catch(error => console.error('Error fetching data:', error));
});
document.addEventListener("DOMContentLoaded", function() {
  fetch('/chart/personnesdata') // Endpoint to fetch personne data
      .then(response => response.json())
      .then(data => {
        console.log('Fetched Data:', data);

        // Initialize counts as integers
        let managersCount = 0;
        let employeesCount = 0;

        // Count managers and employees
        data.forEach(personne => {
          if (personne.typePersonne === 'Manager') {
            managersCount++;
          } else if (personne.typePersonne === 'Employee') {
            employeesCount++;
          }
        });

        console.log('Managers Count:', managersCount);
        console.log('Employees Count:', employeesCount);

        // Calculate the percentages
        const total = managersCount + employeesCount;
        const managersPercentage = (managersCount / total) * 100;
        const employeesPercentage = (employeesCount / total) * 100;

        console.log('Managers Percentage:', managersPercentage);
        console.log('Employees Percentage:', employeesPercentage);

        // Render the doughnut chart
        var ctx = document.getElementById('myPieChart').getContext('2d');
        var myPieChart = new Chart(ctx, {
          type: 'doughnut',
          data: {
            labels: ['Managers', 'Employees'],
            datasets: [{
              data: [managersPercentage, employeesPercentage],
              backgroundColor: [
                'rgba(255, 99, 132, 0.2)', // Red for managers
                'rgba(54, 162, 235, 0.2)'  // Blue for employees
              ],
              borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)'
              ],
              borderWidth: 1
            }]
          },
          options: {
            responsive: true,
            plugins: {
              legend: {
                position: 'top',
              },
              title: {
                display: true,
                text: 'Percentage of Managers and Employees'
              }
            }
          }
        });
      })
      .catch(error => console.error('Error fetching data:', error));
});