package imitate.project.activity.databinding.ui;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import imitate.project.R;
import imitate.project.activity.databinding.adapter.ListViewAdapter;
import imitate.project.activity.databinding.adapter.RecyclerViewAdapter;
import imitate.project.activity.databinding.model.EmployeeInfo;
import imitate.project.activity.databinding.utils.DataUtils;
import imitate.project.base.BaseActivity;
import imitate.project.base.mvp.BasePresenter;
import imitate.project.databinding.ActivityBindSeniorBinding;


/**
 * databinding -高级
 * 入门篇-列表绑定+自定义属性
 */

public class BindSeniorActivity extends BaseActivity {

    ActivityBindSeniorBinding binding;
    private ListViewAdapter mAdapter;
    private List<EmployeeInfo> mEmployeeInfos;

    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bind_senior);
        mEmployeeInfos = new ArrayList<>();
        mEmployeeInfos.addAll(DataUtils.getEmployees());
        //ListView的使用
        mAdapter = new ListViewAdapter(this, mEmployeeInfos);
        binding.setAdapter(mAdapter);
        //RecyclerView的使用
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerViewAdapter = new RecyclerViewAdapter(mEmployeeInfos);
        binding.mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_senior;
    }

    @Override
    protected void initData() {

    }

}
