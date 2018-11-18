# Software Testing MOOC

This repository contains the code examples and exercises of
TU Delft's edX MOOC on Software Testing.

## License

This repository is licensed under CC BY-NC-SA.

<hr>

# Course Content

## Automated Software Testing
- Introduction to JUnit
- `Defect` (aka `Bug`) vs. `Failure`: Defect **can** lead to a Failure 

## Functional Testing

## Equivalence Partitioning (aka: Equivalence Classes) 

**Samples:** 

a) The [Leap Year Calculation](./src/main/java/tudelft/leapyear/LeapYear.java) has to respect 4 cases (==partitions):
- non leap year (%4!==0)
- non leap centurial year (%100==0 AND %400!=0)
- leap centurial year (%400==0)
- leap year (%4==0 AND %100!=0)

It's called `equivalence` partitions, as for each partition you can use any input, which fulfills the partitions 
condition, e.g. for 'non leap year' you can take year = 2001, year=2002, year = 2003, year = 2005...

b) Christmas Discount on raw Amount

- category 1: Christmas | not Christmas
- category 2: amount > 0 | amount == 0 | amount < 0 (exception!)  

Combinatorial:
=> 2x3 Cases = 6 Cases
   for amount < 0, 1 case is enough => 5 Cases


