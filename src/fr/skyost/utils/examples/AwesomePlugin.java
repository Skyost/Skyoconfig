package fr.skyost.utils.examples;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

public class AwesomePlugin extends JavaPlugin {
	
	private PluginConfig config; //Can be static too !
	
	@Override
	public final void onEnable() {
		final Logger logger = getLogger();
		try {
			config = new PluginConfig(new File(this.getDataFolder(), "config.yml"));
			config.load();
			logger.log(Level.INFO, "Voici le champ \"configurableString\" : \"" + config.configurableString + "\".");
		}
		catch(final InvalidConfigurationException ex) {
			ex.printStackTrace();
			logger.log(Level.SEVERE, "Oooops ! Something went wrong while loading the configuration !");
			Bukkit.getPluginManager().disablePlugin(this);
		}
	}
	
	@Override
	public final void onDisable() {
		try {
			config.save();
		}
		catch(final InvalidConfigurationException ex) {
			ex.printStackTrace();
			getLogger().log(Level.SEVERE, "Oooops ! Something went wrong while saving the configuration !");
		}
	}
	
}
