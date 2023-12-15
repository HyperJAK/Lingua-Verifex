package net.app.theoryofcompproj;

public class LinguaVerifexButton extends javafx.scene.control.Button {
    Styling style = new Styling();
    public LinguaVerifexButton() {
        super();
    }

    public void addStyleHover(LinguaVerifexButton btn){
        style.ChangeButtonColor(btn, "BTN", "BTN2");
    }

}
