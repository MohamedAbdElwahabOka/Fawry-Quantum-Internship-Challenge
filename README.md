# Fawry Quantum Car Factory

This is a simple Java console application built for the Fawry Internship Challenge. It simulates a car factory where cars can have different types of engines that can be easily replaced.

## Project Description

The application demonstrates core Object-Oriented Programming (OOP) concepts (like Interfaces, Inheritance, and Polymorphism) and uses the **Factory Design Pattern** to create and replace car engines cleanly.

## Key Features

- **3 Engine Types:** Gasoline, Electronic, and a Mixed Hybrid Engine.
- **Smart Hybrid Logic:** The Hybrid engine runs on electricity at low speeds (under 50 km/h) and automatically switches to gas at higher speeds to save cost.
- **Speed Synchronization:** When the car accelerates (+20 km/h) or brakes (-20 km/h), the engine gradually adjusts its internal speed (+1 or -1) to match the car's speed.
- **Safety Checks:** The car cannot be stopped unless its speed is exactly 0. Max speed is capped at 200 km/h.

## Technologies Used

- Java
