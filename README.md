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
Open *IntelliJ*, and click on the **run** (Play) button inside the *Main.java* file.

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
*O(n^2) * O(m) = O((n^2) * m)*

Therefore, the time complexity is O((n^2) * m), where **n is the number of entries** and **m is the maximum number of words in an entry**.


### 2. How will your algorithm scale?
In reality we might have extremely large number of sentences. For significantly larger datasets, we would need to reconsider our approach (of loading all the sentences at once to the memory), possibly using more sophisticated data structures or algorithms to identify similarities between sentences and load only parts of the data and all of it at once. One thing to do is use ElasticSearch which can index the sentences and gives better performance in a larger dataset. It is explained in the next paragraph. Profiling and benchmarking are also important to verify the code working well on large dataset with long sentences and then customize the algorithm and data structures.

### 3. If you had two weeks to do this task, what would you have done differently? What would be better?
With more time:
1. **Optimize Algorithm**: Investigate more efficient **algorithms** or **data structures** to handle the problem, especially focusing on reducing the time complexity.
2. **Concurrency**: Implement **multi-threading** or parallel processing for handling the comparisons, which could reduce processing time.
3. **Unit Tests**: For a production-ready solution, unit tests are essential. They would ensure that every part of the code works correctly.
4. **Dependency Injection (DI)**:
Instead of a class creating its dependencies, they are injected from the outside. This results in decoupled, maintainable, and testable code.
Implementation:
* *DI Frameworks*: Java frameworks such as **Spring** can be used to manage dependencies.
* *Constructor Injection*: Dependencies of a class can be provided through its constructor.
* *Setter Injection*: Alternatively, setter methods can be used to inject dependencies.
* *Interfaces*: Make sure the code is independent, so that implementations can be adapted quickly in the future.
5. **Abstraction and Polymorphism**:
* *Custom Comparators*: Different strategies to compare sentences could be abstracted out using an interface (e.g., SentenceComparator). We can then have different implementations like *SingleWordDifferenceComparator* or *LevenshteinDistanceComparator*. This allows easy switching between comparison techniques.
* *File Handlers*: Different implementations for various file formats (TXT, JSON, XML) can be derived from a base **IFileHandler interface**. This way, the system can easily be extended to handle various file types.
6. **Composition over Inheritance**:
Rather than extending classes, use composition to combine behaviors. This would lead to more flexible and maintainable code.
For instance, the EntryGrouper might have multiple behaviors, such as filtering, grouping, etc. These can be separate components instead of base or derived classes.
7. **Strategy Pattern**:
Depending on how the notes need to be processed, different strategies can be formulated and encapsulated behind a unified interface. For example, a *IProcessingStrategy interface* could have implementations like *OneWordDifferenceStrategy* or *ExactMatchStrategy*.
8. **Factory Pattern**:
A factory class could be responsible for *creating instances of comparators, file handlers, or other components based on some criteria*. This ensures that object creation logic is centralized and not spread across the application.
9. **Singleton Pattern**:
For components that should be instantiated only once (e.g., logger, configuration loader), a Singleton pattern ensures a single instance throughout the application's lifecycle.
10. **Observer Pattern**:
If there's a need to notify other components about changes or events (e.g., when a matching pattern is found), the Observer pattern allows for decoupled, event-driven architecture.
11. Use of DTOs (**Data Transfer Objects**):
For transferring data between layers or components, DTOs can be employed to ensure that only necessary data is passed around without exposing the domain model.
12. **Encapsulation and Modularity**:
Ensure that each class has a single responsibility, and its internal workings are hidden from outside classes. Public interfaces should expose only necessary methods, ensuring the principle of information hiding.
13. **User Interface**: Implement a basic UI or command-line interface allowing the user to select input/output files, view results, etc.
14. **Logging and Error Handling**: Integrate comprehensive logging and error-handling mechanisms.
15. **Profiling and Benchmarking**: Profile the application to find any bottlenecks and benchmark the solution against different sizes of datasets to have a clear picture of performance and areas of improvement. Afterwards, perform optimizations.
16. **Elasticsearch** can significantly improve the system's scalability and performance when dealing with an extremely large number of sentences, especially longer ones. Here's how Elasticsearch can be utilized in this context:
* *Full-Text Search*:
ES is optimized for full-text search, allowing rapid searches across large volumes of text data.
Complex queries to find similar sentences can be executed more quickly and efficiently compared to traditional relational databases.
* *Scalability*:
Elasticsearch can be horizontally scaled, meaning you can distribute the data across multiple nodes. This allows for the processing of large datasets while maintaining fast search speeds.
* *Tokenization and Analysis*:
Elasticsearch uses tokenizers and analyzers, breaking down sentences into tokens. This process can help in identifying and comparing individual words or terms within large sentences.
Custom analyzers can be built to better suit the specific needs of the application.
* *Fuzzy Search*:
By using the fuzzy search capabilities of ES, it's possible to find sentences that are approximately similar, allowing a degree of mismatch.
This can be particularly useful for identifying sentences that are similar but have minor differences.
* *Aggregations*:
Aggregations can provide summarized data about the search results, such as frequency counts of differing words. This can help in efficiently extracting and grouping similar sentences.
* *Real-Time Indexing*:
As new sentences are added, ES can index them in near real-time, ensuring the latest data is always searchable without significant delays.
* *Efficient Storage*:
ES compresses data for storage, making it suitable for storing vast amounts of text data.
*How to Integrate in the System*:
* **Data Ingestion**: Import all the sentences into an Elasticsearch index.
* **Querying for Similarities**: When checking for similar sentences, run a query on ES, which will return potential matches based on the implemented criteria.
* **Storing Results**: The results, i.e., groups of similar sentences, can be stored in a separate index or a relational database, depending on the application's requirements.

17. Alternatively, in case of large numbers of sentences then load only some of them each time to the memory in order to keep performance good.
