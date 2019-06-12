package mutuma.com.week52challenge.model;

public class WeekDescription {
    /**
     * model for weekly saved amount
     */
    private int week;
    /**
     * weeklyDeposit,totalSaved
     */
   private String weeklyDeposit,totalSaved;

    /**
     *
     * @return
     */
    public int getWeek() {
        return week;
    }

    /**
     *
     * @param week
     */
    public void setWeek(int week) {
        this.week = week;
    }

    /**
     *
     * @return
     */
    public String getWeeklyDeposit() {
        return weeklyDeposit;
    }

    /**
     *
     * @param weeklyDeposit
     */
    public void setWeeklyDeposit(String weeklyDeposit) {
        this.weeklyDeposit = weeklyDeposit;
    }

    /**
     *
     * @return
     */
    public String getTotalSaved() {
        return totalSaved;
    }

    /**
     *
     * @param totalSaved
     */
    public void setTotalSaved(String totalSaved) {
        this.totalSaved = totalSaved;
    }
}
