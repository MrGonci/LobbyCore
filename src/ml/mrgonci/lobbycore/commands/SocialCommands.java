package ml.mrgonci.lobbycore.commands;

import ml.mrgonci.lobbycore.utils.files.DataManager;
import ml.mrgonci.lobbycore.utils.senders.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SocialCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("discord")){
            if(sender.hasPermission("lobbycore.socials")) {
                List<String> lines = DataManager.getLangConfig().getStringList("Social.discord");
                for (String discord : lines) {
                    sender.sendMessage(StringUtils.toColor(discord));
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("twitter")){
            if(sender.hasPermission("lobbycore.socials")) {
                List<String> lines = DataManager.getLangConfig().getStringList("Social.twitter");
                for (String twitter : lines) {
                    sender.sendMessage(StringUtils.toColor(twitter));
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("forum")){
            if(sender.hasPermission("lobbycore.socials")) {
                List<String> lines = DataManager.getLangConfig().getStringList("Social.forum");
                for (String forum : lines) {
                    sender.sendMessage(StringUtils.toColor(forum));
                }
            }
        }
        return false;
    }
}


