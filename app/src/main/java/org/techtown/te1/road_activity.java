package org.techtown.te1;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

        public class road_activity extends AppCompatActivity {
            private ListView listview ;
            private RoadAdapter adapter;
            private List<String> list;
            private boolean lastItemVisibleFlag = false;
            private int page = 0;                           // 페이징변수. 초기 값은 0 이다.
            private final int OFFSET = 20;                  // 한 페이지마다 로드할 데이터 갯수.
            private boolean mLockListView = false;
            RecyclerView mRecyclerView = null ;
            RoadAdapter mAdapter = null ;
            ArrayList<roadlist> mList = new ArrayList<roadlist>();// 데이터 불러올때 중복안되게 하기위한 변수


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.road_activity);

            }
            public void addItem(Drawable icon, String title, String roadtime, String writetime) {
                roadlist item = new roadlist();

                item.setIcon(icon);
                item.setTitle(title);
                item.setroadtime(roadtime);
                item.setwritetime(writetime);

                mList.add(item);
            }



            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                roadlist item = (roadlist) parent.getItemAtPosition(position) ;

                String titleStr = item.getTitle() ;
                String roadtimeStr = item.getroadTime() ;
                String writetimeStr = item.getwriteTime() ;
                Drawable iconDrawable = item.getIcon() ;
            }

            private void getItem(){

                // 리스트에 다음 데이터를 입력할 동안에 이 메소드가 또 호출되지 않도록 mLockListView 를 true로 설정한다.
                mLockListView = true;

                // 다음 20개의 데이터를 불러와서 리스트에 저장한다.
                for(int i = 0; i < 10; i++){
                    String label = "Label " + ((page * OFFSET) + i);
                    list.add(label);
                }

                // 1초 뒤 프로그레스바를 감추고 데이터를 갱신하고, 중복 로딩 체크하는 Lock을 했던 mLockListView변수를 풀어준다.
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        adapter.notifyDataSetChanged();
                        mLockListView = false;
                    }
                },1000);
            }
        }

