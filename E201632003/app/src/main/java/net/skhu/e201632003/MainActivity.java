package net.skhu.e201632003;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    ArrayList<Item> arrayList;
    ItemEditDialogFragment itemEditDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<Item>();
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myRecyclerViewAdapter);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText e1 = (EditText) findViewById(R.id.stuNumber);
                EditText e2 = (EditText) findViewById(R.id.stuName);
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                e1.setText("");
                e2.setText("");
                arrayList.add(new Item(s1, s2));
                myRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }

    public void showItemEditDialog() {
        if (itemEditDialogFragment == null)
            itemEditDialogFragment = new ItemEditDialogFragment();
        itemEditDialogFragment.show(getSupportFragmentManager(), "EditDialog");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_remove)
            arrayList.clear();
        else if (id == R.id.action_add)
            showItemEditDialog();
        myRecyclerViewAdapter.notifyDataSetChanged();
        return true;
    }
}
