package com.tempo.teamapi.repositories

import com.tempo.teamapi.entities.UserRoles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRoleRepository : JpaRepository<UserRoles?, Long?> {
    @Query(value = "select u from UserRoles u where teams.id = ?1 and users.id = ?2")
    fun findByTeamIdAndUserId(teamId: String?, userId: String?): UserRoles?
}
