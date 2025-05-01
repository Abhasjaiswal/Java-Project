package quizApplication;

/**
 * This class displays the score/result of the quiz
 * It serves as a bridge between q10.java and resultPage.java
 */
public class score extends resultPage {
    
    private static final long serialVersionUID = 1L;

    /**
     * Create the score frame by calling resultPage constructor
     * @param name Student name
     * @param m Final score
     * @param count Number of correct answers
     */
    public score(String name, int m, int count) {
        // Call parent constructor (resultPage)
        super(name, m, count);
    }
}
