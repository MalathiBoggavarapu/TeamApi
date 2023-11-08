package com.tempo.teamapi

import com.tempo.teamapi.enums.Role
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class RoleConverter : AttributeConverter<Role?, String?> {
    override fun convertToDatabaseColumn(role: Role?): String? {
        return role?.role
    }

    override fun convertToEntityAttribute(databaseValue: String?): Role? {
        return Role.getRoleFromString(databaseValue!!)
    }
}
