package ml.mrgonci.lobbycore.utils;

import ml.mrgonci.lobbycore.Lobby;
import ml.mrgonci.lobbycore.utils.senders.Console;
import org.bukkit.plugin.java.JavaPlugin;

public interface LobbyCore {
    Lobby plugin = (Lobby) JavaPlugin.getProvidingPlugin(Lobby.class);
    Console out = new Console();
}
