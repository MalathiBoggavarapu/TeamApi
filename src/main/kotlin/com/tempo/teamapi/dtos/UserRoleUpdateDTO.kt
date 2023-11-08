package com.tempo.teamapi.dtos

import com.tempo.teamapi.enums.Role

class UserRoleUpdateDTO {
    var teamId: String? = null
    var userId: String? = null
    var role: Role? = null
}
