package com.alura.literatura.servicio;

import com.alura.literatura.modelo.Libro;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class GutendexService {

    private static final String API_URL = "https://gutendex.com/books/?search=";

    public List<Libro> buscarLibrosPorTitulo(String titulo) throws IOException, InterruptedException {
        String url = API_URL + titulo.replace(" ", "%20");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(response.body(), JsonObject.class);
        JsonArray results = json.getAsJsonArray("results");

        List<Libro> libros = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            JsonObject obj = results.get(i).getAsJsonObject();
            String tituloLibro = obj.get("title").getAsString();
            String idioma = obj.getAsJsonArray("languages").size() > 0 ?
                    obj.getAsJsonArray("languages").get(0).getAsString() : "Desconocido";
            String autorNombre = obj.getAsJsonArray("authors").size() > 0 ?
                    obj.getAsJsonArray("authors").get(0).getAsJsonObject().get("name").getAsString() :
                    "Desconocido";

            libros.add(new Libro(tituloLibro, idioma, 0, null)); // autor null, ya que no lo guardamos en BD
        }
        return libros;
    }
}
