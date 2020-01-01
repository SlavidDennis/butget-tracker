package com.easyutils.homebudgettracker.domain;

import com.easyutils.homebudgettracker.infrastructure.jpa.AuditableDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vendor_group")
@SequenceGenerator(name = "vendor_group_seq_generator", sequenceName = "vendor_group_seq", allocationSize = 1)
public class VendorGroup extends AuditableDate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_group_seq_generator")
    private Long id;
    private String uuid;
    @Column(name = "user_profile_uuid")
    @NotEmpty
    private String userProfileUuid;
    @Column(name = "group_name")
    @NotEmpty
    private String groupName;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendor_group_uuid", referencedColumnName = "uuid")
    private List<Vendor> vendors;
}
