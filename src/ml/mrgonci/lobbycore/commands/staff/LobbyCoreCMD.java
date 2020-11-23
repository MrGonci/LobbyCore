package ml.mrgonci.lobbycore.commands.staff;

import me.clip.placeholderapi.PlaceholderAPI;
import ml.mrgonci.lobbycore.utils.files.DataManager;
import ml.mrgonci.lobbycore.utils.LobbyCore;
import ml.mrgonci.lobbycore.utils.senders.StringUtils;
import ml.mrgonci.lobbycore.WarningLevel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class LobbyCoreCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("lobbycore.admin")){
                if(args.length > 0) {
                    if (args[0].equalsIgnoreCase("reload")) {
                        DataManager.getLangFile().reloadConfig();
                        p.sendMessage(StringUtils.toColor("&5(LobbyCore) &aFiles reloaded!"));
                        LobbyCore.out.Alert("&5&l(LobbyCore) &f" + p.getName() + "&c Reloaded the config &7(/lc reload)", WarningLevel.NONE);
                    }else if(args[0].equalsIgnoreCase("setspawn")){
                        if(DataManager.getSpawnConfig().getBoolean("enabled")) {
                            setSpawn(p);
                            String msg = Objects.requireNonNull(DataManager.getLangConfig().getString("Spawn.set-spawn-message"));
                            PlaceholderAPI.setPlaceholders(p, msg);
                            p.sendMessage(StringUtils.toColor(msg));
                        }else{
                            p.sendMessage(StringUtils.toColor("&cThe spawn is disabled in spawn.yml!"));
                            LobbyCore.out.Alert("Remember that spawn is disabled in spawn.yml", WarningLevel.WARNING);
                        }
                    } else {
                        helpMsg(p);
                    }
                }else{
                    helpMsg(p);
                }
            }else{
                p.sendMessage(StringUtils.toColor(DataManager.getLangConfig().getString("no-permission")));
            }
        }else{
            sender.sendMessage(StringUtils.toColor("&5(LobbyCore) &cCommand only for players!"));
        }
        return false;
    }

    private static void helpMsg(Player p){
        p.sendMessage(StringUtils.toColor("&7&m------{&f &5&lLobbyCore &7&oCommands &f&7&m}------&r"));
        p.sendMessage("");
        p.sendMessage(StringUtils.toColor("&7/lc reload"));
        p.sendMessage("");
        p.sendMessage(StringUtils.toColor("&7&m------{&f &5&lLobbyCore &7&oCommands &f&7&m}------&r"));
    }
    public static void setSpawn(Player p){
        DataManager.getSpawnConfig().set("Spawn.pitch", Double.valueOf(p.getLocation().getPitch()));
        DataManager.getSpawnConfig().set("Spawn.yaw", Double.valueOf(p.getLocation().getYaw()));
        DataManager.getSpawnConfig().set("Spawn.x", Double.valueOf(p.getLocation().getX()));
        DataManager.getSpawnConfig().set("Spawn.y", Double.valueOf(p.getLocation().getY()));
        DataManager.getSpawnConfig().set("Spawn.z", Double.valueOf(p.getLocation().getZ()));
        DataManager.getSpawnConfig().set("Spawn.world", p.getWorld().getName());
        DataManager.getSpawnFile().saveConfig();
    }
}
