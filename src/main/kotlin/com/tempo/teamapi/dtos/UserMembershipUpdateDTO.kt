package com.tempo.teamapi.dtos

import com.tempo.teamapi.enums.Membership
import com.tempo.teamapi.enums.Role

class UserMembershipUpdateDTO {
    var teamId: String? = null
    var userId: String? = null
    var membership: Membership? = null
}