COMP 3005 - Assignment 3 Question 1

The latest version of java(java 21.0.2) was used when writing and executing the code.
So if for some reason your version of java is having a hard time executing the code,
you might have to update to this version. Although I didn't use anything special in my
solution so this shouldn't be necessary.

NOTE: I have included a copy of the postgresql-42.7.3.jar file in the GITHUB link
      in case you cannot download it from the given link and need access to it.

Compiling Instructions:
	1 - Begin by downloading the postgresql-42.7.3.jar file from the following link:
		https://jdbc.postgresql.org/download/
	Note: Since I used the latest version of java, the jar file that I chose to
		download was the one specifically made for Java versions 8 or later.

	2 - Open VsCode and make sure the extension pack for java is installed. This will
	    greatly simplify the installation of the jar file.

	3 - Download and open the "question1.java" file in vs code. Make sure you have the
	    jar file IN THE SAME DIRECTORY as the java file.

	4 - Ensure the Explorer tab is selected on the top left of the GUI.
	
	5 - In the explorer tab, select and open the "Java Projects" tab at the bottom.

	6 - Open the folder that you selected back in step 3 if it isn't already.

	7 - Find the "Referenced Libraries" tab and click on the "+" button at the right
	    of the tab. This will allow you to add the jar file that we downloaded in step
	    1 so that java will know what code we're trying to reference.

	8 - Find and select the jar file that we downloaded in step 1. You should now have
	    everything needed to compile the code.

Execution Instructions:
	1 - Go to the main function of the code and locate the jdbcUrl, username, and password
	    strings.

	2 - Make sure the jdbcUrl is set to "jdbc:postgresql://localhost:5432/*name of database*"
	    where *name of database* is replaced with the name of the database you have in
	    postgresql where the students database was created.

	3 - The username string doesn't need to be changed. The password string should be set
	    to the password you use in order to log into postgresql so you can access your
	    databases.

	4 - Right click anywhere on vs code and select "Run Java" from the dropdown menu. The code
	    should now compile and execute.



Video Demonstration Link: https://mediaspace.carleton.ca/media/COMP+3005+A3+Q1+Video+Demonstration/1_i2uhephx