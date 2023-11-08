package com.tempo.teamapi.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Teams {
    @Id
    var id: String? = null

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = false)
    var teamLeadId: String? = null

    @OneToMany(mappedBy = "teams")
    var userRoles: Set<UserRoles>? = null

}
