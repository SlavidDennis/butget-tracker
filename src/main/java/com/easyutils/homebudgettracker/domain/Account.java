package com.easyutils.homebudgettracker.domain;

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
import java.util.List;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "account")
@SequenceGenerator(name = "account_seq_generator", sequenceName = "account_seq", allocationSize = 1)
@DynamicUpdate
@DynamicInsert
public class Account extends DomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq_generator")
    private Long id;
    private String uuid;
    @Column(name = "user_name")
    @NotEmpty
    private String userName;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_uuid", referencedColumnName = "uuid")
    private List<UserProfile> userProfiles;
}
