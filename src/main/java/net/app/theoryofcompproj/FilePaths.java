package net.app.theoryofcompproj;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public interface FilePaths {


    URL selected_automats_URL = App.class.getResource("Resources/net/app/theoryofcompproj/selected_automats.json");
    URL is_available_URL = App.class.getResource("Resources/net/app/theoryofcompproj/is_language_available.json");
    URL string_token_URL = App.class.getResource("Resources/net/app/theoryofcompproj/string_tokens.json");


    String selected_automats_ExePath = getRealPath(selected_automats_URL, "/", false);
    String is_available_ExePath = getRealPath(is_available_URL, "/", false);
    String string_token_ExePath = getRealPath(string_token_URL, "/", false);

    static String getRealPath(URL url, String converter, boolean cssPath) {
        String fixed = null;

        switch (converter) {
            case "/" -> {
                // for text files, use this
                if (!cssPath) {
                    fixed = url.getPath();
                    fixed = fixed.replaceFirst("/", "");
                    fixed = fixed.replaceFirst("file:", "");
                    fixed = fixed.replace("%20", " ");
                }
                // For css use this
                else {
                    try {
                        fixed = url.toURI().toURL().toString();
                    } catch (MalformedURLException | URISyntaxException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            // For pictures maybe use this
            case "\\" -> {
                fixed = url.getPath().replace("/", "\\\\");
                fixed = fixed.replaceFirst("\\\\", "");
                fixed = fixed.replaceFirst("\\\\", "");
                fixed = fixed.replace("%20", " ");
                fixed = fixed.replaceFirst("file:", "");
            }
        }

        return fixed;
    }

}
