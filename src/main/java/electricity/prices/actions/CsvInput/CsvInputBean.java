package electricity.prices.actions.CsvInput;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import electricity.prices.actions.input.InputPriceLine;

import java.io.BufferedReader;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class CsvInputBean {
    private static final String path = "src/main/resources/elpriser.csv";

    public static List<InputPriceLine> readCsvPrices() throws Exception {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            CsvToBean<InputPriceLine> csvToBean = new CsvToBeanBuilder<InputPriceLine>(br)
                    .withType(InputPriceLine.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw exception;
        }
    }

    public static class StringPriceToInteger extends AbstractBeanField<Integer, String> {

        @Override
        protected Integer convert(String string) throws CsvDataTypeMismatchException {
            try {
                var priceInteger = Double.parseDouble(string);
                return (int) priceInteger;
            } catch (NumberFormatException exception) {
                throw new CsvDataTypeMismatchException(string, Integer.class);
            }
        }
    }
}
