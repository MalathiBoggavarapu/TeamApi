package com.tempo.teamapi.enums

enum class Membership(val membership: String) {
    GOLD("Gold"),
    SILVER("Silver"),
    NONE("None");

    companion object {
        fun getMembershipFromString(membershipAsString: String): Membership? {
            return Membership.values().firstOrNull { it.membership == membershipAsString }
        }
    }
}