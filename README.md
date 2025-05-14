# AI Methods and Tools in Java

This repository contains implementations of various artificial intelligence algorithms and methods in Java that I worked on during my laboratory classes in college.

---

</br>

## Exercises:

### Function Definition for Lab1 Exercises 1 and 2
```math
f(x_1, x_2) = -x_1^2 - x_2^2 + 2
```
</br>

## Lab1. Topic: *Random optimization*
### *Exercise 1.*
### 🗎 File name: RandomWalkOptimization.java
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
### 🗎 File name: MonteCarloOptimization.java
</br>

#### Task Description

Using the Monte Carlo search mechanism, determine the maximum of the function 𝑓(𝑥1, 𝑥2). In
the algorithm, let M also be the number of iterations of this algorithm. Let the algorithm output the results after the number of iterations, i.e. 𝑓𝑚𝑎𝑥 and 𝑋𝑚𝑎𝑥. Also, save the current values ​​of 𝑓 and 𝑓𝑚𝑎𝑥 to a file, as it was done in
exercise 1.
