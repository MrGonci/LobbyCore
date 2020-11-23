package ml.mrgonci.lobbycore;

import ml.mrgonci.lobbycore.utils.Main;
import org.bukkit.plugin.java.JavaPlugin;

public class Lobby extends JavaPlugin {

    @Override
    public void onEnable() {
        new Main().enable();
    }

    @Override
    public void onDisable() {
        new Main().disable();
    }
}
