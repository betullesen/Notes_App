# Notes App
-------------
The app allows users to easily create, edit, delete, and search through their existing notes. Users can add new notes, edit or delete their existing notes. Additionally, they can use the search functionality to quickly find their notes. The app is designed with a user-friendly interface, making note management very simple.

## Features
- **Splash Screen**: A simple splash screen is displayed when the app is launched.
- **Create Notes**: Users can create new notes by entering a title and description.
- **Edit Notes**: Users can edit existing notes.
- **Delete Notes**: Users can delete notes they no longer need.
- **Search Notes**: Users can search for specific notes by title or description.

## Used Technologies

- **[Kotlin](https://kotlinlang.org/)**: The programming language for Android application development. A modern, secure, and efficient language widely used in Android app development.
- **[Android SDK](https://developer.android.com/studio)**: The software development kit (SDK) required for developing Android applications. It provides the necessary tools to create applications for Android devices.
- **[Android Jetpack](https://developer.android.com/jetpack)**: A set of libraries and tools designed to make Android app development easier. The Android Jetpack components used in this project are:
  - **[Room](https://developer.android.com/training/data-storage/room)**: A library used for database operations. It helps with the storage and management of data. Room manages database operations in a secure and efficient way.
  - **[LiveData](https://developer.android.com/reference/androidx/lifecycle/LiveData)**: Allows data to be updated in sync with the UI. It observes data changes and automatically updates the UI.
  - **[ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel)**: Separates UI and data management, handling data in a lifecycle-aware manner.
  - **[Navigation Component](https://developer.android.com/guide/navigation)**: Manages fragment transitions and provides easy navigation between fragments.
  - **[Fragment](https://developer.android.com/guide/fragments)**: Reusable UI components within an activity, allowing modularity and flexible UI design. This project extensively uses fragments for different views like Home, Add/Edit Notes, and Splash screens.
- **[Material Components](https://material.io/develop/android)**: Provides Android's Material Design elements for UI components (FAB, RecyclerView, etc.).
- **[SearchView](https://developer.android.com/reference/android/widget/SearchView)**: Allows users to search through notes.
- **[StaggeredGridLayoutManager](https://developer.android.com/reference/android/support/v7/widget/StaggeredGridLayoutManager)**: Provides a staggered grid layout for RecyclerView with varying item sizes.
- **[RecyclerView](https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView)**: A component used for listing data. It provides an efficient and flexible way to display data.
- **[Floating Action Button](https://material.io/components/floating-action-button)**: A round button typically used for key actions in the UI. It provides quick access to important interactions in the app.
- **[Handler and Looper](https://developer.android.com/reference/android/os/Handler)**: Used to wait for a specific amount of time on the Splash screen.
- **[Navigation Safe Args](https://developer.android.com/guide/navigation/passing-data)**: Ensures safe data passing between fragments.
- **[Gradle](https://gradle.org/)**: The build and dependency management tool used for Android projects. It handles project builds and dependency management.

## Preview 
![Image](https://github.com/user-attachments/assets/0db96982-5ef3-447f-a77e-b47f3dac33fb)
