package electricity.prices.actions.MinMaxAvg;

public record MinMaxAvgLine(String PriceType, String price, StringBuilder hours, String unit) {

    @Override
    public String toString() {
        return PriceType() + ": " + price() + " " + unit() + (hours != null && !hours.isEmpty() ? " klockan " + hours() : "");
    }
}
