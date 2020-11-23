package ml.mrgonci.lobbycore.events;

import me.clip.placeholderapi.PlaceholderAPI;
import ml.mrgonci.lobbycore.utils.files.DataManager;
import ml.mrgonci.lobbycore.utils.LobbyCore;
import ml.mrgonci.lobbycore.utils.senders.StringUtils;
import ml.mrgonci.lobbycore.WarningLevel;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class LobbyEvents implements Listener {
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(DataManager.getLangConfig().getBoolean("Welcome-motd.enabled")){
            List<String> lines = DataManager.getLangConfig().getStringList("Welcome-motd.message");
            for(String s : lines) {
                s = PlaceholderAPI.setPlaceholders(e.getPlayer(), s);
                p.sendMessage(StringUtils.toColor(s));
            }
        }
        if(DataManager.getLangConfig().getBoolean("JoinMessage.enabled")){
            String joimsg = DataManager.getLangConfig().getString("JoinMessage.message");
            joimsg = PlaceholderAPI.setPlaceholders(e.getPlayer(), joimsg);
            e.setJoinMessage(StringUtils.toColor(joimsg));
        }
        if (DataManager.getSpawnConfig().getBoolean("enabled")){
            teleportToSpawn(p);
        }
    }
    @EventHandler
    public void PlayerQuit(PlayerQuitEvent e){
        String quitmsg = DataManager.getLangConfig().getString("QuitMessage.message");
        quitmsg = PlaceholderAPI.setPlaceholders(e.getPlayer(), quitmsg);
        Player p = e.getPlayer();
        if(DataManager.getLangConfig().getBoolean("QuitMessage.enabled")){
            e.setQuitMessage(StringUtils.toColor(quitmsg));
        }

    }


    public static void teleportToSpawn(Player p) {
        try {
            World w = Bukkit.getServer().getWorld(DataManager.getSpawnConfig().getString("Spawn.world"));
            float yaw = (float) DataManager.getSpawnConfig().getDouble("Spawn.yaw");
            float pitch = (float) DataManager.getSpawnConfig().getDouble("Spawn.pitch");
            double x = DataManager.getSpawnConfig().getDouble("Spawn.x");
            double y = DataManager.getSpawnConfig().getDouble("Spawn.y");
            double z = DataManager.getSpawnConfig().getDouble("Spawn.z");
            Location l = new Location(w, x, y, z);
            l.setYaw(yaw);
            p.getLocation().setPitch(pitch);
            p.teleport(l);
        }catch (Exception e){
            LobbyCore.out.Alert("An error occurred teleporting the player to spawn, make sure that you set an spawn using /lc setspawn or disable it", WarningLevel.ERROR);
        }
    }

}
