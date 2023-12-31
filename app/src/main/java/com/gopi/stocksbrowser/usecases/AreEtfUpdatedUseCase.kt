package com.gopi.stocksbrowser.usecases

import com.gopi.stocksbrowser.repositories.PreferencesRepository
import java.time.LocalDate
import javax.inject.Inject

class AreEtfUpdatedUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {

    suspend operator fun invoke(): Boolean {
        val updatedAt = preferencesRepository.getEtfsUpdateDate() ?: return false
        return updatedAt > LocalDate.now().minusDays(1)
    }
}
