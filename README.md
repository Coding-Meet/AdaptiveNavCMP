# AdaptiveNavCMP

AdaptiveNavCMP is a Kotlin Multiplatform (KMP) project that demonstrates how to implement **Adaptive Navigation** using Compose Multiplatform and Material 3. The project showcases a responsive UI that adapts its navigation layout based on the window size class (Compact, Medium, Expanded), similar to modern media applications like YouTube.

## 🚀 Features

-   **Adaptive Navigation UI**: Automatically switches between a Bottom Navigation Bar (Compact), Navigation Rail (Medium), and potentially a Navigation Drawer (Expanded) using Material 3 Adaptive components.
-   **Custom Navigation Suite**: Implementation of a custom `NavigationSuiteScaffold` to have more control over the layout and padding.
-   **Kotlin Multiplatform**: Shared UI and logic across **Android**, **iOS**, and **Desktop (JVM)**.
-   **Type-Safe Navigation**: Uses the `androidx.navigation` library with type-safe routes.

### Build and Run

#### Android
-   Run from Android Studio or via terminal:
    ```shell
    ./gradlew :composeApp:run
    ```

#### Desktop (JVM)
-   Run via terminal:
    ```shell
    ./gradlew :composeApp:run
    ```

#### iOS
-   Open the `iosApp` directory in Xcode and run the project.
