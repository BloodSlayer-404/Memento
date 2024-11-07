package org.example;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class SaveManager {
    private final List<SaveState> saveStates = new ArrayList<>();

    /**
     * Adds a Save State to the history
     * @param saveState: The Save State to add to the history
     */
    public void addSaveState(SaveState saveState) {
        saveStates.add(saveState);
    }

    /**
     * Gets a Save State from the history
     * @param index: The index in the history of the Save State to load
     * @return The required Save State
     */
    public Object getSaveState(int index) {
        if (index < 0 || index >= saveStates.size()) {
            return  "Save state not found!";
        }
        return saveStates.get(index);
    }
}
