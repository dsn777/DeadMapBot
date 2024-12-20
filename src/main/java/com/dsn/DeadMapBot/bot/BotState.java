package com.dsn.DeadMapBot.bot;

public enum BotState {
    DEFAULT_STATE,
    WAIT_ID,
    WAIT_FIRSTNAME,
    WAIT_LASTNAME,
    WAIT_MIDDLENAME;

    public static BotState getNextState(BotState state) {
        int index = state.ordinal();
        int len = BotState.values().length;
        int nextIndex = ++index % len;
        return BotState.values()[nextIndex];
    }
}
