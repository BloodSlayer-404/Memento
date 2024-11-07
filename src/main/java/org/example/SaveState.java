package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SaveState {

    private final String playerName;
    private final int badges;
    private final int pokemonCount;
    private final int playTime;

}
