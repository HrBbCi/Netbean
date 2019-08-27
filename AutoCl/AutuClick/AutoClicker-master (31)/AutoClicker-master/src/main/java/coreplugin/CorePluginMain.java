package coreplugin;

import autoclicker.plugins.Plugin;
import autoclicker.plugins.PluginClass;
import autoclicker.tab.*;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
@PluginClass(SERIAL = 5141477141711L)
public class CorePluginMain extends Plugin{

    @Override
    public void onEnable() {
        TabLoader.addTab(new GeneralSettingsTab(), FontAwesomeIcons.COGS);
        TabLoader.addTab(new ClickTab(), FontAwesomeIcons.BARS);
        TabLoader.addTab(new ModeTab(), FontAwesomeIcons.BOLT);
        TabLoader.addTab(new ClickCounterTab(), FontAwesomeIcons.BUG);
        TabLoader.addTab(new StatisticsTab(), FontAwesomeIcons.FLAG);
        TabLoader.addTab(new DataManagementTab(), FontAwesomeIcons.RECYCLE);
    }

    @Override
    public String getName() {
        return "self.core-plugin";
    }
}
