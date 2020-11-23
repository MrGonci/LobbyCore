package ml.mrgonci.lobbycore.utils.senders;

import ml.mrgonci.lobbycore.utils.LobbyCore;
import org.bukkit.ChatColor;

public interface StringUtils extends LobbyCore {

    static String toColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    static String stripColor(String text) {
        return ChatColor.stripColor(toColor(text));
    }
}
