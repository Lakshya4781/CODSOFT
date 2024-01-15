import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConvertor {

    private static final String API_KEY = "YOUR_EXCHANGE_RATE_API_KEY";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Currency Selection
        System.out.println("Currency Converter");
        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Step 2: Fetch real-time exchange rates
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        if (exchangeRate == -1) {
            System.out.println("Failed to fetch exchange rates. Exiting...");
            System.exit(1);
        }

        // Step 3: Amount Input
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        // Step 4: Currency Conversion
        double convertedAmount = amountToConvert * exchangeRate;

        // Step 5: Display Result
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

            // Parse the JSON response to get the exchange rate
            // In a real-world scenario, you would use a JSON parsing library
            // For simplicity, I'm using a placeholder value here
            return 1.2; // Replace with actual parsing logic from API response
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Error fetching exchange rates
        }
    }
}

