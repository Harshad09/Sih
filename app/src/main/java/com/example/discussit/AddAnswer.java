package com.example.discussit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapter.AddAnswerAdapter;
import model.AddAnswerModel;
import model.AddAnswerName;
<<<<<<< HEAD
import model.QuestionIdModel;
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0

public class AddAnswer extends AppCompatActivity {

    Toolbar toolbar,toolbar2;

    private ProgressBar progressBar;

    private RecyclerView que_recycler_view;
    private RecyclerView.Adapter mDataAdapter;
    private AddAnswerModel addAnswerModel = new AddAnswerModel();
//    private AddAnswerName addAnswerName = new AddAnswerName();
<<<<<<< HEAD
    private QuestionIdModel questionIdModel = new QuestionIdModel();

    private List<String> knowledge;
    private List<AddAnswerModel> allQus = new ArrayList<>();
    private List<String> questionId = new ArrayList<>();
    private List<String> userId = new ArrayList<>();
=======

    private List<String> knowledge;
    private List<AddAnswerModel> allQus = new ArrayList<>();
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
//    private List<AddAnswerName> allName = new ArrayList<>();

    //firebase obj
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_answer);

        toolbar = findViewById(R.id.toolbar);
        toolbar2 = findViewById(R.id.toolbar2_add_ans);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Answer");
<<<<<<< HEAD
        toolbar.setLogo(R.drawable.account);
=======
        toolbar.setLogo(R.drawable.ic_launcher_user_foreground);
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0

        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle("QUESTIONS FOR YOU");
        toolbar2.setLogo(R.drawable.ic_stars);

        que_recycler_view = findViewById(R.id.que_recycler_view);

        progressBar =  findViewById(R.id.progressBarMain);
        progressBar.setVisibility(View.VISIBLE);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        que_recycler_view.setLayoutManager(layoutManager);
<<<<<<< HEAD
        mDataAdapter = new AddAnswerAdapter(this,allQus,questionId,userId);
=======
        mDataAdapter = new AddAnswerAdapter(this,allQus);
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
        que_recycler_view.setAdapter(mDataAdapter);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        readTags(new MyCallback() {
            @Override
            public void onCallBack(List<String> tags) {

                Log.d("knowledge", tags.toString());
                //Fetching all the questions that matches with the user's knowledge,i.e question tag == knowledge tag//
            db.collectionGroup("question").whereArrayContainsAny("Tags", Arrays.asList(tags.get(0),tags.get(1),tags.get(2)))
                        .addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                                if (e != null) {
                                    Log.w("error", "Listen failed.", e);
                                    return;
                                }
                                allQus.clear();
<<<<<<< HEAD
                                questionId.clear();
                                for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
//                                    List<String> eligible = (List<String>) doc.get("eligibleUsers");

                                        progressBar.setVisibility(View.INVISIBLE);

                                        addAnswerModel = doc.toObject(AddAnswerModel.class);
                                        allQus.add(addAnswerModel);

//                                        questionIdModel.setQuestionId(doc.getId());
                                        String queid = doc.getId();
                                        questionId.add(queid);

                                        String user = doc.getReference().getParent().getParent().getId();
                                        userId.add(user);
=======
                                for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                                    List<String> eligible = (List<String>) doc.get("eligibleUsers");
                                    if (eligible.contains("user3")) {
                                        progressBar.setVisibility(View.INVISIBLE);
                                        addAnswerModel = doc.toObject(AddAnswerModel.class);
                                        allQus.add(addAnswerModel);
                                    }
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
                                }
                                mDataAdapter.notifyDataSetChanged();

                            }
                        });

//                        registration.remove();
//                        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            progressBar.setVisibility(View.INVISIBLE);
//                            for (final QueryDocumentSnapshot document : task.getResult()) {
//
//                                  addAnswerModel = document.toObject(AddAnswerModel.class);
//                                  //addAnswerName = document.toObject(AddAnswerName.class);
////                                Toast.makeText(AddAnswer.this, document.getId(), Toast.LENGTH_SHORT).show();
//                                  Log.d("har", document.getId() + " => " + document.getData());
////
////                                  String udoc = document.getId();
////
////                                  DocumentReference UserName = document.getReference();
////                                 String nameId =  UserName.getParent().getParent().getId();
////                                 Log.d("har",nameId);
////                                 db.collection("Users").document(nameId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
////                                     @Override
////                                     public void onComplete(@NonNull Task<DocumentSnapshot> task) {
////                                         DocumentSnapshot userName = task.getResult();
////                                        String name =  userName.getString("Name");
////                                         Log.d("har",name);
////                                         addAnswerName = userName.toObject(AddAnswerName.class);
////                                     }
////                                 });
//
//
////                                 document.getReference().getParent().getParent()
////                                         .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
////                                     @Override
////                                     public void onComplete(@NonNull Task<DocumentSnapshot> task) {
////                                         if (task.isSuccessful()){
////                                             DocumentSnapshot document2 = task.getResult();
////                                             if (document2.exists()){
////                                                 Log.d("y",document2.getString("Name"));
////
////                                                 addAnswerName = document2.toObject(AddAnswerName.class);
////                                             }
////                                         }
////                                     }
////                                 });
//                                allQus.add(addAnswerModel);
////                                allName.add(addAnswerName);
//                            }
//                            mDataAdapter.notifyDataSetChanged();
//                        } else {
//                            Log.d("data2", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });

            }
        });

        //Initialized and assign variable

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set add_answer selected

        bottomNavigationView.setSelectedItemId(R.id.add_answer);

        //Perform ItemSelectListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_answer:
                        return true;

                    case R.id.my_content:
                        startActivity(new Intent(getApplicationContext(), MyContent.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.notification:
                        startActivity(new Intent(getApplicationContext(),Notification.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.search:
                startActivity(new Intent(getApplicationContext(), AddAnswer.class));
                overridePendingTransition(0,0);
                return true;

            case R.id.ask:
                startActivity(new Intent(getApplicationContext(),AddQuestion.class));
                overridePendingTransition(0,0);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

   public void readTags(final MyCallback myCallback){

       //Fetching the user's current knowledge array//
       DocumentReference user = db.collection("Users").document("user3");
       user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
           @Override
           public void onComplete(@NonNull Task<DocumentSnapshot> task) {
               if (task.isSuccessful()) {
                   DocumentSnapshot document = task.getResult();
                   if (document.exists()) {
                       knowledge = (List<String>) document.get("knowledge");
                       myCallback.onCallBack(knowledge);
                   }
               }
           }
       });

   }

}
