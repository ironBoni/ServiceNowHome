# README - ServiceNow Home Assignment
## Overview of the solution:
Our solution reads through a file containing investigator notes and identifies sentences that 
are similar (i.e., they differ by only one word). For each pair of similar sentences, the program 
notes the differing word(s). The results are then written to an output file in the desired format.

## How to run?
1. Ensure you have Java installed on your system.
2. Save the provided code as InvestigatorNotesProcessor.java.
3. Compile the program using the command:
   ```
   javac InvestigatorNotesProcessor.java
   ```
4. Run the program using the command:
   ```
   java InvestigatorNotesProcessor
   ```
5. The program reads from a
   file named input.txt and writes the results to a file named output.txt by default.

## 1. What can you say about the complexity of your code?
The core of the algorithm involves comparing every sentence with every other sentence, 
which makes it O(n^2) where n is the number of sentences. For each sentence pair, we're 
comparing every word, making the complexity O(n^2 * m) where m is the average number of 
words in each sentence.

## 2. How will your algorithm scale?
This algorithm does not scale well for very large inputs due to its quadratic complexity. For example, with 10,000 sentences, we'd have around 100 million comparisons.

## 3. If you had two weeks to do this task, what would you have done differently? What would be better?
With more time:

We could optimize the solution by sorting the sentences based on their length or using more advanced data structures like Trie for more efficient comparisons.
Implement multithreading to parallelize the comparison tasks.
Break down the main method into more granular methods for better readability and modularity.
Implement unit tests for different scenarios.
Create a more interactive interface or command-line arguments to specify the input and output files rather than hardcoding them.
This solution uses simple data structures, and the goal was to keep it as straightforward and readable as possible without adding unnecessary complexity.
