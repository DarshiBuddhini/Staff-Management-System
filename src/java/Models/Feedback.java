package Models;
public class Feedback {
    
    // Define VAriables  
    int feedback_id;
    String member_code;
    String feedback;

    public Feedback() {
    }

    public Feedback(String member_code, String feedback) {
        this.member_code = member_code;
        this.feedback = feedback;
    }

    public int getFeedbackId() {
        return feedback_id;
    }

    public void setFeedbackId(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getMemberCode() {
        return member_code;
    }

    public void setMemberCode(String member_code) {
        this.member_code = member_code;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    
}
