package com.example.discussit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Add_pert_answer extends AppCompatActivity {

    private TextView Question ;
    private EditText Answer;
    private Button Submit;
    private Map<String,Object> insertValues = new HashMap<>();

    private Map<String,Object> AllAnswers = new HashMap<>();//Info of the current user to add in target user question document.

    //User Id of this user i.e (who is answering the questiion).
    String currentUserId;

    //Answer Id of this answer.
    String currentanswerId;

    //User Id of the user who is asking the question.
    String targtUserId;

    //Question Id of the question asked by the targetUserId.
    String targetQuestinId;


    //Firebase
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pert_answer);

        Answer = findViewById(R.id.add_pert_answer);
        Submit = findViewById(R.id.ans_submit_btn);




        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String answer = Answer.getText().toString();

                insertValues.put("answer",answer);
                insertValues.put("queId",targetQuestinId);
                insertValues.put("upvotes",0);
                insertValues.put("userId",targtUserId);


                AllAnswers.put("ansId",currentanswerId);//answer Id of this answer
                AllAnswers.put("userId",currentUserId);//User Id of the user //so that this answer can be fetch from question document.
                AllAnswers.put("upvotes",0);

                //Inserting Value in database

                db.collection("Users").document("user3").collection("answer").document()
                        .set(insertValues);

                db.collection("Users").document("pqr").collection("question")
                        .document("quesId").update("AllAnswers", FieldValue.arrayUnion(AllAnswers));

            }
        });


    }
}
