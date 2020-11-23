package ml.mrgonci.lobbycore.utils.senders;

import ml.mrgonci.lobbycore.utils.LobbyCore;
import ml.mrgonci.lobbycore.WarningLevel;

import java.util.HashSet;
import java.util.List;

public final class Console implements LobbyCore {

    public final void Message(String message) {
        plugin.getServer().getConsoleSender().sendMessage(StringUtils.toColor(message));
    }
    public final void Message(List<String> message) {
        for (String str : message) {
            Message(str);
        }
    }
    public final void Message(HashSet<String> messages) {
        for (String str : messages) {
            Message(str);
        }
    }
    public final void Alert(String message, WarningLevel level) {
        switch (level) {
            case NONE:
                Message("&7(&fLobbyCore&7) &8(&7INFO&8) &f" + message);
                break;
            case WARNING:
                Message("&7(&fLobbyCore&7) &8(&6WARNING&8) &e" + message);
                break;
            case ERROR:
                Message("&7(&fLobbyCore&7) &8(&4ERROR&8) &c" + message);
                break;
        }
    }
}

