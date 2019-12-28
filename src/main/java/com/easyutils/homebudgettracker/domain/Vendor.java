package com.easyutils.homebudgettracker.domain;

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
@Table(name = "vendor")
@SequenceGenerator(name = "vendor_seq_generator", sequenceName = "vendor_seq", allocationSize = 1)
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_seq_generator")
    private Long id;
    private String uuid;
    @Column(name = "vendor_name")
    @NotEmpty
    private String vendorName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "vendor_vendorgroup",
            joinColumns = {@JoinColumn(name = "vendor_uuid", referencedColumnName = "uuid")},
            inverseJoinColumns = {@JoinColumn(name = "vendor_group_uuid", referencedColumnName = "uuid")}
    )
    private List<VendorGroup> vendorGroups;
}
