package electricity.prices.actions.MinMaxAvg;

public record MinMaxAvgLine<T>(String PriceType, T price, StringBuilder hours, String unit) {

    @Override
    public String toString() {
        return PriceType() + ": " + price() + " " + unit() + (hours != null && !hours.isEmpty() ? " klockan " + hours() : "");
    }
}
