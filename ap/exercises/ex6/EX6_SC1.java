package ap.exercises.ex6;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EX6_SC1 {

    private static Set<String> downloadedUrls = new HashSet<>();

    public static void extractAndSaveImageLinks(String htmlContent, String outputFile) throws IOException {
        Document doc = Jsoup.parse(htmlContent);
        Elements imgElements = doc.select("img");

        Path outputPath = Path.of(outputFile);
        Files.createDirectories(outputPath.getParent());

        StringBuilder links = new StringBuilder();
        for (Element img : imgElements) {
            String src = img.attr("src");
            if (!src.isEmpty()) {
                links.append(src).append("\n");
            }
        }

        Files.writeString(outputPath, links.toString());
    }

    public static void downloadImage(String imageUrl, String outputPath) throws IOException {

        if (downloadedUrls.contains(imageUrl)) {
            System.out.println( "The image has already been downloaded." + imageUrl);
            return;
        }

        if (imageUrl == null || imageUrl.isBlank()) {
            throw new IllegalArgumentException("Image address cannot be empty.");
        }
        if (outputPath == null || outputPath.isBlank()) {
            throw new IllegalArgumentException("The storage path cannot be empty.");
        }

        URL url = new URL(imageUrl);
        try (InputStream in = url.openStream()) {
            Path output = Path.of(outputPath);
            Files.createDirectories(output.getParent());
            Files.copy(in, output, StandardCopyOption.REPLACE_EXISTING);

            downloadedUrls.add(imageUrl);
            System.out.println("Image downloaded successfully." + imageUrl);
        }
    }

public static void main(String[] args) {

    try {

        String htmlContent = "<html><body><img src='image1.jpg'><img src='image2.png'></body></html>";
        extractAndSaveImageLinks(htmlContent, "image_links/links.txt");


        String imageUrl = "https://www.znu.ac.ir/files/uploaded/news-pic/stories/thumbsVertical-450-600/pr-132-pr-entesab404-03-04.jpg";
        String saveFileAddress = "fetched_images/test.jpg";

        downloadImage(imageUrl, saveFileAddress);

        downloadImage(imageUrl, saveFileAddress);

    } catch (IOException e) {
        System.err.println("Error downloading image" + e.getMessage());
    }
}
}