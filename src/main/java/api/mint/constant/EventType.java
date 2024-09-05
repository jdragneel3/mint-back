package api.mint.constant;

public enum EventType {
    OFF, SEMINAR, PROJECT;

    public String getValue() {
        return this.name();
    }
}
