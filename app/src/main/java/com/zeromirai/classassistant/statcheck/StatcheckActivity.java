package com.zeromirai.classassistant.statcheck;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zeromirai.classassistant.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatcheckActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> list;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statcheck);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        findViewById(R.id.commit).setOnClickListener(this);
        initData();
        //布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        adapter = new ListAdapter(list, this);
        recyclerView.setAdapter(adapter);
        //添加分割线
        recyclerView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
        adapter.setRecyclerViewOnItemClickListener(new ListAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                //设置选中的项
                adapter.setSelectItem(position);
            }

            @Override
            public boolean onItemLongClickListener(View view, int position) {
                adapter.setShowBox();
                //设置选中的项
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        //获取你选中的item
        Map<Integer, Boolean> map = adapter.getMap();
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i)) {
                Log.d("TAG", "你选了第：" + i + "项");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //全选
            case R.id.all:
                Map<Integer, Boolean> map = adapter.getMap();
                for (int i = 0; i < map.size(); i++) {
                    map.put(i, true);
                    adapter.notifyDataSetChanged();
                }
                break;
            //全不选
            case R.id.no_all:
                Map<Integer, Boolean> m = adapter.getMap();
                for (int i = 0; i < m.size(); i++) {
                    m.put(i, false);
                    adapter.notifyDataSetChanged();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private String[] data={"1 唐正一","2 陈煜恒","3 袁木","4 秦海钧","5 周彦飞","6 杨劲寅","7 赵家琪","8 余是廣","9 商上","10 龚俊",
            "11 李晓杰","12 李嘉伟","13 李军","14 杜崇智","15 吴佳兴","16 李希畅","17 程实","18 李浩铮","19 周泰宇","20 孙健",
            "21 冯逸楠","22 张翔","23 喻志培","24 周杰","25 吴任伟","26 单家辉","27 郑永昌","28 郭嘉璐",
            "29 刘琪","30 官宇霞", "31 刘婧伊","32 曾瑾","33 张馨蓉"};
    /**
     * 为列表添加测试数据
     */
    private void initData() {
//        File directory = Environment.getExternalStorageDirectory();
//        File[] files = directory.listFiles();

        list = new ArrayList<>();
        for (String student: data) {
            list.add(student);
        }
    }
}
