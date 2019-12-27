package com.easyutils.homebudgettracker.infrastructure.enums;

public enum ProfileType {

    BUSINESS("Business profile"),
    HOME("Personal home account");

    String description;

    ProfileType(final String description) {this.description = description; }

    public String getDescription() { return description; }
}
