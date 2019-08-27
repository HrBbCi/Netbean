package autoclicker.plugins;

import autoclicker.controllers.AutoClickerGUIController;
import autoclicker.logger.Level;
import autoclicker.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * © Angelo Breuer 2017.
 * All Rights reserved.
 */
public class PluginLoader {

    public static void loadPlugins(){
        File folder = new File("plugins/");
        if (!folder.exists())
            return;
        if (!folder.isDirectory())
            return;
        for (File file : folder.listFiles((dir, name) -> name.endsWith(".jar") || name.endsWith(".zip"))) {
            try{
                loadPlugin(file.toURL());
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static void loadPlugin(URL jar){

        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{jar});

        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(urlClassLoader.getResourceAsStream("plugin.properties"), Charset.forName("UTF-8")));
        } catch (IOException e) {
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin{%s}: Cannot load properties file", jar.toExternalForm()), Level.ERROR);
            e.printStackTrace();
            return;
        }


        if (!properties.containsKey("main")){
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Required option not found: %s", jar.toExternalForm(), "main"), Level.ERROR);
            return;
        }

        if (!properties.containsKey("author")){
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Required option not found: %s", jar.toExternalForm(), "author"), Level.ERROR);
            return;
        }

        if (!properties.containsKey("version")){
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Required option not found: %s", jar.toExternalForm(), "version"), Level.ERROR);
            return;
        }

        Class<?> clazz;

        try {
            clazz = urlClassLoader.loadClass(properties.getProperty("main"));
        } catch (ClassNotFoundException e) {
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Main class not found: %s", jar.toExternalForm(), properties.getProperty("main")), Level.ERROR);
            return;
        }

      /*  if (!clazz.isAssignableFrom(Plugin.class)){
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Main class \"%s\" is not extending class %s", jar.toExternalForm(), properties.getProperty("main"), IPlugin.class.getName()), Level.ERROR);
            return;
        }*/
        IPlugin plugin;

        try {
            plugin = (IPlugin) clazz.newInstance();
        } catch (Exception e) {
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Main class \"%s\" thrown exception while constructor init", jar.toExternalForm(), properties.getProperty("main")), Level.ERROR);
            e.printStackTrace();
            return;
        }

        if (plugin.getName() == null){
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Plugin name cannot be null or empty!", jar.toExternalForm()), Level.ERROR);
            return;
        }

        if (plugin.getName().length() < 1){
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Plugin name cannot be null or empty!", jar.toExternalForm()), Level.ERROR);
            return;
        }

        if (!plugin.getClass().isAnnotationPresent(PluginClass.class)){
            Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Plugins class is not annotated with %s", jar.toExternalForm(), PluginClass.class), Level.ERROR);
            return;
        }

        try {
            plugin.onLoad();
        } catch (Exception e) {
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Main class \"%s\" thrown exception while plugin load", jar.toExternalForm(), properties.getProperty("main")), Level.ERROR);
            e.printStackTrace();
            return;
        }

        try {
            plugin.onEnable();
        } catch (Exception e) {
           Logger.getLogger("PluginLoader").log(String.format("Failed while loading plugin {%s}: Main class \"%s\" thrown exception while plugin enable", jar.toExternalForm(), properties.getProperty("main")), Level.ERROR);
            e.printStackTrace();
            return;
        }

        AutoClickerGUIController.instance.retranslate();

       Logger.getLogger("PluginLoader").log("Plugin "+plugin.getName()+" successfully loaded", Level.INFO);

    }

}
