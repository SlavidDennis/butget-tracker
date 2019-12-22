package com.easyutils.homebudgettracker.controller;

import java.util.HashMap;
import java.util.Map;

abstract class DomainController {

    protected Map<String, String> createdUuidResponse (String key, String uuid) {
        Map<String, String> response = new HashMap<>();
        response.put(key, uuid);
        return response;
    }
}
