package com.tempo.teamapi.repositories

import com.tempo.teamapi.entities.Teams
import org.springframework.data.jpa.repository.JpaRepository

interface TeamApiRepository: JpaRepository<Teams, String> {
}