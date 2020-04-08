# Assignment-4
Assignment 4 - Movie Genres
1. The program first reads in the data from file and creates movie objects
2. Movie objects are stored into ArrayLists according to the genres
3. ArrayLists are added to a HashMap as values with movie genres' titles as keys
4. The method sortDescending sorts the HashMap in descending orders by the number of movies of each genre
5. The method sortByYear filters the map by years, sorts it in descending order and then sorts it according to the average number of movies per genre (above/below)
6. The method average calculates the average number of movies of the genre per year based on the whole data set, and calculates the average number of movies expected for a given time period. It compares the average number to a given number of movies and returns -1, 0, or 1 if less/equal/above average respectively


The output file demonstrates the two methods showing all movies, movies from the past 5 years, and movies for decades between 1950 to 2020 all sorted in descending order and in order of above/below average number of specific genre

