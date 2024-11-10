import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class QuizApp {
    
    private static final String[] historyQuestions = {
        "Who was the first Prime Minister of India?",
        "In which year did India gain independence?",
        "Who is known as the 'Father of the Nation' in India?",
        "Which battle marked the beginning of British rule in India?",
        "Who was the last Mughal emperor of India?"
    };

    private static final String[][] historyOptions = {
        {"A. Jawaharlal Nehru", "B. Mahatma Gandhi", "C. Sardar Patel", "D. Dr. Rajendra Prasad"},
        {"A. 1945", "B. 1947", "C. 1950", "D. 1952"},
        {"A. Bhagat Singh", "B. Subhas Chandra Bose", "C. Mahatma Gandhi", "D. Bal Gangadhar Tilak"},
        {"A. Battle of Plassey", "B. Battle of Panipat", "C. Battle of Buxar", "D. Battle of Haldighati"},
        {"A. Akbar", "B. Bahadur Shah II", "C. Aurangzeb", "D. Shah Jahan"}
    };

    private static final char[] historyAnswers = {'A', 'B', 'C', 'A', 'B'}; // Correct answers for history

    
    private static final String[] entertainmentQuestions = {
        "Who played the character of Harry Potter in the movies?",
        "Which is the highest-grossing film of all time?",
        "Who is known as the 'King of Pop'?",
        "Which Bollywood actor is known as the 'Badshah of Bollywood'?",
        "What is the name of the fictional country in the movie Black Panther?"
    };

    private static final String[][] entertainmentOptions = {
        {"A. Daniel Radcliffe", "B. Elijah Wood", "C. Rupert Grint", "D. Tom Holland"},
        {"A. Titanic", "B. Avatar", "C. Avengers: Endgame", "D. Star Wars: The Force Awakens"},
        {"A. Elvis Presley", "B. Michael Jackson", "C. Freddie Mercury", "D. Prince"},
        {"A. Salman Khan", "B. Shah Rukh Khan", "C. Aamir Khan", "D. Akshay Kumar"},
        {"A. Zamunda", "B. Genovia", "C. Wakanda", "D. Latveria"}
    };

    private static final char[] entertainmentAnswers = {'A', 'B', 'B', 'B', 'C'}; // Correct answers for entertainment

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("Welcome to the Quiz! You can choose between two sections:\n1. Indian History\n2. Entertainment");

        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

       
        if (choice == 1) {
            System.out.println("\nYou have selected the Indian History section.");
            totalScore += runQuiz(historyQuestions, historyOptions, historyAnswers, scanner);
        } else if (choice == 2) {
            System.out.println("\nYou have selected the Entertainment section.");
            totalScore += runQuiz(entertainmentQuestions, entertainmentOptions, entertainmentAnswers, scanner);
        } else {
            System.out.println("Invalid choice. Exiting the quiz.");
            scanner.close();
            return;
        }

        System.out.println("Quiz completed!");
        System.out.println("Your total score: " + totalScore + " out of 5");
        scanner.close();
    }

    
    private static int runQuiz(String[] questions, String[][] options, char[] answers, Scanner scanner) {
        int score = 0;

        
        List<Integer> questionOrder = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            questionOrder.add(i);
        }

        
        Collections.shuffle(questionOrder);

        
        for (int i : questionOrder) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Your answer: ");
            char answer = scanner.next().toUpperCase().charAt(0);

            if (answer == answers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer was " + answers[i] + ".\n");
            }
        }

        System.out.println("Section completed! Your score: " + score + " out of " + questions.length);
        return score;
    }
}
