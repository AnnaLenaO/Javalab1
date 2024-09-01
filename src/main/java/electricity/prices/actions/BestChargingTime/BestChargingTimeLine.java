package electricity.prices.actions.BestChargingTime;

import electricity.prices.actions.PriceLineInterface;

public record BestChargingTimeLine(String hour, Integer price, String unit) implements PriceLineInterface {
    @Override
    public Integer getPrice() {
        return price;
    }
}
