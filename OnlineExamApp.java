class Exam {
    // This is the synchronized method for submitting answers.
    synchronized void submitAnswer(String studentName, String answer) {
        System.out.println(studentName + " submitted answer: " + answer);
        try {
            Thread.sleep(1000);  // Simulating time taken to submit an answer
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class SubmitAnswerThread extends Thread {
    Exam exam;
    String studentName;
    String answer;

    SubmitAnswerThread(Exam exam, String studentName, String answer) {
        this.exam = exam;
        this.studentName = studentName;
        this.answer = answer;
    }

    public void run() {
        exam.submitAnswer(studentName, answer);
    }
}

class ViewQuestionThread implements Runnable {
    String studentName;

    ViewQuestionThread(String studentName) {
        this.studentName = studentName;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(studentName + " is viewing question " + i);
            try {
                Thread.sleep(500);  // Simulating the time taken to view a question
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class OnlineExamApp {
    public static void main(String[] args) {
        Exam exam = new Exam();

        // Creating threads for students submitting answers (synchronized)
        SubmitAnswerThread t1 = new SubmitAnswerThread(exam, "Aditi", "Answer A");
        SubmitAnswerThread t2 = new SubmitAnswerThread(exam, "Vaishnavi", "Answer B");

        // Creating threads for students viewing questions (unsynchronized)
        ViewQuestionThread s1 = new ViewQuestionThread("Suvarna");
        ViewQuestionThread s2 = new ViewQuestionThread("Divya");

        Thread t3 = new Thread(s1);
        Thread t4 = new Thread(s2);

        // Starting the threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}