//Anastasiya Chabotska
//Assignment 4

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class HW4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//ArrayList<Movie> movies = new ArrayList<>();

		//create an array of files from the folder
		File [] fileArray = new File(
				"/Users/anastasiyachabotska/Desktop/Workspace/HW4/ml-latest-small").listFiles();
		//output file
		PrintWriter outFile = new PrintWriter("output.txt");


		//create array lists to store movie objects for each genre
		ArrayList<Movie> action = new ArrayList<>();
		ArrayList<Movie> adventure = new ArrayList<>();
		ArrayList<Movie> animation = new ArrayList<>();
		ArrayList<Movie> children = new ArrayList<>();
		ArrayList<Movie> comedy = new ArrayList<>();
		ArrayList<Movie> crime = new ArrayList<>();
		ArrayList<Movie> documentary = new ArrayList<>();
		ArrayList<Movie> drama = new ArrayList<>();
		ArrayList<Movie> fantasy = new ArrayList<>();
		ArrayList<Movie> filmNoir = new ArrayList<>();
		ArrayList<Movie> horror = new ArrayList<>();
		ArrayList<Movie> IMAX = new ArrayList<>();
		ArrayList<Movie> musical = new ArrayList<>();
		ArrayList<Movie> mystery = new ArrayList<>();
		ArrayList<Movie> romance = new ArrayList<>();
		ArrayList<Movie> sciFi = new ArrayList<>();
		ArrayList<Movie> thriller = new ArrayList<>();
		ArrayList<Movie> war = new ArrayList<>();
		ArrayList<Movie> western = new ArrayList<>();


		//store all the array lists into another array list for easier access
		ArrayList<ArrayList<Movie>> genres = new ArrayList<>();
		genres.add(action);
		genres.add(adventure);
		genres.add(animation);
		genres.add(children);
		genres.add(comedy);
		genres.add(crime);
		genres.add(documentary);
		genres.add(drama);
		genres.add(fantasy);
		genres.add(filmNoir);
		genres.add(horror);
		genres.add(IMAX);
		genres.add(musical);
		genres.add(mystery);
		genres.add(romance);
		genres.add(sciFi);
		genres.add(thriller);
		genres.add(war);
		genres.add(western);


		//create an array with movie genres titles
		String[] genresTitles = new String[] {"Action", "Adventure", "Animation", 
				"Children", "Comedy", "Crime", "Documentary", "Drama", "Fantasy",
				"Film-Noir", "Horror", "IMAX", "Musical", "Mystery", "Romance", 
				"Sci-Fi", "Thriller", "War", "Western"};



		//open the file from the array named "movies.csv"
		for (File f: fileArray) {
			//check the name of the file
			if (f.getName().equals("movies.csv")) {

				//create a Scanner object
				Scanner sc = new Scanner(f);
				//go to the next line
				String line = sc.nextLine();
				//go to the next line to skip the headline
				line = sc.nextLine();

				//start reading the file
				while (sc.hasNext()){

					Movie myMovie = new Movie();

					//if there are quotation marks in the line, split it with q.m. as delimiters
					if (line.contains("\"")) {

						String [] tokens = line.split("\"");
						String temp = tokens[1];
						//get rid of all the commas in the String
						temp.replaceAll(",", "");


						//check if the title contains the release year
						int digits =0;
						for (int i=0; i<temp.length(); i++) {
							if (temp.charAt(i) >= '0' && temp.charAt(i) <= '9')
								digits++;	
						}

						//some of the movie titles contain digits, but so not contain release year,
						//try block to avoid IndexOutOfBoundException
						try {

							//if there are more than 4 digits in the title
							if(digits>=4) {
								//extract the year
								String year = temp.substring(temp.length()-6);
								//convert string to integer
								int relYear = Integer.parseInt(year.replaceAll("[( )]", "").replaceAll("–","").trim());
								//extract the title
								String title = temp.substring(0, temp.length()-6).trim();

								ArrayList<String> genre = new ArrayList<>();
								String tempg = tokens[2].replaceAll("[ ,]","");
								if(tempg.contains("|")) {
									String[] genres1 = tempg.split("\\|");
									//add all genres to the array list
									genre = new ArrayList<>(Arrays.asList(genres1));
								}
								//add genre to the array list, if only single genre
								else genre.add(tempg);

								//create new Movie object
								myMovie= new Movie(title, genre, relYear);

							}

						}
						catch (Exception e){
							System.out.println(e);
						}

					}


					//otherwise, if no quotation marks
					else {
						//split the line with commas as delimiters
						String [] tokens = line.split(",");
						String temp = tokens[1];
						temp.replaceAll(",", "");
						String tempg=tokens[2];
						tempg.replaceAll("[ ,]", "");

						ArrayList<String> genre = new ArrayList<>();

						if(tempg.contains("|")) {

							String[] genres1 = tempg.split("\\|");

							//add genres to the array list
							genre = new ArrayList<>(Arrays.asList(genres1));
						}
						else 
							//add genre to the array list
							genre.add(tempg);


						//check if the title contains the release year
						int digits =0;
						for (int i=0; i<temp.length(); i++) {
							if (temp.charAt(i) >= '0' && temp.charAt(i) <= '9')
								digits++;	
						}

						//if there are more than 4 digits in the title
						if(digits>=4) {
							//extract the year
							String year = temp.substring(temp.length()-6);
							//convert string to integer
							int relYear = Integer.parseInt(year.replaceAll("[( )]", "").replaceAll("–","").trim());
							//extract the title
							String title = temp.substring(0, temp.length()-6).trim();
							//create a new Movie object
							myMovie=new Movie(title, genre, relYear);

						}		



					}

					//add Movie objects to the Array Lists according to genres
					for (int i=0; i<myMovie.genre.size(); i++) {
						if (myMovie.genre.get(i).equalsIgnoreCase("Action"))
							action.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Adventure"))
							adventure.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Animation"))
							animation.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Children"))
							children.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Comedy"))
							comedy.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Crime"))
							crime.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Documentary"))
							documentary.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Drama"))
							drama.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Fantasy"))
							fantasy.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Film-Noir"))
							filmNoir.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Horror"))
							horror.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("IMAX"))
							IMAX.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Musical"))
							musical.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Mystery"))
							mystery.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Romance"))
							romance.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Sci-Fi"))
							sciFi.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Thriller"))
							thriller.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("War"))
							war.add(myMovie);
						else if (myMovie.genre.get(i).equalsIgnoreCase("Western"))
							western.add(myMovie);
						else continue;
					}

					line =sc.nextLine();
				}

				sc.close();
			}	

		}


		//create a HashMap with String keys and ArrayLists as values
		HashMap<String, ArrayList<Movie>> movies = new HashMap<>();
		for (int i=0; i<genres.size(); i++)
			movies.put(genresTitles[i], genres.get(i));

		/*movies.put("Action", action);
		movies.put("Adventure", adventure);
		movies.put("Animation", animation);
		movies.put("Children", children);
		movies.put("Comedy", comedy);
		movies.put("Crime", crime);
		movies.put("Documentary", documentary);
		movies.put("Drama", drama);
		movies.put("Fantasy", fantasy);
		movies.put("Film-Noir", filmNoir);
		movies.put("Horror", horror);
		movies.put("IMAX", IMAX);
		movies.put("Musical", musical);
		movies.put("Mystery", mystery);
		movies.put("Romance", romance);
		movies.put("Sci-Fi", sciFi);
		movies.put("Thriller", thriller);
		movies.put("War", war);
		movies.put("Western", western);*/



		outFile.println("Movies over all years: ");
		sortDescending(movies, outFile);	

		outFile.println();
		outFile.println("Movies for the recent 5 years: ");
		sortByYear(movies, genresTitles, 2015, 2020, outFile);

		outFile.println();
		outFile.println("Movies for the decade 2010 to 2020: ");
		sortByYear(movies, genresTitles, 2010, 2020, outFile);

		outFile.println();
		outFile.println("Movies for the decade 2000 to 2010: ");
		sortByYear(movies, genresTitles, 2000, 2010, outFile);

		outFile.println();
		outFile.println("Movies for the decade 1990 to 2000: ");
		sortByYear(movies,genresTitles, 1990, 2000, outFile);

		outFile.println();
		outFile.println("Movies for the decade 1980 to 1990: ");
		sortByYear(movies,genresTitles, 1980, 1990, outFile);

		outFile.println();
		outFile.println("Movies for the decade 1970 to 1980: ");
		sortByYear(movies,genresTitles, 1970, 1980, outFile);

		outFile.println();
		outFile.println("Movies for the decade 1960 to 1970: ");
		sortByYear(movies,genresTitles, 1960, 1970, outFile);
		
		outFile.println();
		outFile.println("Movies for the decade 1950 to 1960: ");
		sortByYear(movies,genresTitles, 1950, 1960, outFile);

		outFile.close();


	}



	/*method sortByYear - prints the map sorted in descending order and filtered by years, sorted by less/greater than average
	 * Input:
	 * map - HashMap
	 * array of genres' titles
	 * start year
	 * end year
	 * Process:
	 * Create a new HashMap and new Array List
	 * Filter the stream according to years
	 * Add Movie objects to the list and put into map with appropriate title
	 * Sort the new map in descending order
	 * Output:
	 * Print out the map in descending order by number of movies and whether it is greater or less than average
	 * */
	public static void sortByYear(HashMap<String, ArrayList<Movie>> map, String[] genresTitles, int yr1, int yr2, PrintWriter outFile){

		HashMap<String, ArrayList<Movie>> sortedMap = new HashMap<>();
		ArrayList<Movie> sortedByYear = new ArrayList<>();

		//filter by year
		for (int i=0; i<genresTitles.length; i++) {

			sortedByYear= map.get(genresTitles[i]).stream().filter(x -> x.year>=yr1 && x.year<=yr2).
					collect(Collectors.toCollection(ArrayList:: new));
			//add to the map
			sortedMap.put(genresTitles[i], sortedByYear);




		}

		//sort in descending order
		List<String> keys = sortedMap
				.entrySet()
				.stream()
				.sorted((left, right) ->
				Integer.compare(right.getValue().size(), left.getValue().size()))
				.map(entry -> entry.getKey())
				.collect(Collectors.toList());


		//create a new list to sort by greater/less than average
		List<String> newList = new ArrayList<>();

		//sort by greater/less than average
		newList = keys
				.stream()
				.sorted((x1, x2) -> 
				Integer.compare(average(map, x2, sortedMap.get(x2).size(), yr1, yr2), average(map, x1, sortedMap.get(x1).size(), yr1, yr2)))
				.collect(Collectors.toList());


		//print out the map
		for (String s: newList) {
			outFile.println(sortedMap.get(s).size()+" "+s+" movies came out from "+yr1+" to "+yr2+" "+averageForYears(map, s, sortedMap.get(s).size(), yr1, yr2));
		}



	}

	/*method sortByYear - similar to the above method, except it returns a list with filtered movies (does not sort in order)*/
	public static List<Movie> sortByYear(ArrayList<Movie> ar, int yr1, int yr2, String s){


		List<Movie> sortedByYear = new ArrayList<>();

		sortedByYear= ar.stream().filter(x -> x.year>=yr1 && x.year<=yr2).collect(Collectors.toList());

		return sortedByYear;


	}


	/*method sortDescending - prints the HashMap in descending order by the number of movies 
	 * Input:
	 * map - HashMap of movies
	 * Process:
	 * Sorts the stream
	 * Output:
	 * Prints the sorted list*/
	public static void sortDescending(HashMap<String, ArrayList<Movie>> movies, PrintWriter outFile) {
		//create a sorted list of movie genres based on number of movies

		//create a sorted list
		List<String> keys = movies
				.entrySet()
				.stream()
				.sorted((left, right) ->
				Integer.compare(right.getValue().size(), left.getValue().size()))
				.map(entry -> entry.getKey())
				.collect(Collectors.toList());

		//print out number of movies of each genre in descending order
		for (String s: keys) {
			outFile.println(movies.get(s).size()+" "+s+" movies came out over all years");

		}

	}



	/*method averageForYears - 
	 * method computes the average number of movies per certain period based on the whole data set and compares it to the given number*/
	public static String averageForYears(HashMap<String, ArrayList<Movie>> movies, String genre, int numMovies, int yr1, int yr2) {
		int number=0;

		//get the total number of movies of given genre for all years
		number+=movies.get(genre).size();

		//average number of movies per period of given years 
		//(divide by 100, since movies are given for 100 years)
		int average=number/100*(yr2-yr1);


		if (average>numMovies)
			return "(less than average)";
		else if (average<numMovies)
			return "(greater than average)";
		else return "(average number)";

	}


	/*method average - 
	 * method computes the average number of movies per certain period based on the whole data set and compares it to the given number
	 * Returns -1 if less than average, 1 if greater and 0 if equal
	 * */
	public static int average(HashMap<String, ArrayList<Movie>> movies, String genre, int numMovies, int yr1, int yr2) {
		int number=0;

		//get the total number of movies of given genre for all years
		number+=movies.get(genre).size();

		//average number of movies per period of given years 
		//(divide by 100, since movies are given for 100 years)
		int average=number/100*(yr2-yr1);


		if (average>numMovies)
			return -1;
		else if (average<numMovies)
			return 1;
		else return 0;

	}



}
