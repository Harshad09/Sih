package adapter;

import android.content.Context;
<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD
import com.example.discussit.Add_pert_answer;
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
import com.example.discussit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import model.AddAnswerModel;
import model.AddAnswerName;
<<<<<<< HEAD
import model.QuestionIdModel;
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0

public class AddAnswerAdapter extends RecyclerView.Adapter<AddAnswerAdapter.AddAnswerViewHolder> {

    //firebase obj
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    DocumentReference documentReference;

    private Context mcontext;
    private List<AddAnswerModel> entity;
<<<<<<< HEAD
    private List<String> questionId;
    private List<String> userId;
//    private List<AddAnswerName> Name;

    public AddAnswerAdapter(Context mcontext, List<AddAnswerModel> entity, List<String> questionId, List<String> userId) {
        this.mcontext = mcontext;
        this.entity = entity;
        this.questionId = questionId;
        this.userId = userId;
=======
//    private List<AddAnswerName> Name;

    public AddAnswerAdapter(Context mcontext, List<AddAnswerModel> entity) {
        this.mcontext = mcontext;
        this.entity = entity;
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
//        this.Name = Name;
    }

    @NonNull
    @Override
    public AddAnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = LayoutInflater.from(mcontext).inflate(R.layout.question_feed,parent,false);
<<<<<<< HEAD
        return new AddAnswerViewHolder(rootView, entity,questionId,mcontext,userId);
=======
        return new AddAnswerViewHolder(rootView);
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
    }

    @Override
    public void onBindViewHolder(@NonNull AddAnswerViewHolder holder, int position) {

        final AddAnswerModel addAnswerModel = entity.get(position);
//        AddAnswerName addAnswerName = Name.get(position);
          holder.answer.setText(addAnswerModel.getQuestion());
//        holder.name.setText("Ask by "+ addAnswerName.getName());

    }

    @Override
    public int getItemCount() {
        return entity.size();
    }

<<<<<<< HEAD
    public class AddAnswerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView answer;
//        public Button cancle;
          List<AddAnswerModel> entity;
          List<String> questionId;
        List<String> userId;
          Context context;
        public AddAnswerViewHolder(@NonNull View itemView, List<AddAnswerModel> entity, List<String> questionId, Context mcontext, List<String> userId) {
=======
    public class AddAnswerViewHolder extends RecyclerView.ViewHolder {
        public TextView answer;
//        public Button cancle;
        public AddAnswerViewHolder(@NonNull View itemView) {
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
            super(itemView);
              answer = itemView.findViewById(R.id.que_feed);
//            name = itemView.findViewById(R.id.Qname);
//            cancle = itemView.findViewById(R.id.cancle_que);
<<<<<<< HEAD
              itemView.setOnClickListener(this);
              this.context = mcontext;
              this.entity = entity;
              this.questionId = questionId;
            this.userId = userId;
        }

        @Override
        public void onClick(View v) {
              Intent intent = new Intent(context, Add_pert_answer.class);
              intent.putExtra("question",entity.get(getAdapterPosition()).getQuestion());
              intent.putExtra("questionId",questionId.get(getAdapterPosition()));
              intent.putExtra("userId",userId.get(getAdapterPosition()));
              context.startActivity(intent);
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
        }
    }
}
