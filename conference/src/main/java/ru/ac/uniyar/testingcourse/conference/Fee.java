package ru.ac.uniyar.testingcourse.conference;

/**
 * Registration fee that must be paid by the participant.
 * Not paid when created, should be marked as paid when paid ({@link #pay()})
 */
public class Fee {
    private final Integer amount;
    private Boolean paid = false;

    public Fee(Integer amount) {
        this.amount = amount;
    }

    /**
     * Mark fee as paid
     */
    public void pay() {
        paid = true;
    }

    public Integer getAmount() {
        return amount;
    }

    public Boolean isPaid() {
        return paid;
    }

}
