Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?


>> Overloaded Methods! <<

1) sellCoffee()
*A default coffee order for sellCoffee() if the customer does not give any particular details besides that they want a hot coffee. 
*If you don’t ask for any cream or sugar, it isn’t going to be included
*Default size of 12 fl oz unless otherwise stated as well (like a medium, average size)
*Sugar and cream are not consumed/removed from inventory 
*Thought this would be useful since not everyone is going to take in the time to say that they want a 12 oz coffee with zero creams and zero sugar, they usually just say a hot coffee, and sometimes specify if they will have a different size that isn’t medium if they’re doing a more in depth answer. Honestly just allows for more convenience for the customer if you have a run-of-the-mill, baseline coffee. 

2) moveIn()
*I also liked the idea of being able to move in multiple people into a house at once. Like we discussed during class, at the beginning of the new year we aren't going to painstakingly add each new student to their houses, it will likely be done in a grouping.
*So instead of just taking in Strings, I overloaded the moveIn() function to also support ArrayList<String>
*I created a test ArrayList of students, and all were able to be added at once, and individual students could still be added in afterwards

3) Default constructors for each class
*Allows for a default type of any building to be made without having to put parameters in. *Mainly useful for testing. 


>> Part 2 <<
*Did run into an issue with Class not found exceptions, which I am still trying to find the cause of. Tillie was able to help me fix it though (I am so grateful)! Cleaning the Java Workspace resolved the issue. Not sure if something I did caused this error, since importing and moving the files over went smoothly and the issue seemed to start the night I submitted.
*Otherwise, this went well! I actually did catch a past error/inefficency in my sell coffee method from A6, so I fixed it in this one. It wasn't causing errors, I just found a better way to restock cups. 
