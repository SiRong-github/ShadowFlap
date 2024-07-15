# University Subject

This project is done for SWEN20003 Object of Oriented Software Development of the University of Melbourne. It makes use of the Bagel (Basic Academic Graphical Engine Library) library developed by Eleanor McMurty which uses LWJGL to present a simple game interface.

# File Purpose

The program implements the Flappy Bird game using the Bagel library:
https://gitlab.eng.unimelb.edu.au/emcmurtry/bagel-public

# Demo

https://github.com/SiRong-github/ShadowFlap/assets/62817554/2ed3a527-8f95-46f5-9cf8-349936afe4c4

https://github.com/SiRong-github/ShadowFlap/assets/62817554/2bd8b0ef-e67e-448b-9951-a983652435b9

https://github.com/SiRong-github/ShadowFlap/assets/62817554/c0bad8b8-fae2-470f-b0b7-1aff065f4c1a

# Testing

1. Download the IDE IntelliJ here: https://www.jetbrains.com/idea/
2. Open the project in the IDE
3. Head to the Toolbar, press Run and then press Run Configurations
4. Ensure that the java version is java 11 and click Apply and Ok
5. Press Run (or the Play Button) and enjoy the game!

# File-Level Documentation

The game consists of 2 levels:

1. Level 0

   Consists of the usual Flappy Bird gameplay, wherein the player has to avoid hitting various sets of plastic pipes.

2. Level 1

   Consists of an additional steel pipe type which shoots flames and of a set of weapons the player can utilise.

   Rocks can only hit plastic pipes while bombs can hit any pipe type. Both weapons have limited shooting ranges.

# Provided Template

1. bagel.iml

   Contains the provided Bagel package.

2. pom.xml

   Contains the maven compiler plugin to be able to use the Bagel package.

3. res folder

   Contains the images of the game objects and the font style.

4. src folder

   Contains the ShadowFlap.java which is the main program to be edited.
