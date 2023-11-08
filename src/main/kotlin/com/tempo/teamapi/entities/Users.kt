package com.tempo.teamapi.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Users {
    @Id
    var id: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var displayName: String? = null
    var avtarUrl: String? = null
    var location: String? = null

    @OneToMany(mappedBy = "users")
    var userRoles: Set<UserRoles>? = null
}
