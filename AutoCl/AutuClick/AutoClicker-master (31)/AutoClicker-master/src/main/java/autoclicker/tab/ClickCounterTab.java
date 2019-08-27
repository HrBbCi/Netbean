package autoclicker.tab;

import autoclicker.util.OldFeature;
import com.jfoenix.controls.JFXComboBox;
import autoclicker.util.CPSCounter;
import autoclicker.util.MouseClickListener;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import static autoclicker.multilingual.Translator.translate;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class ClickCounterTab implements Tab, Initializable {


    private CPSCounter left = new CPSCounter(), right = new CPSCounter();

    @FXML
    private Circle circle;
    @FXML
    private Label leftClickCounter, txt;
    @FXML
    private Label rightClickCounter;
    @FXML
    @OldFeature(removedSince = "1.2")
    private JFXComboBox unitBox;
    @FXML
    private ImageView mouse;

    @OldFeature(removedSince = "1.2" /* FIELD "unitBox" */)
    @Override
    public void retranslate() {

        unitBox.getItems().addAll(translate("autoclicker.clickCounter.comboBox1.item1"), translate("autoclicker.clickCounter.comboBox1.item2"),translate("autoclicker.clickCounter.comboBox1.item3"),translate("autoclicker.clickCounter.comboBox1.item4"));
        unitBox.getSelectionModel().selectFirst();
        unitBox.setButtonCell(new ListCell(){

            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item==null){
                    setStyle("-fx-text-fill: white");
                } else {
                    setStyle("-fx-text-fill: -fx-text-inner-color");
                    setText(item.toString());
                }
            }

        });
        txt.setText(translate("autoclicker.clickCounterDescription"));
       /* unitBox.setOnAction(event -> {
            if (unitBox.getValue().equals(translate("autoclicker.clickCounter.comboBox1.item1"))) {
                moduloValue = 1000;
            } else if (unitBox.getValue().equals(translate("autoclicker.clickCounter.comboBox1.item2"))) {
                moduloValue = 1000 * 60;
            } else if (unitBox.getValue().equals(translate("autoclicker.clickCounter.comboBox1.item3"))) {
                moduloValue = 1000 * 60 * 60;
            } else if (unitBox.getValue().equals(translate("autoclicker.clickCounter.comboBox1.item4"))) {
                moduloValue = Long.MAX_VALUE;
            }
        });*/

    }

    @Override
    public String getFile() {
        return "ClickCounterTab.fxml";
    }

    @Override
    public String getTabName() {
        return "autoclicker.tab.clickCounter";
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
retranslate();

        Image mouseLeft = new Image("gui/images/left.png");
        Image mouseRight = new Image("gui/images/right.png");
        Image mouseNormal = new Image("gui/images/mouse.png");

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    leftClickCounter.setText(String.valueOf(left.getCPS()));
                    rightClickCounter.setText(String.valueOf(right.getCPS()));
                });
            }
        }, 20, 20);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.2), circle);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setFromZ(1.0);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setToZ(1.1);
        scaleTransition.setAutoReverse(true);



        circle.setOnMouseReleased(new MouseClickListener() {
            @Override
            public void onMouseClicked(MouseEvent event) throws Exception {
                Platform.runLater(() -> mouse.setImage(mouseNormal));
            }
        });

        circle.setOnMousePressed(new MouseClickListener() {
            @Override
            public void onMouseClicked(MouseEvent event) throws Exception {
                switch (event.getButton()) {
                    case NONE:
                        break;
                    case PRIMARY:
                        left.click();
                        scaleTransition.stop();
                        scaleTransition.play();
                        mouse.setImage(mouseLeft);

                        break;
                    case MIDDLE:
                        break;
                    case SECONDARY:
                        right.click();
                        scaleTransition.stop();
                        scaleTransition.play();
                        mouse.setImage(mouseRight);
                        break;
                }
            }
        });

    }
}
