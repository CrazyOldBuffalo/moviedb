/ Added By b5028276 /
PROGRAM DESCRIPTION
================================================================================
Java application covers a movie system that contains a user, movies and ratings collection.
The System links the movies and users file's to ratings displaying a rating a user gives on a film.
System displays the average rating for each film in the movies collection by users and each rating the user has given to a movie.
The System also displays the movies that 2 seperate users have rated together.
It is seperated into 7 different Java files and sorted into 4 groups (Ratings, Users, Movies, Main).

FILE BREAKDOWN
===============================================================================
Ratings
=======
Ratings is split into 2 files - Ratings.java & RatingSearch.java.
 * Ratings.java - Creates the objects for the class and reads the Ratings.dat file for use with the RatingSearch.java file.
 * RatingSearch.java - Contains all the methods that are used to create the average Ratings for the 3 main Functions (User, Movie and 
   2 User Ratings).

Movies
======
Movies is also split into 2 files - Movies.java & MovieSearch.java.
 * Movies.java - Creates the objects and reads the movies.dat file for use with MovieSearch.java.
 * MovieSearch.java - Contains all the methods to search through the Movies Map and outputs them when searched.

Users
======
Users is the same as the above - Users.java & UserSearch.java.
 * Users.java - Creates the objects and reads the users.dat file.
 * UserSearch.java - Contains the methods to search through the Users Map and outputs them when searched.

Main
=====
Main is used to store the Main function and is made of just one file - Moviedb.java. It Runs all the classes to build the Maps & lists, 
and also contains the Menu that allows the user to run the methods stored in the Search.java files.
 * Moviedb.java - Runs the public methods in each class and stores the Menu that allows the user to enter which function they want to run.

USING THE APPLICATION
================================================================================
Using the application is split into 3 steps: compiling, running and use.

1. Compiling
============
To compile the File:

* navigate to the file path where you have stored the application within the Console (cmd):
	e.g: C:/Users/username/documents/storedfolder
  for assistance on how to do this visit:
  	https://docs.microsoft.com/en-us/windows-server/administration/windows-commands/windows-commands

* Type into the console:
  	javac Moviedb.java

2. Running
===========
To run the file in console (cmd):

	* Navigate to the file path where you have stored the application within the console (cmd):
		e.g: e.g: C:/Users/username/documents/storedfolder

	* Type into the console:
		java Moviedb
	
	* The application should now run!

To run the file in an IDE (Eclipse, VSCode, etc):

	* In your IDE of choice open the folder the application is stored in.

	* Once open run the Moviedb.java file and the application will then run.

3. Using
==========
To use the application use the onscreen Menu's to navigate around and use the different features,
the application uses 2 different input types to operate:

	1. Integers
		* To navigate most of the menus use an integer when prompted to activate an option or to search for a particular ID
	
	2. Strings
		* At the end of most functions the application will ask you if you wish to run it again or return to the menu,
		  In this instance a Y or N is requested, entering this will allow you to navigate back to the previous function
		  or return to the meu.


/ Already Added /

Data Files for Assignment 1
==================================
RATINGS FILE DESCRIPTION
================================================================================

All ratings are contained in the file "ratings.dat" and are in the
following format:

UserID::MovieID::Rating::Timestamp

- UserIDs range between 1 and 6040 
- MovieIDs range between 1 and 3952
- Ratings are made on a 5-star scale (whole-star ratings only)
- Timestamp is represented in seconds since the epoch as returned by time(2)
- Each user has at least 20 ratings


USERS FILE DESCRIPTION
================================================================================

User information is in the file "users.dat" and is in the following
format:

UserID::Gender::Age::Occupation::Zip-code

All demographic information is provided voluntarily by the users and is
not checked for accuracy.  Only users who have provided some demographic
information are included in this data set.

- Gender is denoted by a "M" for male and "F" for female
- Age is chosen from the following ranges:

	*  1:  "Under 18"
	* 18:  "18-24"
	* 25:  "25-34"
	* 35:  "35-44"
	* 45:  "45-49"
	* 50:  "50-55"
	* 56:  "56+"

- Occupation is chosen from the following choices:

	*  0:  "other" or not specified
	*  1:  "academic/educator"
	*  2:  "artist"
	*  3:  "clerical/admin"
	*  4:  "college/grad student"
	*  5:  "customer service"
	*  6:  "doctor/health care"
	*  7:  "executive/managerial"
	*  8:  "farmer"
	*  9:  "homemaker"
	* 10:  "K-12 student"
	* 11:  "lawyer"
	* 12:  "programmer"
	* 13:  "retired"
	* 14:  "sales/marketing"
	* 15:  "scientist"
	* 16:  "self-employed"
	* 17:  "technician/engineer"
	* 18:  "tradesman/craftsman"
	* 19:  "unemployed"
	* 20:  "writer"

MOVIE FILE DESCRIPTION
================================================================================

Movie information is in the file "movies.dat" and is in the following
format:

MovieID::Title::Genres

- Titles are identical to titles provided by the IMDB (including
year of release)
- Genres are pipe-separated and are selected from the following genres:

	* Action
	* Adventure
	* Animation
	* Children's
	* Comedy
	* Crime
	* Documentary
	* Drama
	* Fantasy
	* Film-Noir
	* Horror
	* Musical
	* Mystery
	* Romance
	* Sci-Fi
	* Thriller
	* War
	* Western

- Some MovieIDs do not correspond to a movie due to accidental duplicate
entries and/or test entries
- Movies are mostly entered by hand, so errors and inconsistencies may exist

WHAT YOUR APPLICATION SHOULD REPORT

*Your application should be able to load all rating information given to movies by specific users
*Your application should report the average rating received by all movies
*Your application should report the average rating given by all users
*If an average rating for a movie is queried, your application should be able to generate it
*If an average rating given by a user is queried, your application should be able to generate it
*Your application should persist its data to a file.
*Your application should handle all errors such as duplicate entries, missing ids or ratings, etc.

Example outputs of Average Ratings Received by Each Movie
========================================================

Movieid  : 688  Movie Title:  Leave It to Beaver (1997):   Average Rating : 1.84
Movieid  : 689  Movie Title:  Jackal, The (1997):   Average Rating : 3.15
Movieid  : 690  Movie Title:  Seven Years in Tibet (1997):   Average Rating : 3.46
Movieid  : 691  Movie Title:  Dark City (1998):   Average Rating : 3.5
Movieid  : 692  Movie Title:  American President, The (1995):   Average Rating : 3.63
Movieid  : 693  Movie Title:  Casino (1995):   Average Rating : 3.65
Movieid  : 694  Movie Title:  Persuasion (1995):   Average Rating : 4.05
Movieid  : 695  Movie Title:  Kicking and Screaming (1995):   Average Rating : 2.92
Movieid  : 696  Movie Title:  City Hall (1996):   Average Rating : 3.14
Movieid  : 697  Movie Title:  Basketball Diaries, The (1995):   Average Rating : 3.43
Movieid  : 698  Movie Title:  Browning Version, The (1994):   Average Rating : 3.0
Movieid  : 699  Movie Title:  Little Women (1994):   Average Rating : 3.68


Example Outputs of Average Ratings given by Users
=================================================
User  : 1   Average Rating : 3.61
User  : 2   Average Rating : 3.71
User  : 3   Average Rating : 2.8
User  : 4   Average Rating : 4.33
User  : 5   Average Rating : 2.87
User  : 6   Average Rating : 3.64
User  : 7   Average Rating : 3.97
User  : 8   Average Rating : 3.8
User  : 9   Average Rating : 4.27
User  : 10   Average Rating : 4.21
User  : 11   Average Rating : 3.46
User  : 12   Average Rating : 4.39
User  : 13   Average Rating : 3.1
User  : 14   Average Rating : 4.09
User  : 15   Average Rating : 2.88
User  : 16   Average Rating : 4.33
User  : 17   Average Rating : 3.04
User  : 18   Average Rating : 3.88
User  : 19   Average Rating : 3.55
User  : 20   Average Rating : 3.1