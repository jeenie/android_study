package net.skhu.e06list;

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

public class MainActivity extends AppCompatActivity {
    ItemList itemList;
    int selectedIndex;
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    FirebaseDbService firebaseDbService;
    ItemEditDialogFragment itemEditDialogFragment; // 수정 대화상자 관리자

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 레이아웃 인플레이션

        itemList = new ItemList(); // 데이터 목록 객체 생성

        // 리사이클러 뷰 설정
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, itemList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myRecyclerViewAdapter);

        // firebase DB 서비스 생성
        firebaseDbService = new FirebaseDbService(this, myRecyclerViewAdapter, itemList);
        Button b = (Button) findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText editText = (EditText) findViewById(R.id.editText);
                String title = editText.getText().toString();
                editText.setText("");
                Item item = new Item(title);
                firebaseDbService.addIntoServer(item);
            }
        });
    }

    public void showItemEditDialog(int position) {
        if (itemEditDialogFragment == null) // 대화상자 관리자 객체를 아직 만들지 않았다면
            itemEditDialogFragment = new ItemEditDialogFragment(); // 대화상자 관리자 객체를 만든다
        selectedIndex = position; // 수정할 항목의 index를 대입한다.
        itemEditDialogFragment.show(getSupportFragmentManager(), "EditDialog"); // 화면에 대화상자 보이기
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_remove);
        menuItem.setVisible(myRecyclerViewAdapter.checkedItemCount > 0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_remove) {
            for (int i = itemList.size() - 1; i >= 0; --i)
                if (itemList.get(i).isChecked()) {
                    String key = itemList.getKey(i);
                    firebaseDbService.removeFromServer(key);
                }

        }
        return super.

                onOptionsItemSelected(item);
    }
}