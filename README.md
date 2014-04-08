helloJava8
==========

A while back I ran into an issue at work where I really wished Java had lambdas.  This demo 
show what I wished I could have done to solve the problem.

This demo shows a progression of refactoring across four packages:
  1)  todd.dryViolation
  2)  todd.firstRefactor
  3)  todd.secondRefactor
  4)  todd.lambda
  
Note there are tests for each of these packages.  The tests are almost identical, as you 
expect for a refactoring exercise.  The only differences are the test class names and the 
package being tested.

The problem domain is a test suite for a bunch of asynchronous processes.  The suite 
has to kick off processes and wait for their completion.  

Step One
--------
The package todd.dryViolation represents the initial state.  There was one large class
with cookie-cutter repeated blocks of code.  This example has nearly identical blocks of 
code, but the actual code has blocks with slight difference that were likely bugs.

Step Two
--------
The package todd.firstRefactor represents the action I took to eliminate redundancy and 
ensure consistent behavior.  The DRY violations are eliminated, but now I have multiple
source files. I would like a simpler solution.

The solution here is to use polymorphism to implement inversion of control.

Step Three
----------
The package todd.secondRefactor represent a path I could have taken, but didn't.  I 
included it because it is the closest I could get to lambdas in Java 7.  I don't think
it's an improvement over the todd.firstRefactor, but I would not be upset if others 
disagree.

I'm still using polymorphism, but I've replace the concrete sub-classes with anonymous
classes.  This eliminates source code files, but clutters the code with boilerplate.

Step Four
---------
The package todd.lambda represents the ideal solution -- or at least the best solution 
offered by Java.  

We no longer have an abstract class.  We have a concrete class that takes a lambda in the 
constructor.

