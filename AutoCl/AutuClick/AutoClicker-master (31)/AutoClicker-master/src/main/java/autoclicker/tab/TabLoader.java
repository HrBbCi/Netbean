package autoclicker.tab;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import autoclicker.customcomponents.TabEntry;
import autoclicker.multilingual.Translator;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class TabLoader {

    private static final ArrayList<TabEntry> tabs = new ArrayList<>();

    public static ArrayList<TabEntry> getTabs() {
        return tabs;
    }

    public static void addTab(Tab tab, FontAwesomeIcons icons){
        tabs.add(new TabEntry(tab.getTabName(), tabs.size() + 1, icons, tab));
    }

    private static Tab currentTab;

    public static Tab getCurrentTab() {
        return currentTab;
    }

    public static void loadTab(Scene scene, Tab tab) {
        loadTab(scene, tab, false);
    }

    public static void loadTab(Scene scene, Tab tab, boolean forceload) {

        Platform.runLater(()->{
            if (!forceload)
                if (currentTab != null)
                    if (currentTab.getClass().getName().equalsIgnoreCase(tab.getClass().getName()))
                        return;

            currentTab = tab;

            VBox view = (VBox) scene.lookup("#view");
            Pane load = tab.load();


            ((Label) scene.lookup("#tabTitle")).setText(tab.getName());

            scene.lookup("#soonLbl").setVisible(tab.isCommingSoon());
            scene.lookup("#soonWrench").setVisible(tab.isCommingSoon());
            ((Label) scene.lookup("#soonLbl")).setText(Translator.translate("autoclicker.tab.soon.message1") + "\n" + Translator.translate("autoclicker.tab.soon.message2"));
            if (tab.isCommingSoon()) {
                view.setEffect(new GaussianBlur(10.0D));
            } else {
                view.setEffect(new GaussianBlur(0.0D));
            }

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(tab::onPostLoad);
                }
            }, 200);

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(()->{
                        view.getChildren().clear();
                        view.getChildren().add(load);
                    });
                }
            }, 5);
        });


    }

}
