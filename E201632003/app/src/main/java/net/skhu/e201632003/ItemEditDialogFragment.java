package net.skhu.e201632003;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;

public class ItemEditDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final MainActivity activity = (MainActivity) getActivity();
        final Item item = new Item();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("학생 등록");

        final View rootView = activity.getLayoutInflater().inflate(R.layout.item_add, null);

        final EditText stuNumber = (EditText) rootView.findViewById(R.id.stuNumber);
        final EditText stuName = (EditText) rootView.findViewById(R.id.stuName);

        builder.setView(rootView);

        builder.setPositiveButton("저장", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CharSequence c1 = stuNumber.getText();
                CharSequence c2 = stuName.getText();

                item.setStuNumber(c1.toString());
                item.setStuName(c2.toString());

                activity.arrayList.add(item);
                activity.myRecyclerViewAdapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("취소", null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
