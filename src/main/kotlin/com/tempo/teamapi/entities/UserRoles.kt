package com.tempo.teamapi.entities

import com.tempo.teamapi.MembershipConverter
import com.tempo.teamapi.RoleConverter
import com.tempo.teamapi.enums.Membership
import com.tempo.teamapi.enums.Role
import jakarta.persistence.*

@Entity
@Table(name = "UserRoles")
class UserRoles {
    @Id
    @Column(name = "id")
    var userRoleId: Long? = null

    @ManyToOne
    @JoinColumn(name = "team_id")
    var teams: Teams? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var users: Users? = null

    @Column(nullable = false)
    @Convert(converter = RoleConverter::class)
    var role: Role? = null

    @Convert(converter = MembershipConverter::class)
    var membership: Membership? = null
}
