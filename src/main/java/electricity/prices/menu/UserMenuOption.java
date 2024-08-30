package electricity.prices.menu;


public abstract sealed class UserMenuOption permits Headline, Underline, Input, CsvInput, MinMaxAvg, Sort, BestChargingTime, Exit {

}

final class Headline extends UserMenuOption {

}

final class Underline extends UserMenuOption {

}

final class Input extends UserMenuOption {
}

final class CsvInput extends UserMenuOption {

}

final class MinMaxAvg extends UserMenuOption {
}

final class Sort extends UserMenuOption {
}

final class BestChargingTime extends UserMenuOption {
}

final class Exit extends UserMenuOption {
}
