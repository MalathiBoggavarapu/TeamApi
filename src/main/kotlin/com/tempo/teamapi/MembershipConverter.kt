package com.tempo.teamapi

import com.tempo.teamapi.enums.Membership
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class MembershipConverter : AttributeConverter<Membership?, String?> {
    override fun convertToDatabaseColumn(membership: Membership?): String? {
        return membership?.membership
    }

    override fun convertToEntityAttribute(databaseValue: String?): Membership? {
        return Membership.getMembershipFromString(databaseValue!!)
    }
}
