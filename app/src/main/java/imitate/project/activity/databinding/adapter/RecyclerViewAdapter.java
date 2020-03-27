package imitate.project.activity.databinding.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import imitate.project.BR;
import imitate.project.R;
import imitate.project.activity.databinding.model.EmployeeInfo;


/**
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private List<EmployeeInfo> mData;

    public RecyclerViewAdapter(List<EmployeeInfo> mData) {
        this.mData = mData;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_test, null, false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        EmployeeInfo info = mData.get(position);
        holder.getBinding().setVariable(BR.employeeInfo, info);
        holder.getBinding().executePendingBindings();//及时刷新
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
