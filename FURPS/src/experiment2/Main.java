package experiment2;

public class Main {

    public static void main(String[] args) {
        // start time
        long startTime = System.nanoTime();
        WordCount wordCount = new WordCount("LykkePer.txt");
        // end time
        long endTime = System.nanoTime();

        // difference between the two nano time values
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);

        // start time
        startTime = System.nanoTime();
        System.out.println(wordCount.occurrenceOfWord("lykkelig"));
        // end time
        endTime = System.nanoTime();

        // difference between the two nano time values
        timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);

        System.out.println("Total of words " + wordCount.total());
    }
}
