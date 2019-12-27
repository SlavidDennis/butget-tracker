package com.easyutils.homebudgettracker.domain;

import com.easyutils.homebudgettracker.domain.enums.ProfileType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_profile")
@SequenceGenerator(name = "user_profile_seq_generator", sequenceName = "user_profile_seq", allocationSize = 1)
public class Profile extends AuditableDate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profile_seq_generator")
    private Long id;
    private String uuid;
    @Column(name = "account_uuid")
    @NotEmpty
    private String accountUuid;
    @NotEmpty
    private String email;
    @Column(name = "total_adults")
    @NotNull
    private Integer totalAdults;
    @Column(name = "total_children")
    @NotNull
    private Integer totalChildren;
    @Column(name = "is_primary")
    private boolean isPrimary;
    @Column(name = "profile_type")
    @NotNull
    @Enumerated(EnumType.STRING)
    private ProfileType profileType;
    private int versie;
}
