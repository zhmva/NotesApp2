package pro.mitapp.notesapp2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvNotes;
    private NotesAdapter adapter;
    private FloatingActionButton btnOpenAddActivity;
    private List<NotesModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initNotesRecycler();
    }

    private void initViews() {
        btnOpenAddActivity = findViewById(R.id.btn_open_add_activity);
        btnOpenAddActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    private void initNotesRecycler() {
        rvNotes = findViewById(R.id.rv_notes);;
        rvNotes.setAdapter(adapter);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            NotesModel model = new NotesModel(data.getStringExtra("title"), data.getStringExtra("description"), "");
            adapter.addNote(model);
        }
        if (data.getBooleanExtra("isUpdate", false)){
            NotesModel model = new NotesModel(data.getStringExtra("title"), data.getStringExtra("description"), "");
        }
    }
}