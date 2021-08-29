![GitHub Actions](https://github.com/murattuzel/Catch-Some-Z-s/workflows/Static%20Analysis%20Checks/badge.svg)

## Caution
Android Gradle Plugin version 7.0.0 and upwards require Java 11 to run.
[Possible solutions] for the issue.

[Possible solutions]: https://stackoverflow.com/q/66980512/13310043

## Development

To maintain the style and quality of the code, are used the bellow static analysis tools. All of them use properly configuration and you find them in the project root directory `config/{toolName}`.

| Tools                             | Config file                                 | Check command                | Fix command               |
|-----------------------------------|--------------------------------------------:|------------------------------|---------------------------|
| [detekt][detekt]                  | [detekt.yml](/config/detekt/detekt.yml)     | `./gradlew detekt`           | -                         |
| [ktlint][ktlint]                  | -                                           | `./gradlew ktlint`           | `./gradlew ktlintFormat`  |
| [spotless][spotless]              | -                                           | `./gradlew spotlessCheck`    | `./gradlew spotlessApply` |
| [lint][lint]                      | [lint.xml](/config/lint/lint.xml)           | `./gradlew lint`             | -                         |

All gradle tasks are integrated in [pre-commit git hook], in order ensure that all static analysis and
tests passes before you can commit your changes. To skip them for specific commit add this option at your git command:

```properties
git commit --no-verify
```

It's highly recommended to fix broken code styles. There is [a gradle task](/build.gradle.kts#L22) which execute `ktlintFormat` and `spotlessApply` for you:

```properties
./gradlew reformat
```

[pre-commit git hook]: https://git-scm.com/book/en/v2/Customizing-Git-Git-Hooks

<img src="https://raw.githubusercontent.com/adessoTurkey/android-sample-app/develop/images/architecture-diagram.png" width="500" />

## Tech Stack

#### Dependencies

- **[Navigation Component](https://developer.android.com/jetpack/androidx/releases/navigation):** Consistent navigation between views
- **[LiveData](https://developer.android.com/topic/libraries/architecture/livedata):** Lifecycle aware observable and data holder
- **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel):** Holds UI data across configuration changes
- **[DataBinding](https://developer.android.com/topic/libraries/data-binding/):** Binds UI components in layouts to data sources
- **[Dagger-Hilt](https://github.com/google/dagger):** Dependency injector
- **[Coroutines](https://github.com/Kotlin/kotlinx.coroutines):** Asynchronous programming
- **[Coil](https://github.com/coil-kt/coil):** Image loading and caching
- **[ExoPlayer](https://github.com/google/ExoPlayer):** Media player for Android
- **[Kotlinx.Serialization](https://github.com/Kotlin/kotlinx.serialization):** JSON serializer/deserializer
- **[Retrofit](https://github.com/square/retrofit):** Type safe HTTP client
- **[ThreeTenABP](https://github.com/JakeWharton/ThreeTenABP):** Android compatible date and time API
- **[Timber](https://github.com/JakeWharton/timber):** Logging library for Android
- **[LeakCanary](https://github.com/square/leakcanary):** Memory leak detection library for Android
- **[Chucker](https://github.com/ChuckerTeam/chucker):** HTTP inspector for Android & OkHTTP 

#### Plugins

- **[Detekt][detekt]:** Static code analysis for Kotlin
- **[Spotless][spotless]:** Keep your code spotless
- **[Ktlint][ktlint]:** Kotlin linter
- **[Lint][lint]:** Static program analysis tools

[detekt]: https://github.com/arturbosch/detekt
[ktlint]: https://github.com/pinterest/ktlint
[spotless]: https://github.com/diffplug/spotless
[lint]: https://developer.android.com/studio/write/lint
