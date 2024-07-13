import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    private static final String API_KEY ="28221ceb57e687c36da54d6c";
    public Monedas buscarMoneda(String monedaBase, String monedaTarget) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaBase + "/" + monedaTarget);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de conversión: " + e.getMessage());
            return null;
        }
    }
}
