package com.tempo.teamapi.enums

enum class Role(val role: String) {
    PRODUCT_OWNER("Product Owner"),
    DEVELOPER("Developer"),
    TESTER("Tester");

    companion object {
        fun getRoleFromString(roleAsString: String): Role? {
            return values().firstOrNull { it.role == roleAsString }
        }
    }
}