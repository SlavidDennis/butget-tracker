package com.easyutils.homebudgettracker.domain.dto;

import com.easyutils.homebudgettracker.infrastructure.enums.ProfileType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto implements Serializable {

    private String uuid;
    private String accountUuid;
    private String profileName;
    private String email;
    private Integer totalAdults;
    private Integer totalChildren;
    private boolean isPrimary;
    private ProfileType profileType;
}
