package net.app.theoryofcompproj.interfaces;

import javafx.scene.Parent;
import javafx.scene.Scene;
import net.app.theoryofcompproj.Fonts;
import net.app.theoryofcompproj.Styling;

public class LanguageCheckerInterface extends Scene{

    Styling style = new Styling();
    Fonts fonts = new Fonts();

    public LanguageCheckerInterface(Parent parent, double v, double v1) {
        super(parent, v, v1);
    }

}
