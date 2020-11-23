package ml.mrgonci.lobbycore.utils;

import ml.mrgonci.lobbycore.commands.SpawnCMD;
import ml.mrgonci.lobbycore.commands.staff.LobbyCoreCMD;
import ml.mrgonci.lobbycore.commands.SocialCommands;
import ml.mrgonci.lobbycore.events.LobbyEvents;
import ml.mrgonci.lobbycore.utils.files.DataManager;
import ml.mrgonci.lobbycore.WarningLevel;
import org.bukkit.Bukkit;

import java.util.Objects;

public final class Main implements LobbyCore{
    public final void enable() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            LobbyCore.out.Alert("PlaceholderAPI Found. Starting plugin...", WarningLevel.NONE);
            LobbyCore.out.Alert("LobbyCore started correctly", WarningLevel.NONE);
            LobbyCore.out.Message("&f&m------------------------");
            LobbyCore.out.Message("");
            LobbyCore.out.Message("&5&lLobbyCore &7| &f1.0.0");
            LobbyCore.out.Message("&bAuthor: &fGonci");
            LobbyCore.out.Message("");
            LobbyCore.out.Message("&f&m------------------------");
            loadConfigs();
            loadEvents();
            loadCommands();
        }else{
            LobbyCore.out.Alert("LobbyCore require Placeholders to work correctly. Stopping plugin...", WarningLevel.ERROR);
            Bukkit.getPluginManager().disablePlugin(plugin);
        }
    }
    public final void disable(){
        LobbyCore.out.Alert("LobbyCore stopped correctly", WarningLevel.NONE);
        LobbyCore.out.Message("&f&m------------------------");
        LobbyCore.out.Message("");
        LobbyCore.out.Message("&5&lLobbyCore &7| &f1.0.0");
        LobbyCore.out.Message("&bAuthor: &fGonci");
        LobbyCore.out.Message("");
        LobbyCore.out.Message("&f&m------------------------");
    }

    private void loadConfigs() {
        DataManager.getLangFile().loadConfig();
        DataManager.getSpawnFile().loadConfig();
    }
    private void loadEvents(){
        Bukkit.getPluginManager().registerEvents(new LobbyEvents(), plugin);

    }
    private void loadCommands(){
        Objects.requireNonNull(plugin.getCommand("lc")).setExecutor(new LobbyCoreCMD());
        Objects.requireNonNull(plugin.getCommand("lobbycore")).setExecutor(new LobbyCoreCMD());
        Objects.requireNonNull(plugin.getCommand("spawn")).setExecutor(new SpawnCMD());
        Objects.requireNonNull(plugin.getCommand("discord")).setExecutor(new SocialCommands());
        Objects.requireNonNull(plugin.getCommand("twitter")).setExecutor(new SocialCommands());
        Objects.requireNonNull(plugin.getCommand("forum")).setExecutor(new SocialCommands());
    }
}
