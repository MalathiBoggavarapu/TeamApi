package com.tempo.teamapi

import com.tempo.teamapi.dtos.TeamsDTO
import com.tempo.teamapi.dtos.UserRoleUpdateDTO
import com.tempo.teamapi.entities.Teams
import com.tempo.teamapi.entities.UserRoles
import com.tempo.teamapi.entities.Users
import com.tempo.teamapi.enums.Role
import com.tempo.teamapi.exceptions.NoDataFoundException
import com.tempo.teamapi.repositories.TeamApiRepository
import com.tempo.teamapi.repositories.UserRoleRepository
import com.tempo.teamapi.services.TeamApiService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class TeamApiServiceTests {
    @InjectMocks
    var teamApiService: TeamApiService? = null

    @Mock
    var teamApiRepository: TeamApiRepository? = null

    @Mock
    var userRoleRepository: UserRoleRepository? = null
    @Test
    fun updateRole_SuccessFlow() {
        val userRoles = UserRoles()
        userRoles.role = Role.TESTER
        userRoles.teams = createTeams("1", "TeamLead1", "Name1")
        userRoles.users = createUsers("1", "DisplayName1")
        Mockito.`when`(userRoleRepository!!.findByTeamIdAndUserId(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(userRoles)
        teamApiService!!.updateUserRole(userRoleUpdateDTO)
        Mockito.verify(userRoleRepository)?.save(userRoles)
    }

    @Test
    fun updateRole_TeamIdNotFound() {
        Mockito.`when`(userRoleRepository!!.findByTeamIdAndUserId(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(null)
        Assertions.assertThrows(NoDataFoundException::class.java) { teamApiService!!.updateUserRole(userRoleUpdateDTO) }
    }

    @Test
    fun test_findAllTeams() {
        Mockito.`when`(teamApiRepository!!.findAll()).thenReturn(listOf(createTeam()))
        val teamsDTOS: List<TeamsDTO> = teamApiService!!.getTeams()
        Assertions.assertEquals(1, teamsDTOS.size)
        Assertions.assertEquals("1", teamsDTOS[0].id)
        Assertions.assertEquals("2", teamsDTOS[0].teamLeadId)
        Assertions.assertEquals("1", teamsDTOS[0].users?.get(0)?.id)
        Assertions.assertEquals("Tester", teamsDTOS[0].users?.get(0)?.role)
    }

    private fun createTeam(): Teams {
        val team = Teams()
        team.id = "1"
        team.name = "Name1"
        team.teamLeadId = "2"
        val userRoles = UserRoles()
        userRoles.teams = createTeams("1", "1", "TeamName1")
        userRoles.users = createUsers("1", "displayName1")
        userRoles.role = Role.TESTER
        team.userRoles = setOf(userRoles)

        return team
    }

    private val userRoleUpdateDTO: UserRoleUpdateDTO
        get() {
            val userRoleUpdateDTO = UserRoleUpdateDTO()
            userRoleUpdateDTO.teamId = "1"
            userRoleUpdateDTO.userId = "1"
            userRoleUpdateDTO.role = Role.TESTER
            return userRoleUpdateDTO
        }

    private fun createUsers(id: String, displayName: String): Users {
        val users = Users()
        users.id = id
        users.displayName = displayName
        return users
    }

    private fun createTeams(id: String, teamLeadId: String, name: String): Teams {
        val teams = Teams()
        teams.id = id
        teams.teamLeadId = teamLeadId
        teams.name = name
        return teams
    }
}
