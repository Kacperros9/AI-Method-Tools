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

</br>

## Lab2. Topic: *Coding and decoding solutions in a genetic algorithm*
### *Exercise 1.*
### 🗎 File name: RastriginEncodingDecoding.java
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
-5.21 ≤ x₁, x₂ ≤ 5.21. If not, draw another valid binary string.


</br>

## Lab3. Topic: *Genetic operators - crossover*
### *Exercise 1.*
### 🗎 File name: RastriginGA2Variables.java
</br>

#### Task Description

For the Rastrigin function with two variables x1 and x2:

```math

    f(\mathbf{x}) = 10 \cdot 2 + \left[x_1^2 - 10 \cdot \cos(2\pi x_1)\right] + \left[x_2^2 - 10 \cdot \cos(2\pi x_2)\right],
    \quad \text{where } -5.21 \le x_1, x_2 \le 5.21

```

</br>

Randomly generate two solutions (chromosomes) in binary representation **that meet the admissibility conditions**, assuming a precision of 3 decimal places after the point for decoded values. Call them "parents". Compute the Rastrigin function value for both solutions.

Next:

a) Design a single-point crossover operator and perform crossover on the parent solutions. Compute the function value f for the resulting offspring. Do the offspring solutions differ significantly from the parents in terms of function value?

b) Design a two-point crossover operator and perform crossover on the parent solutions. Compute the function value f for the resulting offspring. Do the offspring differ significantly from the parents in terms of function value?

c) As a result of crossover, an offspring may be **invalid** (e.g., x1 or x2 falls outside the range −5.21 ≤ xi ≤ 5.21). Fix the offspring so that it meets the admissibility constraints again. Propose and implement a method to repair such invalid offspring.

</br>

### *Exercise 2.*
### 🗎 File name: RastriginGA10Variables.java
</br>

#### Task Description

Repeat Exercise 1 for the Rastrigin function with 10 variables:

```math

    f(\mathbf{x}) = An + \sum_{i=1}^{n} \left[x_i^2 - A \cdot \cos(2\pi x_i)\right], \quad \text{where } A = 10 \text{ and } -5.21 \le x_i \le 5.21,\ i = 1,\dots,n

```

</br>

## Lab4. Topic: *Genetic Operators – PMX Crossover, Mutation, and Inversion*
### *Exercise 1.*
### 🗎 File name: RastriginGA2VariablesMutation.java
</br>

#### Task Description

For the Rastrigin function of 2 variables x1 and x2 (Binary Representation)

```math
f(X) = 10 \cdot 2 + \left[x_1^2 - A \cdot \cos(2\pi x_1)\right] + \left[x_2^2 - A \cdot \cos(2\pi x_2)\right], \quad \text{where } -5.21 \leq x_1, x_2 \leq 5.21
```

</br>

1.1 Randomly generate a solution using a **binary representation** that satisfies admissibility conditions and assumes a precision of 3 decimal places for decoded values.

1.2 Calculate the function value `f` for the generated solution.

1.3 Design a **mutation operator**. Let the mutation probability `(pₘ)` be a parameter of the operator. Perform a mutation on the solution using a given `pₘ`, and then:

1.4 Calculate the function value `f` after mutation.

Has the function value changed after applying the mutation operator?

</br>

### *Exercise 2.*
### 🗎 File name: PMXCrossoverOperator.java
</br>

#### Task Description

- Create two solutions (parents) using a **path representation**, containing a random permutation of numbers from the set `[1, 10]`.

- Design and perform the **PMX crossover operator** for the two parent solutions.

- List the original parent solutions and the resulting offspring.

</br>

### *Exercise 3.*
### 🗎 File name: PathInversionOperator.java
</br>

#### Task Description

- Design the **inversion operator** for path-represented solutions.

- Perform inversion on the **parents from Exercise 2** and present the results.

</br>

### *Exercise 4.*
### 🗎 File name: RastriginGA10VariablesBinary.java
</br>

#### Task Description

The Rastrigin function for `n = 10` variables is defined as:

```math
f(x) = A \cdot n + \sum_{i=1}^{n} \left[x_i^2 - A \cdot \cos(2\pi x_i)\right], \quad \text{ where } A = 10,\ n = 10,\ x_i \in [-5.21,\ 5.21] \text{ with precision to 3 decimal places}
```
</br>

- Complete the same steps as in **Exercise 1**, adapted for **10 variables**.
