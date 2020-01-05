package com.easyutils.homebudgettracker.domain;

import com.easyutils.homebudgettracker.infrastructure.enums.ProfileType;
import com.easyutils.homebudgettracker.infrastructure.jpa.DomainEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_profile")
@SequenceGenerator(name = "user_profile_seq_generator", sequenceName = "user_profile_seq", allocationSize = 1)
@DynamicUpdate
@DynamicInsert
public class UserProfile extends DomainEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profile_seq_generator")
    private Long id;
    private String uuid;
    @Column(name = "account_uuid")
    @NotEmpty
    private String accountUuid;
    @Column(name = "profile_name")
    @NotEmpty
    private String profileName;
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
    @Version
    @Column(name = "version")
    private int version;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_profile_uuid", referencedColumnName = "uuid")
    private List<VendorGroup> vendorGroups;
}
