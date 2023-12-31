# Stock Browser 📈   [Kotlin Mini Project associated with LPU (Subject Code: CSE226)]

Stock Browser is a comprehensive Android application designed to provide an immersive experience in stock market browsing. The app allows users to sign in with their Google account, switch between light/dark modes, provide feedback, rate the app, and much more.

🔗 **Demo Video**: 

https://github.com/gopi76/stock-browser/assets/107085222/73df52c4-2f6d-4b8a-a96a-cee8793db1cc


## Features 🌟

- **Sign In through Google**: Securely log in via Google. User data is stored in Firebase.
- **App Modes**: Toggle between light and dark modes at the start of the main page.
- **Rating Bar**: Rate the app and receive a notification as feedback.
- **Feedback System**: Send queries and get visual feedback.
- **User Account**: Dedicated section for user profiles and data.
- **Logout & Exit**: Intuitive user flow with added confirmation for logout and app exit actions.
- **Floating Action Buttons (FAB)**: Multi-utility buttons for making calls, opening maps, and accessing company websites.
- **UpStock Data**: Integrates stock market data from multiple third-party APIs. Search, browse, and favorite stocks.

## Tech Stack 🛠

#### CSE225 (Developing Android Apps):
- Splash Screen
- Progress Bar
- Intents (both explicit and implicit)
- Loading 
- Notification
- Navigation Drawer
- Rating Bar

#### CSE226 (Android App Deployment):
- Floating Action Buttons
- Maps-Geocoding
- Room database

#### Other:
- Firebase Authentication
- Alert Dialog Box

## Architecture 🏗

Stock Browser uses the *MVI (Model View Intent)* architectural pattern and follows the principles of separation of concerns. The app is divided into three main layers:

1. **UI Layer**: Displays application data on screen using Jetpack Compose. Maintains the state of simple components.
2. **Domain Layer**: Encapsulates complex business logic and handles logic used by multiple ViewModels.
3. **Data Layer**: Holds application data and associated business logic.

## Contribute 🤝

Feel free to fork this repository and contribute. Any feedback, improvements, or feature requests are welcome!

---

Made with ❤ by [gopi76](https://github.com/gopi76)
