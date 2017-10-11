package com.xtito.javaFx.a.fxmlLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

/**
 * Created by [Zy]
 * 2017/10/11 13:27
 */
public class FxmlController {

    @FXML
    public PasswordField passwordField;

    @FXML
    private Text actionTarget;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actionTarget.setText("Sign in button pressed");
    }

}
