import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import  org.json.JSONObject;

public class Test1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.football-data.org/v4/competitions/WC/matches?season=2022"))
                .header( "X-Auth-Token" , "95c1609b64c845689d0f9db0de4fe44a")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        JSONObject obj = new JSONObject(response.body());
        FileWriter file = new FileWriter("json/output.json");
        file.write(obj.toString());
    }
}
