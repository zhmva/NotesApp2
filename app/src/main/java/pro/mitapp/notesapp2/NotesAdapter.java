package pro.mitapp.notesapp2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private LayoutInflater inflater;
    private List<NotesModel> list = new ArrayList<>();


    public NotesAdapter(Context context, Activity activity){
        this.inflater = LayoutInflater.from(context);
    }

    public void addNote(NotesModel model, Activity activity){
        list.add(model);
        notifyDataSetChanged();
    }

    public void updateNotes(NotesModel model, int position){
        list.get(position).setTitle(model.getTitle());
        list.get(position).setDescription(model.getDescription());
        notifyItemChanged(position);

    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_notes, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {

        holder.txtTitle.setText(list.get(position).getTitle());
        holder.txtDescription.setText(list.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = holder.txtTitle.getText().toString();
                String description = holder.txtDescription.getText().toString();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addNote(NotesModel model) {
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle, txtDescription;
        LinearLayout layout;


        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txt_item_title);
            txtDescription = itemView.findViewById(R.id.txt_item_description);

        }
    }
}
