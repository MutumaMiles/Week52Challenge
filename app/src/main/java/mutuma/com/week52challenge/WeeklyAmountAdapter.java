package mutuma.com.week52challenge;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import mutuma.com.week52challenge.databinding.WeeklyLayoutBinding;
import mutuma.com.week52challenge.model.WeekDescription;

public class WeeklyAmountAdapter extends RecyclerView.Adapter<WeeklyAmountAdapter.WeeklyAmountHolder> {
    private List<WeekDescription> weekDescriptions;

    /**
     *
     * @param weekDescriptions
     */
    public WeeklyAmountAdapter(List<WeekDescription> weekDescriptions) {
        this.weekDescriptions = weekDescriptions;
    }

    /**
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public WeeklyAmountHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        WeeklyLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.weekly_layout, viewGroup, false);
        return new WeeklyAmountHolder(binding);
    }

    /**
     *
     * @param weeklyAmountHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull WeeklyAmountHolder weeklyAmountHolder, int i) {
       WeekDescription weekDescription = weekDescriptions.get(i);
        weeklyAmountHolder.binding.setWeek(weekDescription);
    }

    /**
     *
     * @return size for weekDescriptions
     */
    @Override
    public int getItemCount() {
        return weekDescriptions.size();
    }

    public class WeeklyAmountHolder extends RecyclerView.ViewHolder {
        WeeklyLayoutBinding binding;
        public WeeklyAmountHolder(@NonNull WeeklyLayoutBinding itemBinding) {
            super(itemBinding.getRoot());
            binding = itemBinding;
        }
    }

    /**
     *
     * @param weekDescriptions
     */
    public void itemsChanged(List<WeekDescription> weekDescriptions){
        this.weekDescriptions = weekDescriptions;
        notifyDataSetChanged();
    }
}
