package mutuma.com.week52challenge.model;

import android.arch.lifecycle.ViewModel;

import java.util.List;

public class TotalAmountSavedModel extends ViewModel {

    public TotalAmountSavedModel() {
    }


    public List<WeekDescription> getAmountTobeSaved(Integer amount) {
        ModelRepository modelRepository = new ModelRepository(amount);
        return modelRepository.getWeekDescriptions();
    }
}
