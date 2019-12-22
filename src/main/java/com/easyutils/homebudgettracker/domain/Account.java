package com.easyutils.homebudgettracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "account")
@SequenceGenerator(name = "account_seq_generator", sequenceName = "account_seq", allocationSize = 1)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq_generator")
    private Long id;
    private String uuid;
    @Column(name = "user_name")
    @NotEmpty
    private String userName;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_uuid", referencedColumnName = "uuid")
    private List<Profile> profile;
}
