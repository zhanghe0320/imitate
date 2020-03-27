package imitate.project.activity.databinding.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import imitate.project.BR;
import imitate.project.R;
import imitate.project.activity.databinding.model.EmployeeInfo;


/**
 */

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<EmployeeInfo> mData;

    public ListViewAdapter(Context context, List<EmployeeInfo> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public EmployeeInfo getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding = null;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.list_item_test, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        EmployeeInfo info = mData.get(position);
        if (info != null) {
            binding.setVariable(BR.employeeInfo, info);
        }
        binding.executePendingBindings();//及时刷新
        return binding.getRoot();
    }
}
