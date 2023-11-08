package com.tempo.teamapi

import com.tempo.teamapi.dtos.TeamsDTO
import com.tempo.teamapi.dtos.UserMembershipUpdateDTO
import com.tempo.teamapi.dtos.UserRoleUpdateDTO
import com.tempo.teamapi.exceptions.BadRequestException
import com.tempo.teamapi.exceptions.NoDataFoundException
import com.tempo.teamapi.services.TeamApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TempoRestController {
    @Autowired
    private lateinit var teamApiService: TeamApiService

    @GetMapping(value = ["/Teams"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTeams() : List<TeamsDTO> {
        return teamApiService.getTeams();
    }

    @PatchMapping(value = ["/updateUserRole"])
    fun updateUserRole(@RequestBody userRoleUpdateDTO: UserRoleUpdateDTO?): String {
        if(userRoleUpdateDTO == null) {
            throw BadRequestException()
        }
        teamApiService.updateUserRole(userRoleUpdateDTO)
        return "Role Updated Successfully!"
    }

    @PatchMapping(value = ["/updateMembership"])
    fun updateUserMembership(@RequestBody userMembershipUpdateDTO: UserMembershipUpdateDTO?): String {
        if(userMembershipUpdateDTO == null) {
            throw BadRequestException()
        }
        teamApiService.updateUserMembership(userMembershipUpdateDTO)
        return "Membership Updated Successfully!"
    }
}
