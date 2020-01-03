package com.easyutils.homebudgettracker.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class VendorGroupDto implements Serializable {

    private String uuid;
    private String userProfileUuid;
    private String groupName;
}
