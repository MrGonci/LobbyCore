package ml.mrgonci.lobbycore.utils.files;

import ml.mrgonci.lobbycore.utils.files.files.LangFile;
import ml.mrgonci.lobbycore.utils.files.files.SpawnFile;
import org.bukkit.configuration.file.FileConfiguration;

public class DataManager {

    private static final LangFile langFile = new LangFile();
    private static final SpawnFile spawnFile = new SpawnFile();

    public static FileConfiguration getLangConfig() {
        return langFile.getConfig();
    }
    public static void saveLangFile() {
        langFile.saveConfig();
    }
    public static LangFile getLangFile() {
        return langFile;
    }

    public static SpawnFile getSpawnFile() {
        return spawnFile;
    }
    public static void saveSpawnFile(){
        spawnFile.saveConfig();
    }
    public static FileConfiguration getSpawnConfig() {
        return spawnFile.getConfig();
    }
}
