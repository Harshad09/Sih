package com.example.discussit;

import androidx.annotation.NonNull;
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


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapter.HomeAdapter;
import model.HomeModel;
import model.QuestionFeed;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView feedRecyclerView;
    private RecyclerView.Adapter mDataAdapter;
    private ProgressBar progressBar;


      public String name;
      public HomeModel homeModel = new HomeModel();
      public List<HomeModel> entity = new ArrayList<>();

    //List to store all question that match perticular requirements
    List<QuestionFeed> questionList ;

    QuestionFeed questionFeed;

    List<String> idOfQuestions;

    //firebase obj
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    FirebaseStorage storage = FirebaseStorage.getInstance();//getting instance of the firebase storage

    StorageReference storageRef = storage.getReference();// Create a storage reference from our app


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        toolbar.setLogo(R.drawable.ic_launcher_user_foreground);

        feedRecyclerView = findViewById(R.id.recyclerview);


        //Fetching data in the main feedRecyclerView that is questions and answers
        //setting adapter and recyclerview


        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        feedRecyclerView.setLayoutManager(layoutManager);
        mDataAdapter = new HomeAdapter(this,entity);
        feedRecyclerView.setAdapter(mDataAdapter);

        progressBar =  findViewById(R.id.progressBarMain);
        progressBar.setVisibility(View.VISIBLE);

        readTags(new MyCallback() {
            @Override
            public void onCallBack(List<String> tags) {
                Log.d("callback", tags.toString());

                //Fetching all documents(question) where question tag == explore tag
                db.collectionGroup("question")
                        .whereArrayContainsAny("Tags",Arrays.asList(tags.get(0), tags.get(1), tags.get(2)))
                        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.INVISIBLE);
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if(document.getBoolean("IsAnswered")==true){


                                    homeModel = document.toObject(HomeModel.class);
                                    entity.add(homeModel);




//                                      HomeModel homeModel = document.toObject(HomeModel.class);
//                                      entity.add(homeModel);


//                                    homeModel.setCity(document.getString("city"));
//                                    homeModel.setName(document.getString("name"));
//                                    homeModel.setAnswer(document.getString("answer"));
//                                    homeModel.setQuestion(document.getString("question"));
//                                    homeModel.setUpvotes(document.getLong("upvotes").intValue());

                                    //mdatalist.add(homeModel);
//                                    List<String> nname = new ArrayList<>();
//                                    nname.add(name);
//                                    Intent intent = new Intent(MainActivity.this,AddAnswer.class);
//                                    intent.putExtra("name",nname.toString());
//                                    startActivity(intent);
                                }

                            }
                                mDataAdapter.notifyDataSetChanged();

                        } else {
                             Log.d("data2", "Error getting documents: ", task.getException());
                        }
                    }
                });


            }
        });


        //Cloud function code

//        db.collectionGroup("question").get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()){
//                            for(QueryDocumentSnapshot document :task.getResult()){
//                                if (document.getBoolean("IsAnswered") == true) {
//                                    idOfQuestions.add(document.getId());//getting Id's of all question document in the database.
//                                }
//                            }
//                        }
//                    }
//                });
//
//
//        for (String id : idOfQuestions) {
//
//            db.collectionGroup("answer").whereEqualTo("quesId", id).orderBy("upvotes", Query.Direction.DESCENDING).limit(1)
//                    .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                    if (task.isSuccessful()) {
//
//                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            document.getString("answer");
//                            document.getString("upvotes");
//                            //Fetching personal data of the user who has got highest voted answer//
//                            document.getReference().getParent().getParent().get()
//                                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                                    if (task.isSuccessful()){
//                                        DocumentSnapshot document2 = task.getResult();
//                                        if (document2.exists()){
//                                            document2.getString("name");
//                                            document2.getString("city");
//                                            document2.getString("profile");
//                                        }
//                                    }
//                                }
//                            });
//
//                        }
//                    }
//
//                }
//            });
//
//        }
        //cloud function code


       /* Query question = db.collectionGroup("question");
        Query question_tag = question.whereArrayContains("Tags",Arrays.asList("a"));
         question_tag.whereArrayContains("IsAnswered",true).
                 get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {

                        Log.d("data", document.getId() + " => " + document.getData());

                    }
                } else {
                    Log.d("data2", "Error getting documents: ", task.getException());
                }
            }
        });*/



        //Initialized and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        //Set home screen selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform ItemSelectListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_answer:
                        startActivity(new Intent(getApplicationContext(), AddAnswer.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.my_content:
                        startActivity(new Intent(getApplicationContext(), MyContent.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.notification:
                        startActivity(new Intent(getApplicationContext(),Chatbot.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
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

        //***HomeAdapter List data fecthing***//
        DocumentReference user = db.collection("Users").document("user3");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if(document.exists()){
                        List<String> explore ;
                        explore = (List<String>) document.get("explore");
                        myCallback.onCallBack(explore);
                    }
                }

            }
        });

    }


}
