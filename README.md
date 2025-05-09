# AI Methods and Tools in Java

This repository contains implementations of various artificial intelligence algorithms and methods in Java that I worked on during my laboratory classes in college.

---
</br>

## Exercises:

### Function Definition for Exercises 1 and 2
```math
f(x_1, x_2) = -x_1^2 - x_2^2 + 2
```
</br>

## Lab1. Topic: *Random optimization*
### *Exercise 1.*
### 🗎 File name: Algorithm1.java
### Algorithm: Random Walk Optimization
</br>

#### Task Description

Using the **random walk method**, determine the maximum of the function **f(x₁, x₂)**. Let **M** be the number of iterations of this algorithm. The algorithm should output the results of the calculations, i.e., **fmax** and **Xmax**.
Determines such x1 and x2 for which f reaches its maximum value, i.e. 𝑓(𝑥1, 𝑥2) → 𝑚𝑎𝑥 while maintaining the constraints for 𝑥1 and 𝑥2.

#### Additional Requirements

- Save intermediate results to:
  - **`best_step.txt`** – Stores the best function value **fmax** found so far at each iteration.
  - **`current.txt`** – Stores function values **f(X)** for each generated point.
- Generate plots in Excel using the collected data.
  
</br>

### *Exercise 2.*
### 🗎 File name: Algorithm2.java
### Algorithm: Monte Carlo Optimization
</br>

#### Task Description

Using the Monte Carlo search mechanism, determine the maximum of the function 𝑓(𝑥1, 𝑥2). In
the algorithm, let M also be the number of iterations of this algorithm. Let the algorithm output the results after the number of iterations, i.e. 𝑓𝑚𝑎𝑥 and 𝑋𝑚𝑎𝑥. Also, save the current values ​​of 𝑓 and 𝑓𝑚𝑎𝑥 to a file, as it was done in
exercise 1.

</br>

## Lab2. Topic: *Coding and decoding solutions in a genetic algorithm*
### *Exercise 3.*
### 🗎 File name: Algorithm3.java
</br>

#### Task Description

We are given a function of n variables called the Rastrigin function of the general form:

```math
f(X) = An + \sum_{i=1}^{n} \left[x_i^2 - A \cos(2 \pi x_i) \right]
```

</br>

#### Assumptions about the Rastrigin function: </br>

Assume that A = 10 and n = 2 (the number of variables) and −5.21 ≤ 𝑥𝑖 ≤ 5.21 and i=1, 2. 
</br>
</br>

**The form of the Rastrigin function for two variables _x₁_ and _x₂_:**

```math
f(X) = 10 \cdot 2 + \left[x_1^2 - A \cos(2 \pi x_1)\right] + \left[x_2^2 - A \cos(2 \pi x_2)\right], \quad \text{where } -5{,}21 \le x_1, x_2 \le 5{,}21
```

</br></br>

**Assuming we are interested in a precision of 3 decimal places, complete the following tasks:**

a) How many bits are needed to encode each variable?

b) What is the total length (number of bits) of a potential solution (i.e., a chromosome)?

c) Using a random mechanism, generate a binary string (0–1) representing a potential solution encoded as a one-dimensional vector (a one-dimensional array).

d) Decode the generated binary string to determine the values of the variables _x₁_ and _x₂_.  
Check whether the obtained values of _x₁_ and _x₂_ are **valid**, i.e., whether they satisfy the constraint:  
`-5.21 ≤ x₁, x₂ ≤ 5.21`. If not, draw another valid binary string.

e) Calculate the value of the function _f_ by substituting the decoded values of _x₁_ and _x₂_ (from the binary string).









