package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.discussit.R;

import java.util.List;

import model.HomeModel;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>
{
    private Context mcontext;
    private List<HomeModel> entity;

    public HomeAdapter(Context mcontext, List<HomeModel> entity) {
        this.mcontext = mcontext;
        this.entity = entity;
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = LayoutInflater.from(mcontext).inflate(R.layout.feed_layout,parent,false);
        return new HomeViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        HomeModel homeModel =  entity.get(position);
        holder.username.setText(homeModel.getName());
        holder.city.setText(homeModel.getCity());
        holder.question.setText(homeModel.getQuestion());
        holder.answer.setText(homeModel.getAnswer());
        holder.upvotes.setText(homeModel.getUpvotes()+"");

        holder.upvoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.name);//taking name
            city = itemView.findViewById(R.id.other_info);//taking city
            question = itemView.findViewById(R.id.question);//taking question
            answer = itemView.findViewById(R.id.answer);//taking answer
            upvotes = itemView.findViewById(R.id.votes);//taking votes
            upvoteBtn = itemView.findViewById(R.id.upVote_btn); //upvote btn
        }
    }

}