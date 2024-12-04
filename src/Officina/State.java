package Officina;

public enum State {
    RIPARAZIONE,
    RIPARATO,
    CONSEGNATO;

    public static State fromString(String stateStr) {
        for (State state : State.values()) {
            if (state.name().equalsIgnoreCase(stateStr)) {
                return state;
            }
        }
        return null;
    }
}