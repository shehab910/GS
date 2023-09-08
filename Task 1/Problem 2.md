---
Tags:
- Recursion
- Java
---
## Solution
```Java
private static void printSequenceHelper(int number, int i){  
    if (i > 10)  
        return;  
    System.out.println(number * i);  
    printSequenceHelper(number, i+1);  
    System.out.println(number * i);  
}  
  
public static void printSequence(int number){  
    printSequenceHelper(number, 1);  
}
```
## Suggested Solution
```Java
private static void printSequence(int number, int limit, int i){  
    if (i > limit)  
        return;  
    System.out.println(number * i);  
    printSequence(number, limit, i+1);  
    System.out.println(number * i);  
}  
  
public static void printSequence(int number){  
    printSequence(number, 10, 1);  
}
```
### Advantages of the suggested solution
1. The defaults can be easily changed, without changing the main function.
2. The main method -_the one with 3 arguments_- is private, preventing any misuse of the user.
## Brainstorming & Additions
### Assumptions
I renamed the variable `n` to `number` and assumed that number is a whole number within the bounds of an `int`.
### Approach
Since loops is prohibited and we have the following characteristics:
- Sequence is printed in ascending order
- The same sequence is printed in descending order after it
We can:
- Use the call stack to our benefit
- Treat recursion as kind of a `goto` statement to act as a loop
For example, if we want to print numbers from 1 to 10 in loops it looks like this:
```Java
for (int i=1; i<=10; i++){
	System.out.println(i);
}
```
The equivalent of which in recursion _assuming the initial call is `printNums(1)`_:
```java
void printNums(int i){
	if (i > 10) // base case
		return;
	System.out.println(i);
	printNums(i+1);
}
```
To solve the first part of our problem - printing `n, n*2, n*3` - it's a very simple addition, add the `n` as an argument and multiply it to `i`.
But to solve the second part - printing `n*10, n*9, ..., n` - we will use the call stack for this.
```java
void printNums(int i){
	if (i > 10) // base case
		return;
	System.out.println(i);
	printNums(i+1);
	System.out.println(i);
}
```
But we still have the problem of the initial value of `i` must be 1, and that could be easily mistaken, i solved that by creating helper function, to cut short i hammered my keyboard until i got this working solution.
```Java
private static void printSequenceHelper(int number, int i){  
    if (i > 10)  
        return;  
    System.out.println(number * i);  
    printSequenceHelper(number, i+1);  
    System.out.println(number * i);  
}  
  
public static void printSequence(int number){  
    printSequenceHelper(number, 1);  
}
```
This is what is required, but i have some changes to make this more versatile/clean _at least in my opinion_.
I have 2 main problems with the above code:
1. The number `10` is hard coded.
	- The first problem is easily solved by adding an extra parameter `limit` while making 10 is the default _same as 1 is the default_ to preserve the original behavior
2. The naming of `printSequenceHelper` is not optimal
	- I searched for a **default parameter** implementation in Java, but couldn't find any, there were workarounds 
		1. Use method overloading -> Best choice?
		2. ~~Allow nulls as an input~~ -> What if not null?
		3. ~~Declare a method with Java Varargs~~ -> Seems like over engineering
Fixing the previous problems we are left with the [Suggested Solution](#suggested-solution).