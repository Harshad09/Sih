package adapter;

<<<<<<< HEAD
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
=======
import android.content.Context;
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.discussit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;
=======
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.discussit.R;
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0

import java.util.List;

import model.HomeModel;
<<<<<<< HEAD
import model.HomeModelAnswer;

import static com.example.discussit.MainActivity.currentUser;
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>
{
<<<<<<< HEAD
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    FirebaseStorage storage = FirebaseStorage.getInstance();//getting instance of the firebase storage


    private Context mcontext;
    private List<HomeModel> entity;
    private List<HomeModelAnswer> topVoteAns;
    private List<String> answerId;
    private List<String> userid;

    public HomeAdapter(Context mcontext, List<HomeModel> entity, List<HomeModelAnswer> topVoteAns, List<String> answerId, List<String> userid) {
        this.mcontext = mcontext;
        this.entity = entity;
        this.topVoteAns = topVoteAns;
        this.answerId = answerId;
        this.userid = userid;
=======
    private Context mcontext;
    private List<HomeModel> entity;

    public HomeAdapter(Context mcontext, List<HomeModel> entity) {
        this.mcontext = mcontext;
        this.entity = entity;
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = LayoutInflater.from(mcontext).inflate(R.layout.feed_layout,parent,false);
        return new HomeViewHolder(rootView);
    }

    @Override
<<<<<<< HEAD
    public void onBindViewHolder(@NonNull final HomeViewHolder holder, int position) {
        HomeModel homeModel =  entity.get(position);
        final HomeModelAnswer homeModelAnswer = topVoteAns.get(position);
        final String answerid = answerId.get(position);
        final String user = userid.get(position);

        holder.username.setText("placeholder");
        holder.city.setText("city");
        holder.question.setText(homeModel.getQuestion());
        holder.answer.setText(homeModelAnswer.getAnswer());
        holder.upvotes.setText(homeModelAnswer.getUpvotes()+"");
        Picasso.get().load(homeModelAnswer.getImageurl()).placeholder(R.drawable.img).fit().into(holder.relatedImage);

        if (homeModelAnswer.getUpvoters().contains(currentUser)){
            holder.upvoteBtn.setBackgroundTintList(ContextCompat.getColorStateList(mcontext, R.color.colorPrimary));
        }
        else{
            holder.upvoteBtn.setBackgroundTintList(ContextCompat.getColorStateList(mcontext, R.color.unlike));

        }
=======
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        HomeModel homeModel =  entity.get(position);
        holder.username.setText(homeModel.getName());
        holder.city.setText(homeModel.getCity());
        holder.question.setText(homeModel.getQuestion());
        holder.answer.setText(homeModel.getAnswer());
        holder.upvotes.setText(homeModel.getUpvotes()+"");
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0

        holder.upvoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                if (homeModelAnswer.getUpvoters().contains(currentUser)){
                    holder.upvoteBtn.setBackgroundTintList(ContextCompat.getColorStateList(mcontext,R.color.unlike));
                    db.collection("Users").document(user).collection("answer")
                            .document(answerid).update("upvotes",FieldValue.increment(-1));
                    db.collection("Users").document(user).collection("answer")
                            .document(answerid).update("upvoters",FieldValue.arrayRemove(currentUser));

                }
                else{
                    holder.upvoteBtn.setBackgroundTintList(ContextCompat.getColorStateList(mcontext, R.color.colorPrimary));
                    db.collection("Users").document(user).collection("answer")
                            .document(answerid).update("upvotes",FieldValue.increment(1));
                    db.collection("Users").document(user).collection("answer")
                            .document(answerid).update("upvoters",FieldValue.arrayUnion(currentUser));

                }
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0

            }
        });

    }

    @Override
    public int getItemCount() {
        return entity.size();
    }


    public class HomeViewHolder extends RecyclerView.ViewHolder {
        public TextView username,city,question,answer,upvotes;
        public Button upvoteBtn;
<<<<<<< HEAD
        public ImageView relatedImage;
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.name);//taking name
            city = itemView.findViewById(R.id.other_info);//taking city
            question = itemView.findViewById(R.id.question);//taking question
            answer = itemView.findViewById(R.id.answer);//taking answer
            upvotes = itemView.findViewById(R.id.votes);//taking votes
            upvoteBtn = itemView.findViewById(R.id.upVote_btn); //upvote btn
<<<<<<< HEAD
            relatedImage = itemView.findViewById(R.id.required_img);
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
        }
    }

}