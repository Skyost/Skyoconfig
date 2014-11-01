package fr.skyost.utils.examples;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import fr.skyost.utils.Skyoconfig;

public class PluginConfig extends Skyoconfig {
	
	@ConfigOptions(name = "configurable.string.1")
	public String configurableString = "This String is configurable like others fields below ;)";
	@ConfigOptions(name = "configurable.int.1")
	public int configurableInt1 = 1;
	@ConfigOptions(name = "configurable.int.2")
	public int configurableInt2 = 0;
	@ConfigOptions(name = "configurable.list.1")
	public List<String> configurableList = Arrays.asList("YAML list...", "So awesome !");
	@ConfigOptions(name = "configurable.map.1")
	public HashMap<String, String> configurableMap = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L; {
			put("key1", "value1");
			put("key2", "value2");
		}
	};
	public String configurable_string_2 = "This one does not needs the annotation but the field's name looks so bad !";
	public transient String ignoredString1 = "This String should be ignored.";
	@ConfigOptions(ignore = true)
	public String ignoredString2 = "This one too.";
	
	public PluginConfig(final File configFile) {
		super(configFile, Arrays.asList("This is an header...", "...Which looks more than one line !"));
	}
	
}
