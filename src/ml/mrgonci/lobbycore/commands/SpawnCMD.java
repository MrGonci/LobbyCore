package ml.mrgonci.lobbycore.commands;

import ml.mrgonci.lobbycore.events.LobbyEvents;
import ml.mrgonci.lobbycore.utils.files.DataManager;
import ml.mrgonci.lobbycore.utils.senders.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("lobbycore.spawn")){
                LobbyEvents.teleportToSpawn(p);
                p.sendMessage(StringUtils.toColor(DataManager.getLangConfig().getString("Spawn.teleport-tp-spawn")));
            }else{
                p.sendMessage(StringUtils.toColor(DataManager.getLangConfig().getString("no-permission")));
            }
        }else{
            sender.sendMessage(StringUtils.toColor("&5(LobbyCore) &cCommand only for players!"));
        }
        return false;
    }

}
