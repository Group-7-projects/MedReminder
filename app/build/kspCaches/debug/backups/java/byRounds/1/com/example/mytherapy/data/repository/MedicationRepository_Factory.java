package com.example.mytherapy.data.repository;

import com.example.mytherapy.data.local.MedicationDao;
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
public final class MedicationRepository_Factory implements Factory<MedicationRepository> {
  private final Provider<MedicationDao> medicationDaoProvider;

  public MedicationRepository_Factory(Provider<MedicationDao> medicationDaoProvider) {
    this.medicationDaoProvider = medicationDaoProvider;
  }

  @Override
  public MedicationRepository get() {
    return newInstance(medicationDaoProvider.get());
  }

  public static MedicationRepository_Factory create(Provider<MedicationDao> medicationDaoProvider) {
    return new MedicationRepository_Factory(medicationDaoProvider);
  }

  public static MedicationRepository newInstance(MedicationDao medicationDao) {
    return new MedicationRepository(medicationDao);
  }
}
