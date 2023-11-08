How to run the code ?
----------------------

Copy the whole application code to your local machine. 
Do mvn clean package to generate jar file. It should be in target folder.
From the project root, run the below docker commands.
	docker build --tag=teamapi-server:latest . (Please don't ignore DOT in the end of the docker command)
	docker run -p8080:8080 teamapi-server:latest
Access the following urls
http://localhost:8080/Teams - It will list the teams.
http://localhost:8080/updateUserRole - It will allow you to update the role of the user.

Approach the problem/solution
-----------------------------

I tried to analyze how the relationship is built between Teams and Users entity by looking at the endpoints that were shared.
I understand that a user may belong to zero or more teams and several teams can have same user.
So i had to chose Many to Many relationship inorder to set Role for the user by team.

When it comes to database modelling there are two approaches to follow to fullfil the desired relation and also add a field Role.
First approach: 
Make two Foreign keys in JointTable as composite keys and add new column Role.
Second approach:
Just add Primary key without composite key and add new column Role.

I had chosen second approach because it makes things much simpler, reduce code complexity.

REST Endpoints:
I had chosen Patch mapping since i need to just update one field Role.