package com.github.sebyplays.logmanager.api;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LogType {

    WARNING("WARNING", "§fe"),
    INFORMATION("INFORMATION", "§f9"),
    ERROR("ERROR", "§f4"),
    NORMAL("NORMAL", "");

    @NonNull @Getter String prefix;
    @NonNull @Getter String color;
}
