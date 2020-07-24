package model;

<<<<<<< HEAD
=======

>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
import java.util.List;

public class HomeModel
{
<<<<<<< HEAD
    private String question;
=======
    private String city;
    private String name;
    private String answer;
    private String question;
    private int upvotes;

>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0

    public HomeModel() {
    }

<<<<<<< HEAD
=======
    public String getCity() {

        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

<<<<<<< HEAD
    @Override
    public String toString() {
        return "HomeModel{" +
                "question='" + question + '\'' +
=======
    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }



    public HomeModel(String city, String name, String answer, String question, int upvotes, String profile, boolean isAnswered, List<String> tags) {
        this.city = city;
        this.name = name;
        this.answer = answer;
        this.question = question;
        this.upvotes = upvotes;

    }

    @Override
    public String toString() {
        return "HomeModel{" +
                "city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", answer='" + answer + '\'' +
                ", question='" + question + '\'' +
                ", upvotes=" + upvotes +
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
                '}';
    }
}

