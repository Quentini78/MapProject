/*import SvgImage from '../resources/france-final.svg'; */
import React, { useEffect, useState } from 'react';
import './CitiesList.css';

function Cities() {
  const [cities, setCities] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8082/api/cities', {
          method: 'GET',
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': 'http://localhost:8082/'
          // Ajoutez d'autres en-têtes si nécessaire
        });
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        const citiesFromUrl = data.map(city => ({
          id: city.id,
          name: city.name,
          url: `/api/cities/${city.name}`,
        }));
        setCities(citiesFromUrl); // Met à jour l'état avec les données récupérées
      } catch (error) {
        console.error('Error fetching cities:', error);
      }
    };

    fetchData();
  }, []); // Le tableau vide [] indique que cette effect se déclenche uniquement après le montage initial du composant

  return (
    <div className="layout-container">
      <div className="cities-list-container">
        <ul>
          {cities.map(city => (
            <li key={city.id}>
              <a href={`/villes/${city.id}`}>{city.name}</a>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
  
}

export default Cities;