package com.example.mytherapy.di;

import com.example.mytherapy.data.local.MedicationDao;
import com.example.mytherapy.data.repository.MedicationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideMedicationRepositoryFactory implements Factory<MedicationRepository> {
  private final Provider<MedicationDao> medicationDaoProvider;

  public AppModule_ProvideMedicationRepositoryFactory(
      Provider<MedicationDao> medicationDaoProvider) {
    this.medicationDaoProvider = medicationDaoProvider;
  }

  @Override
  public MedicationRepository get() {
    return provideMedicationRepository(medicationDaoProvider.get());
  }

  public static AppModule_ProvideMedicationRepositoryFactory create(
      Provider<MedicationDao> medicationDaoProvider) {
    return new AppModule_ProvideMedicationRepositoryFactory(medicationDaoProvider);
  }

  public static MedicationRepository provideMedicationRepository(MedicationDao medicationDao) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMedicationRepository(medicationDao));
  }
}
