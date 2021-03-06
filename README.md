# Software Testing MOOC

This repository contains the code examples and exercises of
TU Delft's edX MOOC on Software Testing.

## License

This repository is licensed under CC BY-NC-SA.

<hr>

# Course Content

## 0. Introduction

### Readings

- [Software Tester Career](http://istqbexamcertification.com/software-tester/)
- [A pragmatic explanation on the difference between validation vs verification](https://www.easterbrook.ca/steve/2010/11/the-difference-between-verification-and-validation/)

## 1. Automated Software Testing

- Introduction to [JUnit 5](https://junit.org/junit5/docs/current/user-guide/)

- `Defect` (aka `Bug`) vs. `Failure`: Defect **can** lead to a Failure 

## 2. Functional Testing

### Equivalence Partitioning (aka: Equivalence Classes) 

**Samples:** 

a) The [Leap Year Calculation](./src/main/java/tudelft/leapyear/LeapYear.java) has to respect 4 cases (==partitions):
```
- non leap year (%4!==0)
- non leap centurial year (%100==0 AND %400!=0)
- leap centurial year (%400==0)
- leap year (%4==0 AND %100!=0)
```

It's called `equivalence` partitions, as for each partition you can use any input, which fulfills the partitions 
condition, e.g. for 'non leap year' you can take year = 2001, year=2002, year = 2003, year = 2005...

b) Christmas Discount on raw Amount

```
- category 1: Christmas | not Christmas
- category 2: amount > 0 | amount == 0 | amount < 0 (exception!)  
```

Combinatorial:
=> 2x3 Cases = 6 Cases
   for amount < 0, 1 case is enough => 5 Cases

### Boundary Testing/Boundary Analysis

Sample:
`If the total ordering is above 100, shipping costs are $5.`

==> 
```
   OUT-points                          | IN-points
                      ...   98 99 100  | 101 ...
                                  ON-  | OFF-point
```

**Domain Matrix**

![Domain Matrix](docs/domain-analysis-in-software-testing-10-638.jpg)

### CORRECT

The **CORRECT** way stands for Conformance, Ordering, Range, Reference, Existence, Cardinality, and Time:

- **Conformance**: 
  Many inputs should conform to a specific format. For example, an e-mail address has a name@domain format. 
  What happens to our system if the e-mail is invalid, e.g, no name, or no domain, or invalid domain?
- **Ordering**: 
  The input and output may depend on some ordering criteria. For example, our system expects the user to input 
  all invoices for reimbursement in the chronological order they happened. 
  What happens if the user makes a mistake and does not send it in the right order? 
  Or, our system may need to return the list of best players, according to the number of points they made in 
  the last game, from the best to the worst. Does the system return in the right order? 
- **Range**: 
  The inputs should be within a defined limit. For example, the user needs to input her age. 
  What happens if she passes a negative number? What happens if she passes 200? 
- **Reference**: 
  The inputs and behaviour under test may require a previous state. For example, in a web store, 
  for an order to be placed, the user needs to have an account first. 
  What happens if the user tried to place an order without an account?
- **Existence**: 
  The inputs "may not exist". What happens if someone passes a null or an empty string?
- **Cardinality**: 
  The famous off-by-one error. It happens when we forget to "iterate the last item" in our algorithm. 
  For example, if you should return the number of elements between m and n (inclusive), 
  the intuitive answer would be (n-m), whereas the right answer is (n-m+1). 
  In practice, this often happens in iterative loops: developers often iterate one time too few. 
  You can read about the fencepost error in the Wikipedia. 
  As a tip, what happens to your system when it has zero, one, or many values to iterate?
- **Time**: 
  Your input may be about date/time. What happens to your system if the input was done by a person in a place 
  that does not have Daylight Saving Time? 
  Does the system work for someone in New York (GMT-5) as well as for someone in Amsterdam (GMT+1)?

## 3. Structural Testing and Code Coverage

### Strategy Subsumption

line/statement coverage - condition/branch coverage - Modified Decision Coverage/Decision Coverage - path coverage
 
- If you achieve 100% decision coverage, you also achieved 100% line coverage.
- If you achieve 100% path coverage, you also achieved 100% decision coverage.

These relations are strategy subsumption. 

More formally: Strategy X subsumes strategy Y if all elements that Y exercises are also exercised by X:

![Coverage Strategy Subsumption](./docs/coverage-strategy-subsumption.png) 

### Further Reading

- [jacoco Coverage Tool Documentation](https://www.jacoco.org/jacoco/trunk/doc/index.html)
- TODO [SR-Podcast about Jacoco](http://www.se-radio.net/2018/05/se-radio-episode-324-marc-hoffmann-on-code-test-coverage-analysis-and-tools/)

- [Slides - Software Testing and Analysis: Process, Principles and Techniques, Wiley, 2007., Chapter 12](http://www.inf.ed.ac.uk/teaching/courses/st/2017-18/Ch12.pdf)

## 4. Testability and Mock Objects

### Further Reading


## 5. Test Code Smells

### Test Data Builder

Encapsulate Test Data Creation
to avoid test code changes in many place in case of changes of the production code

- [Test Data Builders: an alternative to the Object Mother pattern, by Nat Pryce](http://www.natpryce.com/articles/000714.html)
- [Nat Pryce's Library for Building Test Data](https://github.com/npryce/make-it-easy) according to the builder pattern
- Another Library for Building Test Data [Fixture Factory](https://github.com/six2six/fixture-factory)

### Test Flakyness

What to do in case of flaking Tests: see [Erratic Tests](http://xunitpatterns.com/Erratic%20Test.html)

![Decision Tree](http://xunitpatterns.com/Erratic%20Test%20Trouble-Shooting.gif) 

# Readings

### What to test
- [Ham Vocke on the practical testing pyramid](https://martinfowler.com/articles/practical-test-pyramid.html)

- [Martin Fowler's definition of integration testing](https://martinfowler.com/bliki/IntegrationTest.html)
- [Eugen Kiss' blog post explaining why he prefers integration testing more than unit testing](https://blog.usejournal.com/lean-testing-or-why-unit-tests-are-worse-than-you-think-b6500139a009)

... and please see single sections above

# Glossary

- Testability: **Controllability vs. Observability**
    - **Controllability** is about how easy it is for us to provide **inputs and invoke the behaviour** that we want in 
      the system under test. 
    - **Observability** is about how easy it is for us to **observe the system under test** 
      in order to verify whether the system behaved as expected.
  
- Testability: **Dependency Injection vs. Dependency Inversion Principle**
    - Robert Martin defines the **Dependency Inversion Principle** as:
               
      >> High-level modules should not depend on low-level modules. Both should depend on abstractions.
      >> Abstractions should not depend upon details. Details should depend upon abstractions.
   
       So, dependency inversion is about how classes are designed. The principle makes us think about what parts of our system are (should be) abstractions and what parts  contain low level details.
   
    - **Dependency injection**, 
      on the other hand, is about how one object knows the dependencies of other objects, 
      so that it can inject them, when needed. Dependency Injection is about how objects get their dependencies.
