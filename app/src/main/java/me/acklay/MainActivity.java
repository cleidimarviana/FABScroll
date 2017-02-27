package me.acklay;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acklay.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvRunList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        String[] strings = new String[]{
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
                "Ten",
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
                "Ten"
        };

        RVAdapter adapter = new RVAdapter(this, strings);
        recyclerView.setAdapter(adapter);
    }
    public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
        private Context mContext;
        private String[] mStrings;

        public RVAdapter(Context context, String[] strings){
            this.mContext = context;
            this.mStrings = strings;
        }

        @Override
        public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item_text_view, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(RVAdapter.ViewHolder viewHolder, int i) {
            viewHolder.textView.setText(mStrings[i]);
        }

        @Override
        public int getItemCount() {
            return mStrings.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            public final TextView textView;

            public ViewHolder(View view){
                super(view);
                textView = (TextView) view;
            }
        }
    }
}
