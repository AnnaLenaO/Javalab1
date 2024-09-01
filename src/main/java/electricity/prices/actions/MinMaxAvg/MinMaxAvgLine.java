package electricity.prices.actions.MinMaxAvg;

public record MinMaxAvgLine(String PriceType, String price, StringBuilder hours, String unit) {
    @Override
    public String toString() {
        return this.PriceType() +
                ": " +
                this.price() +
                " " +
                this.unit() +
                (hours != null && !hours.isEmpty() ? " klockan " + this.hours() : "");
    }
}

