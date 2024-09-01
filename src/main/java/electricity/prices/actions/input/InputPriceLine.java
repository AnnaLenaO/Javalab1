package electricity.prices.actions.input;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import electricity.prices.actions.CsvInput.CsvInputBean;
import electricity.prices.actions.PriceLineInterface;

public class InputPriceLine implements PriceLineInterface {
    @CsvBindByPosition(position = 0)
    private String hour;

    @CsvCustomBindByPosition(position = 1, converter = CsvInputBean.StringPriceToInteger.class)
    private Integer price;

    @CsvBindByPosition(position = 2)
    private String unit;

    public InputPriceLine() {
    }

    public InputPriceLine(String hour, Integer price, String unit) {
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

    @Override
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

    @Override
    public String toString() {
        return hour + " " + price + " " + unit;
    }
}
