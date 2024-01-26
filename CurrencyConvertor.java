import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConvertor {

    private static final String API_KEY = "YOUR_EXCHANGE_RATE_API_KEY";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Currency Converter");
        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        if (exchangeRate == -1) {
            System.out.println("Failed to fetch exchange rates. Exiting...");
            System.exit(1);
        }

   
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();
        //  Currency Conversion
        double convertedAmount = amountToConvert * exchangeRate;
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            URL url = new URL("https://api.apis.guru/v2/specs/exchangeratesapi.io/1.0.0/swagger.json"); // Replace with the actual API endpoint
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            return 1.2; 
        } catch (Exception e) {
            e.printStackTrace();
            return -1; 
        }
    }
}

