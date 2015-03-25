# Sudoku command line tool
Command line tool implemented in Java to validate sudoku passed to the tool as a parameter. If provided solution is valid then tool prints out `VALID` message to standard output. If validation fails or some errors occures `INVALID` message with error description will be printed to standard output.

## How to build
This is Maven Java project in order to run it Java 1.7 should be installed. In order to build it Java and Maven should be installed. 

To build the project run following command in project root directory:

	mvn install

## How to run
2 scripts for Bash Shell and for Windows Command prompts are provided. 

`validate.sh` - bash shell script

`validate.bat` - Windows command line script

For Unix/Linux/Mac OS run:

	./validate.sh <filename>
	
For Windows run:

	./validate.bat <filename>
	
Tool can be run direclty using `java` command. For use with Java run:

	java -jar target/SudokuCmd-1.0.jar <filename>
	
## Testing
There JUnit tests created to test the project and it can be tested with following Maven command:

	mvn test
	
Sample solutions files are provided to run test from command line. 
`puzzleSample.txt` - file with invalid solution
`validPuzzle.txt` - file with valid solution

Use them as following:

	validate.bat puzzleSample.txt
	validate.bat validPuzzle.txt