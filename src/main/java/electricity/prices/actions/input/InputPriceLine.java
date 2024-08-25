package electricity.prices.actions.input;

public class InputPriceLine {
    private final String hour;
    private Integer price;
    private final String unit;

    InputPriceLine(String hour, Integer price, String unit) {
        if (hour.isBlank()) {
            throw new IllegalArgumentException("Hour cannot be empty");
        }
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be empty");
        }
        if (unit.isBlank()) {
            throw new IllegalArgumentException("Unit cannot be empty");
        }
        this.hour = hour;
        this.price = price;
        this.unit = unit;
    }

    public String getHour() {
        return hour;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be empty");
        }
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    //@Override
    public String toString() {
        return hour + " " + price + " " + unit;
    }
}
