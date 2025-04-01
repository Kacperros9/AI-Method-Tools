# AI Methods and Tools in Java 🤖🧠

This repository contains implementations of various artificial intelligence algorithms and methods in Java that I worked on during my laboratory classes in college.

---

## Exercises:

### Exercise 1.
### 🗎 File name: Algorithm1.java
### Algorithm: Random Walk Optimization


#### ✨ Task Description

Using the **random walk method**, determine the maximum of the function **f(x₁, x₂)**. Let **M** be the number of iterations of this algorithm. The algorithm should output the results of the calculations, i.e., **fmax** and **Xmax**.

#### 🔢 Function Definition

```math
f(x_1, x_2) = -x_1^2 - x_2^2 + 2
```
Determines such x1 and x2 for which f reaches its maximum value, i.e. 𝑓(𝑥1, 𝑥2) → 𝑚𝑎𝑥 while maintaining the constraints for 𝑥1 and 𝑥2.

#### Additional Requirements

- Save intermediate results to:
  - **`best_step.txt`** – Stores the best function value **fmax** found so far at each iteration.
  - **`current.txt`** – Stores function values **f(X)** for each generated point.
- Generate plots in Excel using the collected data.
