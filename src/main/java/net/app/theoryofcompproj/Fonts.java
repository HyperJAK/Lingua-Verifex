package net.app.theoryofcompproj;


import javafx.scene.text.Font;


public class Fonts{

    //All fonts to be used in the project
    private final Font LemonMilk48 = Font.loadFont(getClass().getResourceAsStream("fonts/LemonMilk.ttf"), 46);
    private final Font LemonMilk36 = Font.loadFont(getClass().getResourceAsStream("fonts/LemonMilk.ttf"), 34);
    private final Font LemonMilk22 = Font.loadFont(getClass().getResourceAsStream("fonts/LemonMilk.ttf"), 18);
    private final Font LemonMilk18 = Font.loadFont(getClass().getResourceAsStream("fonts/LemonMilk.ttf"), 16);

    private final Font LemonMilk14 = Font.loadFont(getClass().getResourceAsStream("fonts/LemonMilk.ttf"), 12);

    private final Font SegoeUIFont15 = Font.font("Segoe UI", 15);

    //getters
        public Font getLemonMilk48() {
        return LemonMilk48;
    }
    public Font getLemonMilk36() {
        return LemonMilk36;
    }
    public Font getLemonMilk22() {
        return LemonMilk22;
    }
    public Font getLemonMilk18() {
        return LemonMilk18;
    }
    public Font getLemonMilk14() {
        return LemonMilk14;
    }
    public Font getSegoeUIFont15() {
        return SegoeUIFont15;
    }

}
