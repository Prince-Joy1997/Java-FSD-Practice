const movieList = document.getElementById('movieList');
const movies = [
    'The Matrix 4',
    'The Batman',
    'Doctor Strange in the Multiverse of Madness',
    'Thor: Love and Thunder',
    'Black Panther 2',
    'Black Widow',
    'Jurassic World: Dominion',
    'Star Trek 4',
    'Ted', 
    'Ted 2',
    'The Mummy'
]

const favourites = []

const showMovies = () => {
    
    movieList.innerHTML = '';
    movies.forEach((movie) => {
      const listItem = document.createElement('div');
      listItem.className = 'list-item';
      const movieName = document.createElement('span');
      movieName.className = 'item';
      movieName.innerText = movie;
      const addButton = document.createElement('button');
      addButton.innerText = 'Add to Favourites';
      addButton.addEventListener('click', () => {
        addToFavourites(movie);
        showMovies();
        showFavourites();
      });
      listItem.appendChild(movieName);
      listItem.appendChild(addButton);
      movieList.appendChild(listItem);
    });
  };

  const showFavourites = () => {
    const favList = document.getElementById('favList');
    favList.innerHTML = '';
    favourites.forEach((movie) => {
      const listItem = document.createElement('div');
      listItem.className = 'list-item';
      const movieName = document.createElement('span');
      movieName.className = 'item';
      movieName.innerText = movie;
      const removeButton = document.createElement('button');
      removeButton.innerText = 'Remove from Favourites';
      removeButton.addEventListener('click', () => {
        removeFromFavourites(movie);
        showMovies();
        showFavourites();
      });
      listItem.appendChild(movieName);
      listItem.appendChild(removeButton);
      favList.appendChild(listItem);
    });
  };

const addToFavourites = (movie) => {
    
    // Function that adds a movie to the favourites array
    // If the movie is already in the favourites array, it should not be added again
    // If the movie is not in the favourites array, it should be added
    // Once the movie is added the movie should be removed from the movies array
    // and rendered to the DOM. 
    // The favourites array should also be rendered to the DOM
    if (!favourites.includes(movie)) {
        favourites.push(movie);
        const movieIndex = movies.indexOf(movie);
        movies.splice(movieIndex, 1);
      }
}

const removeFromFavourites = (movie) => {
    // Function that removes a movie from the favourites array
    // If the movie is not in the favourites array, it should not be removed
    // If the movie is in the favourites array, it should be removed
    // Once the movie is removed the movie should be added to the movies array
    // and rendered to the DOM.
    // The favourites array should also be rendered to the DOM
    const movieIndex = favourites.indexOf(movie);
    favourites.splice(movieIndex, 1);
    movies.splice(movieIndex, 0, movie);
}
  showMovies();
  showFavourites();