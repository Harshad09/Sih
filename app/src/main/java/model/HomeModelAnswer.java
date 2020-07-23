package model;

public class HomeModelAnswer {

    private String answer;
    private String questionid;
    private String userid;
    private int upvotes;
    private String imageurl;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public HomeModelAnswer() {
    }

    @Override
    public String toString() {
        return "HomeModelAnswer{" +
                "answer='" + answer + '\'' +
                ", questionid='" + questionid + '\'' +
                ", userid='" + userid + '\'' +
                ", upvote=" + upvotes +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }
}
