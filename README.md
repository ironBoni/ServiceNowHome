## README - ServiceNow Home Assignment - Noam Cohen
### Overview of the solution:
The solution takes a file containing the notes of a private investigator and processes it to find similar sentences where only one word differs. The approach was to break the functionality into modular classes, focusing on making the code readable, maintainable, and scalable.

* **NotesParser**: Responsible for converting the raw lines of input into a list of Entry objects.
* **EntryGrouper**: It groups the Entry objects based on patterns with just one differing word.
* **OutputFormatter**: Formats the grouped entries into the required output format.
* **FileHandler**: Handles reading from and writing to files.
* **Main**: The main class that integrates all the above components.

### How to run?
(First, Java should be installed on your system, the relevant JDK.)
Place the input file as "input.txt" in the same location of all the classes you cloned. <br/>
**Option 1**:
Open IntelliJ, and click on the "run" (Play) button inside the Main.java file.

**Option 2**:
1. Compile the program using the command:
   ```
   javac Main.java
   ```
2. Run the program using the command:
   ```
   java Main
   ```
   The program reads from a file named **input.txt** and writes the results to a file named **output.txt**.

### 1. What can you say about the complexity of your code?
The most intensive part of the algorithm involves comparing each sentence with every other sentence. This gives a time complexity of O(n^2), where n is the number of sentences. For each pair of sentences, we perform another loop to compare the words inside the sentences, but since the number of words in a sentence can be considered relatively constant, this doesn't significantly affect the overall complexity. Therefore, the solution's main complexity remains O(n^2).

### 2. How will your algorithm scale?
Considering the O(n^2) complexity, the algorithm may not be efficient for an extremely large number of sentences. However, as stated in the assumptions, the file's structure can be entirely loaded into memory. As such, for a reasonably large set of sentences, this solution will work effectively. For significantly larger datasets, we would need to reconsider our approach, possibly using more sophisticated data structures or algorithms to identify similarities between sentences.
### 3. If you had two weeks to do this task, what would you have done differently? What would be better?
With more time:
1. **Optimize Algorithm**: Investigate more efficient algorithms or data structures to handle the problem, especially focusing on reducing the time complexity.
2. **Concurrency**: Implement multi-threading or parallel processing for handling the comparisons, which could reduce processing time.
3. **Unit Tests**: Even though they were deemed not important for this task, for a production-ready solution, unit tests are essential. They would ensure that every part of the code works correctly.
4. **User Interface**: Implement a basic UI or command-line interface allowing the user to select input/output files, view results, etc.
5. **Logging and Error Handling**: Integrate comprehensive logging and error-handling mechanisms.
6. **Profiling and Benchmarking**: Profile the application to find any bottlenecks and benchmark the solution against different sizes of datasets to have a clear picture of performance and areas of improvement.
