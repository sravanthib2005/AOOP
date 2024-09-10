

public class LongestWordFinder {

    
    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split("\\s+"); 
        String longestWord = "";
        
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

   
    public static void main(String[] args) {
       
        String test1 = "The quick brown fox jumped over the lazy dog";
        String test2 = "Hello";
        String test3 = "a bb ccc dddd";
        String test4 = ""; 
        String test5 = "Java Eclipse";

        System.out.println("Longest word in test1: " + findLongestWord(test1));  
        System.out.println("Longest word in test2: " + findLongestWord(test2));  
        System.out.println("Longest word in test3: " + findLongestWord(test3));  
        System.out.println("Longest word in test4: " + findLongestWord(test4));  
        System.out.println("Longest word in test5: " + findLongestWord(test5));  
    }
}

