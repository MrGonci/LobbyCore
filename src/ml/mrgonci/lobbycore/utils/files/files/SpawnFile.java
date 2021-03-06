package ml.mrgonci.lobbycore.utils.files.files;

import ml.mrgonci.lobbycore.utils.AsyncScheduler;
import ml.mrgonci.lobbycore.utils.files.Config;
import ml.mrgonci.lobbycore.utils.LobbyCore;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class SpawnFile extends Config implements LobbyCore {
    public SpawnFile() {
        super("spawn");
    }

    @Override
    public void loadConfig() {
        File file = getFile();
        if(!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource("spawn.yml", false);
        }
        FileConfiguration conf = getConfig();
        try{
            conf.load(file);
        }catch(IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        conf.options().copyDefaults(true);
    }
}

