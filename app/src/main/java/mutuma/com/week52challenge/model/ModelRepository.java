package mutuma.com.week52challenge.model;

import java.util.ArrayList;
import java.util.List;

import mutuma.com.week52challenge.Utils;

public class ModelRepository {
    /**
     *
     */
    private List<WeekDescription> weekDescriptions;
    private Integer amount;

    /**
     *
     * @param amount
     */
    public ModelRepository(Integer amount) {
        weekDescriptions = new ArrayList<>();
        this.amount = amount;
    }

    /**
     *
     * @return weekly saved amount,
     * amount to deposit
     */
    public List<WeekDescription> getWeekDescriptions(){
        Long sum = 0l, weekDeposit = 0l;

        for (int i = 1; i <= 52 ; i++) {
            WeekDescription weekDescription = new WeekDescription();

            weekDeposit = Long.valueOf(amount*i);
            sum += weekDeposit;
            weekDescription.setWeek(i);
            weekDescription.setWeeklyDeposit(Utils.formattedAmount(weekDeposit));
            weekDescription.setTotalSaved(Utils.formattedAmount(sum));
            weekDescriptions.add(weekDescription);
        }
        return weekDescriptions;
    }
}
