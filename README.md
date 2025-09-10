# Contact Manager

- Contact Manager is a Sample Android app for managing contacts, built with Jetpack Compose, Room, and
MVVM architecture.
- It allows users to add, view, and update contacts with a clean and intuitive UI.

## Features

- View a list of contacts
- Add new contacts
- Update existing contacts
- Persistent local storage using Room
- Modern UI with Jetpack Compose
- MVVM architecture for maintainable code

## Getting Started

### Prerequisites

- Android Studio (Arctic Fox or newer recommended)
- Android device or emulator running API 21+

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/manojsinghdeopa/Contact-Manager.git
    ```
2. Open the project in Android Studio.
3. Build and run the app on your device or emulator.

## Project Structure

```
app/
  └── src/
      └── main/
          ├── java/com/msd/contactmanager/
          │   ├── data/
          │   │   ├── dao/           # Room DAO interfaces
          │   │   ├── database/      # Room database setup
          │   │   ├── model/         # Data models
          │   │   └── repository/    # Repository pattern
          │   ├── ui/
          │   │   ├── components/    # Reusable UI components
          │   │   ├── screens/       # Composable screens
          │   │   ├── theme/         # App theming
          │   │   └── viewmodel/     # ViewModel and factory
          │   └── MainActivity.kt    # App entry point
          ├── res/                   # Resources (layouts, drawables, etc.)
          └── AndroidManifest.xml
```

## Technologies Used

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Room Database](https://developer.android.com/jetpack/androidx/releases/room)
- [MVVM Architecture](https://developer.android.com/jetpack/guide)
- [Kotlin](https://kotlinlang.org/)

## Contributing

Contributions are welcome! Please open issues or submit pull requests for improvements and bug
fixes.


## Author

- [Manoj Singh Deopa](https://github.com/manojsinghdeopa)
