package com.gopi.stocksbrowser.usecases

import com.gopi.stocksbrowser.repositories.PreferencesRepository
import java.time.LocalDate
import javax.inject.Inject

class SetEtfsUpdatedUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {

    suspend operator fun invoke() {
        preferencesRepository.setEtfsUpdateDate(LocalDate.now())
    }
}
