package autoclicker.customcomponents;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import autoclicker.controllers.AutoClickerGUIController;
import autoclicker.multilingual.Translator;
import autoclicker.tab.Tab;
import autoclicker.tab.TabLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class TabEntry extends Label {

    private String tabName;
    private int tabCount;
    private FontAwesomeIcons icon;
    private Tab tab;

    public TabEntry(String tabName, int tabCount, FontAwesomeIcons icon, Tab tab) {
        super(tabName);
        this.tabName = tabName;
        this.tabCount = tabCount;
        this.icon = icon;
        this.tab = tab;
    }

    public void show(Pane pane){
        setLayoutY(89 + (tabCount - 1) * 30);
        setLayoutX(56);
        setTextFill(new Color(1, 1, 1, 1));
        setText(Translator.translate(tabName));
        setFont(new Font("System", 15));
        setOnMouseClicked(event -> TabLoader.loadTab(AutoClickerGUIController.stage.getScene(), tab));
        pane.getChildren().add(this);
        pane.getChildren().add(new GlyphIcon<FontAwesomeIcons>() {
            @Override
            public FontAwesomeIcons getDefaultGlyph() {
                return icon;
            }
            {
                setSize("1.2em");
                setLayoutX(38);
                setLayoutY(89 + (tabCount - 1) * 30 + 16);
                setTextFill(new Color(1, 1, 1, 1));
                setFill(new Color(1, 1, 1, 1));
                setOnMouseClicked(event -> TabLoader.loadTab(AutoClickerGUIController.stage.getScene(), tab));
            }
        });
        pane.lookup("#splitter").setLayoutY(89 + (tabCount - 1) * 30 + 40);
    }

}
