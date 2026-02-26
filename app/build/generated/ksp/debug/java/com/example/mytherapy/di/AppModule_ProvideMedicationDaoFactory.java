package com.example.mytherapy.di;

import com.example.mytherapy.data.local.AppDatabase;
import com.example.mytherapy.data.local.MedicationDao;
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
public final class AppModule_ProvideMedicationDaoFactory implements Factory<MedicationDao> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public AppModule_ProvideMedicationDaoFactory(Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public MedicationDao get() {
    return provideMedicationDao(appDatabaseProvider.get());
  }

  public static AppModule_ProvideMedicationDaoFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new AppModule_ProvideMedicationDaoFactory(appDatabaseProvider);
  }

  public static MedicationDao provideMedicationDao(AppDatabase appDatabase) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMedicationDao(appDatabase));
  }
}
