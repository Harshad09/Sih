package model;

public class AddAnswerName
{
    private String Name;

    public AddAnswerName() {
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "AddAnswerName{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
