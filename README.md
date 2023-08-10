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
The most intensive part of the algorithm involves comparing each sentence with every other sentence. This gives a time complexity of **O((n^2) * m)**
The time complexity of the given code can be determined by breaking down its primary loops and operations:

There's a nested loop, which is evident from:
````
for (int i = 0; i < entries.size(); i++) {
    for (int j = i + 1; j < entries.size(); j++) {
        ...
    }
}
````
This is a classic pattern of an O(n^2) time complexity, where n is the size of the entries list.

Within the nested loop, there's another loop that iterates through the words in the entries:
````
for (int k = 0; k < words1.length; k++) {
    ...
}
````
In the worst case, if every entry is m words long, this loop has a time complexity of O(m).
Both entry1.getText().split(" ") and entry2.getText().split(" ") can be considered O(m) operations for the worst case.

Other operations inside the loop, such as getting from the map, adding to the map, and replacing words in the entry, are generally considered O(1) on average. However, replace can be O(m) in the worst case because it might have to traverse the whole string to replace a word.

Given these factors, the overall time complexity is:

O(n^2) * O(m) = O((n^2) * m)

Therefore, the time complexity is O((n^2) * m), where n is the number of entries and m is the maximum number of words in an entry.


### 2. How will your algorithm scale?
In reality we might have extremely large number of sentences. For significantly larger datasets, we would need to reconsider our approach (of loading all the sentences at once to the memory), possibly using more sophisticated data structures or algorithms to identify similarities between sentences or load just parts of the data and all of it at once.

### 3. If you had two weeks to do this task, what would you have done differently? What would be better?
With more time:
1. **Optimize Algorithm**: Investigate more efficient algorithms or data structures to handle the problem, especially focusing on reducing the time complexity.
2. **Concurrency**: Implement multi-threading or parallel processing for handling the comparisons, which could reduce processing time.
3. **Unit Tests**: Even though they were deemed not important for this task, for a production-ready solution, unit tests are essential. They would ensure that every part of the code works correctly.
4. **User Interface**: Implement a basic UI or command-line interface allowing the user to select input/output files, view results, etc.
5. **Logging and Error Handling**: Integrate comprehensive logging and error-handling mechanisms.
6. **Profiling and Benchmarking**: Profile the application to find any bottlenecks and benchmark the solution against different sizes of datasets to have a clear picture of performance and areas of improvement. Afterwards, perform optimizations.
