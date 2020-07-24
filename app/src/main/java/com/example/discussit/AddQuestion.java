package com.example.discussit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddQuestion extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText write_question,tag_1,tag_2,tag_3 ;
    private Button send;
    private String question,tag1,tag2,tag3;
    ArrayList<String> tags = new ArrayList<>();
    //firebase database instances
    // Access a Cloud Firestore instance from your Activity
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private Map<String,Object> insertValues = new HashMap<>();
    private List<String> eligibleUsers = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);



        //toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Question");
<<<<<<< HEAD
        toolbar.setLogo(R.drawable.account);
=======
        toolbar.setLogo(R.drawable.ic_launcher_user_foreground);
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0



        send = findViewById(R.id.add_que);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Initializing all views objects
                write_question = findViewById(R.id.addQuestion);
                tag_1 = findViewById(R.id.tag1);
                tag_2 = findViewById(R.id.tag2);
                tag_3 = findViewById(R.id.tag3);


                 question = write_question.getText().toString();
                 tag1= tag_1.getText().toString();
                 tag2= tag_2.getText().toString();
                 tag3= tag_3.getText().toString();


                tags.add(tag1);
                tags.add(tag2);
                tags.add(tag3);

                //creating a map to add values.
//                insertValues.put("Question",question);
//                insertValues.put("Tags",tags);
//                insertValues.put("IsAnswered",false);
                //insertValues.put("timestamp", FieldValue.serverTimestamp());

                //Inserting values in the database.

                db.collection("Users").whereArrayContainsAny("knowledge", Arrays.asList(tag1,tag2,tag3)).get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()){
                                    for (QueryDocumentSnapshot document : task.getResult()){
                                        eligibleUsers.add(document.getId());
                                    }
                                    insertValues.put("question",question);
                                    insertValues.put("tags",tags);
                                    insertValues.put("isAnswered",false);
                                    insertValues.put("eligibleUsers",eligibleUsers);
                                }



                                db.collection("Users").document("user3").collection("question").document()
                                        .set(insertValues,SetOptions.merge())
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(AddQuestion.this, "Data inserted ", Toast.LENGTH_SHORT).show();

                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {

                                            }
                                        });
                            }
                        });




            }
        });



    }

}
