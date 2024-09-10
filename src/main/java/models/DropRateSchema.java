package models;

public class DropRateSchema {
    private String code;
    private int rate;
    private int min_quantity;
    private int max_quantity;

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public int getRate() {
	return rate;
    }

    public void setRate(int rate) {
	this.rate = rate;
    }

    public int getMin_quantity() {
	return min_quantity;
    }

    public void setMin_quantity(int min_quantity) {
	this.min_quantity = min_quantity;
    }

    public int getMax_quantity() {
	return max_quantity;
    }

    public void setMax_quantity(int max_quantity) {
	this.max_quantity = max_quantity;
    }

}
