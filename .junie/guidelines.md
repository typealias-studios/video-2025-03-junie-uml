# Pet Daycare Project

This project is developed based on PlantUML diagrams.

## Development Rules

When generating the code from UML class diagrams:

- Most of the time, put each class and interface in its own Kotlin file. However, all classes related to a certain kind
  of pet can go in a single file. For example, `Hamster` and `HamsterFood` can go in a single `Hamster.kt` file, with
  the main class (e.g., `Hamster`) at the top of the file, and supporting classes (e.g., `HamsterFood`) below that.
- Include all member functions and properties from the UML file.
- Do not create any additional types, functions, or properties that are not specified in the UML file.
- Implement the functions when the intended behavior is obvious. For example, if a class has a private collection
  property and there are functions to add and remove members from that collection, go ahead and implement it.
- Implement the functions when the intended behavior is specified in a note on the diagram.
- Do not implement functions when the behavior is neither obvious nor specified in a note. In these cases, call Kotlin's
  `TODO()` function in the body of the function, providing a string argument that explains why it was not implemented.

### Test Code

- If a function's implementation is obvious, do not write a test for it. For example, a function that simply adds an
  element to a collection does not need a unit test. When the function implementation is not obvious or is not simple,
  it should have a corresponding unit test.

## Project Structure

The PlantUML files are in the `/uml` directory.

Here's the structure for the main source code:

- `com.example.daycare` - Root package.
  - `pets` - All pet models go here.
  - `exceptions` - Exception types go here.
  - `session` - Files related to the daycare session and its schedule.
