package com.tempo.teamapi.services

import com.tempo.teamapi.dtos.TeamsDTO
import com.tempo.teamapi.dtos.UserMembershipUpdateDTO
import com.tempo.teamapi.dtos.UserRoleUpdateDTO
import com.tempo.teamapi.dtos.UserRolesDTO
import com.tempo.teamapi.entities.Teams
import com.tempo.teamapi.entities.UserRoles
import com.tempo.teamapi.enums.Role
import com.tempo.teamapi.exceptions.NoDataFoundException
import com.tempo.teamapi.repositories.TeamApiRepository
import com.tempo.teamapi.repositories.UserRoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeamApiService {
    @Autowired
    private lateinit var teamApiRepository: TeamApiRepository

    @Autowired
    private lateinit var userRoleRepository: UserRoleRepository

    fun getTeams() : List<TeamsDTO> {
        return teamApiRepository.findAll().map { teams: Teams -> createTeamsDTO(teams) }
    }

    fun updateUserRole(userRoleUpdateDTO: UserRoleUpdateDTO) {
        val userRole: UserRoles = userRoleRepository.findByTeamIdAndUserId(userRoleUpdateDTO.teamId, userRoleUpdateDTO.userId)
                ?: throw NoDataFoundException()
        if (userRoleUpdateDTO.role != null) {
            userRole.role = userRoleUpdateDTO.role
        } else {
            userRole.role = Role.DEVELOPER
        }
        userRoleRepository.save(userRole)
    }

    fun updateUserMembership(userMembershipUpdateDTO: UserMembershipUpdateDTO) {
        val userRole: UserRoles = userRoleRepository.findByTeamIdAndUserId(userMembershipUpdateDTO.teamId, userMembershipUpdateDTO.userId)
                ?: throw NoDataFoundException()
        if (userMembershipUpdateDTO.membership != null) {
            userRole.membership = userMembershipUpdateDTO.membership
        }
        userRoleRepository.save(userRole)
    }

    private fun createTeamsDTO(teams: Teams): TeamsDTO {
        val teamsDTO = TeamsDTO()
        teamsDTO.id = teams.id
        teamsDTO.name = teams.name
        teamsDTO.teamLeadId = teams.teamLeadId
        teamsDTO.users = teams.userRoles!!.filter { it.teams!!.id == teams.id }.map {
            val rolesDTO = UserRolesDTO()
            rolesDTO.id = it.users!!.id
            rolesDTO.role = if (it.role != null) it.role!!.role else null
            rolesDTO.membership= it.membership?.membership
            rolesDTO
        }
        return teamsDTO
    }
}
