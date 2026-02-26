package com.example.mytherapy.ui.screens;

import com.example.mytherapy.data.repository.MedicationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AddMedicationViewModel_Factory implements Factory<AddMedicationViewModel> {
  private final Provider<MedicationRepository> repositoryProvider;

  public AddMedicationViewModel_Factory(Provider<MedicationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AddMedicationViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static AddMedicationViewModel_Factory create(
      Provider<MedicationRepository> repositoryProvider) {
    return new AddMedicationViewModel_Factory(repositoryProvider);
  }

  public static AddMedicationViewModel newInstance(MedicationRepository repository) {
    return new AddMedicationViewModel(repository);
  }
}
