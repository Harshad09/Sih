package com.example.discussit;

<<<<<<< HEAD
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
=======
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
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0

public class Add_pert_answer extends AppCompatActivity {

    private TextView Question ;
    private EditText Answer;
<<<<<<< HEAD
    private ImageView relatedImage;
    private Button Submit,ChooseImage;
    private Map<String,Object> insertValues = new HashMap<>();
    private Uri filePath;
    private Task<Uri> DownloadUrl;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    // Create a storage reference from our app
    private StorageReference storageRef = storage.getReference();
=======
    private Button Submit;
    private Map<String,Object> insertValues = new HashMap<>();
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0

    private Map<String,Object> AllAnswers = new HashMap<>();//Info of the current user to add in target user question document.

    //User Id of this user i.e (who is answering the questiion).
    String currentUserId;

    //Answer Id of this answer.
    String currentanswerId;

    //User Id of the user who is asking the question.
    String targtUserId;

    //Question Id of the question asked by the targetUserId.
    String targetQuestinId;

<<<<<<< HEAD
    String answer;

    private final int PICK_IMAGE_REQUEST = 22;

    //Firebase


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);
                relatedImage.setVisibility(View.VISIBLE);
                relatedImage.setImageBitmap(bitmap);
            }

            catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }
=======

    //Firebase
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pert_answer);

        Answer = findViewById(R.id.add_pert_answer);
        Submit = findViewById(R.id.ans_submit_btn);
<<<<<<< HEAD
        ChooseImage = findViewById(R.id.addImage);
        Question = findViewById(R.id.pert_que);
        relatedImage = findViewById(R.id.relatedImage);

        String question = getIntent().getStringExtra("question");
        targetQuestinId= getIntent().getStringExtra("questionId");
        targtUserId = getIntent().getStringExtra("userId");
        Question.setText(question);

        currentUserId = "8ZXeHfadswSGHqIcPkZZ";

        ChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(
                        Intent.createChooser(
                                intent,
                                "Select Image from here..."),
                        PICK_IMAGE_REQUEST);
            }
        });
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0




        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

<<<<<<< HEAD
                answer = Answer.getText().toString();

                //Inserting Value in database

                currentanswerId = db.collection("Users").document(currentUserId).collection("answer").document().getId();


                if (filePath != null) {
                    final StorageReference imageRef = storageRef.child("images/"+ currentanswerId);
                    imageRef.putFile(filePath)
                            .addOnSuccessListener(
                                    new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                        @Override
                                        public void onSuccess(
                                                UploadTask.TaskSnapshot taskSnapshot)
                                        {

                                            imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                @Override
                                                public void onSuccess(Uri uri) {
//                                                    Log.d("imageUrl",uri.toString());
                                                    insertValues.put("imageUrl",uri.toString());
                                                    insertValues.put("answer",answer);
                                                    insertValues.put("queId",targetQuestinId);
                                                    insertValues.put("upvotes",0);
                                                    insertValues.put("userId",targtUserId);
                                                    db.collection("Users").document(currentUserId).collection("answer").document(currentanswerId)
                                                            .set(insertValues);
                                                }
                                            });

                                            Toast.makeText(Add_pert_answer.this, "Your question uploaded successfully", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(Add_pert_answer.this,MainActivity.class);
                                            startActivity(intent);
                                        }

                                    });

                }

=======

                String answer = Answer.getText().toString();

                insertValues.put("answer",answer);
                insertValues.put("queId",targetQuestinId);
                insertValues.put("upvotes",0);
                insertValues.put("userId",targtUserId);
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0


                AllAnswers.put("ansId",currentanswerId);//answer Id of this answer
                AllAnswers.put("userId",currentUserId);//User Id of the user //so that this answer can be fetch from question document.
                AllAnswers.put("upvotes",0);

<<<<<<< HEAD
                db.collection("Users").document(targtUserId).collection("question")
                        .document(targetQuestinId).update("AllAnswers", FieldValue.arrayUnion(AllAnswers));

            }


=======
                //Inserting Value in database

                db.collection("Users").document("user3").collection("answer").document()
                        .set(insertValues);

                db.collection("Users").document("pqr").collection("question")
                        .document("quesId").update("AllAnswers", FieldValue.arrayUnion(AllAnswers));

            }
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
        });


    }
}
