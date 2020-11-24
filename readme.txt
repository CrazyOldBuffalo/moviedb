b5028276 - Tomasz Boberek © 2020
Moviedb.java Assignment
Network Applications Development - Assignment 1
=================================================================================

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
