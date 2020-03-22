package com.dmiyaniuk;

public enum ExtendedStates {
    NEW_YORK("New-York"),
    ALABAMA("Alabama"),
    IOWA("Iowa"),
    ARKANSAS("Arkansas"),
    WASHINGTON("Washington"),
    NORTH_DAKOTA("North Dakota"),
    VIRGINIA("Virginia");

    private String stateValue;

    private ExtendedStates(String stateValue) {
        this.stateValue = stateValue;
    }

    public String getStateValue() {
        return stateValue;
    }
}
