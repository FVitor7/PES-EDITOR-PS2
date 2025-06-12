package editor;

public class CallnameEntry {
    public final int callName;
    public final String playerName;

    public CallnameEntry(int callName, String playerName) {
        this.callName = callName;
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return playerName + " (" + callName + ")";
    }
}
