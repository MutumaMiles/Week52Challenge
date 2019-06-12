package mutuma.com.week52challenge;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mutuma.com.week52challenge.databinding.ActivityMainBinding;
import mutuma.com.week52challenge.model.AmoutToSave;
import mutuma.com.week52challenge.model.ModelRepository;
import mutuma.com.week52challenge.model.TotalAmountSavedModel;
import mutuma.com.week52challenge.model.WeekDescription;

import static android.support.design.widget.BottomSheetBehavior.STATE_COLLAPSED;

public class MainActivity extends AppCompatActivity {
    /**
     * declare instance variables
     */
    ActivityMainBinding binding;
    private BottomSheetBehavior mBottomSheetBehavior;
    private EditText amoutEditText;
    private TotalAmountSavedModel viewModel;
    private WeeklyAmountAdapter amountAdapter;
    private RelativeLayout relativeLayout;
    private TextView totalAmountSaved, viewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(TotalAmountSavedModel.class);

        FrameLayout frameLayout = binding.bottomSheet;

        mBottomSheetBehavior = BottomSheetBehavior.from(frameLayout);


        amoutEditText = binding.amountToSave;
        amoutEditText.addTextChangedListener(new GenericTextWatcher(amoutEditText));
        List<WeekDescription> weekDescriptions = new ArrayList<>();
        amountAdapter = new WeeklyAmountAdapter(weekDescriptions);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(amountAdapter);
        mBottomSheetBehavior.setPeekHeight(0);
        relativeLayout = findViewById(R.id.amount_saved_weekly);
        totalAmountSaved = findViewById(R.id.total_amount_saved);

    }

    /**
     * generic text watcher
     */
    private class GenericTextWatcher implements TextWatcher{
        private View view;

        public GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        /**
         *
         * @param s
         * @param start
         * @param before
         * @param count
         */
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            switch (view.getId()){
                case R.id.amount_to_save:
                    //
                    if(s.toString().equals("")){
                        mBottomSheetBehavior.setPeekHeight(0);
                        return;
                    }
                    try{
                        Integer amount = Integer.parseInt(s.toString());
                        if(Utils.isValidAmount(amount)){
                            amoutEditText.setError("Amount should be less than 50000000");
                            mBottomSheetBehavior.setPeekHeight(0);
                            return;
                        }
                        ModelRepository repository = new ModelRepository(amount);
                        amountAdapter.itemsChanged(repository.getWeekDescriptions());
                        if(amoutEditText.getText().toString().trim().length() == 0){
                            mBottomSheetBehavior.setPeekHeight(0);

                        }else{
                            totalAmountSaved.setText("Amount Saved After 52 weeks : KES " + repository.getWeekDescriptions().get(51).getTotalSaved());
                            mBottomSheetBehavior.setPeekHeight(relativeLayout.getHeight()/3);
                        }

                    }catch (Exception ex){
                        amoutEditText.setError("Please enter a valid amount");
                    }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    /**
     * handle on back pressed
     */
    @Override
    public void onBackPressed() {
        if(mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
           mBottomSheetBehavior.setState(STATE_COLLAPSED);
        }else{
            finish();
        }
    }
}
