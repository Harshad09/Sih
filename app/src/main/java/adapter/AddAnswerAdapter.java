package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

public class AddAnswerAdapter extends RecyclerView.Adapter<AddAnswerAdapter.AddAnswerViewHolder> {

    //firebase obj
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    DocumentReference documentReference;

    private Context mcontext;
    private List<AddAnswerModel> entity;
//    private List<AddAnswerName> Name;

    public AddAnswerAdapter(Context mcontext, List<AddAnswerModel> entity) {
        this.mcontext = mcontext;
        this.entity = entity;
//        this.Name = Name;
    }

    @NonNull
    @Override
    public AddAnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rootView = LayoutInflater.from(mcontext).inflate(R.layout.question_feed,parent,false);
        return new AddAnswerViewHolder(rootView);
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

    public class AddAnswerViewHolder extends RecyclerView.ViewHolder {
        public TextView answer;
//        public Button cancle;
        public AddAnswerViewHolder(@NonNull View itemView) {
            super(itemView);
              answer = itemView.findViewById(R.id.que_feed);
//            name = itemView.findViewById(R.id.Qname);
//            cancle = itemView.findViewById(R.id.cancle_que);
        }
    }
}
