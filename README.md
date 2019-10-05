# Test Amconsoft

This android application demonstrates how to use Google authorization, Crashlytics and Maps through Firebase services, and how to get and store data from RestAPI to local database.

#### Screenshots

<img src="https://i.imgur.com/LUZZcxn.png"  width="200" /> <img src="https://i.imgur.com/vIAFeTi.png"  width="200" /> <img src="https://i.imgur.com/9gyFhWh.png"  width="200" />

#### Video demonstation

Video preview is available <a href="https://youtu.be/KX4S7hegGxs" target="_blank">here</a>.

#### Release

Download <a href="https://drive.google.com/open?id=1d_mUwDRlVHciEP0wCrhC3HhTvnhKBpMt" target="_blank">apk file</a>.

#### Architecture

- Kotlin
- MVVM
- Android architecture components
- Repository pattern

#### Libraries
- Networking: Retrofit, OkHTTP;
- DI: Dagger2;
- Database: Room;
- RxJava2;
- Gson converter.

#### Usecases
###### Splash screen
- Check if user is signed in;
- Navigate to:
-- Auth screen (if not signed in);
-- or Main screen (if signed in).

###### Auth screen
- Do authorization using Google account;
- Navigate to Main screen.

###### Main screen
- Show user's Google account profile information (name);
- Do sign out and navigate to Auth screen;
- Show list of other users.

###### User detail screen
- Show user profile data (name, email, address, company);
- Show map with market with current location of user;
- Navigate to Main screen.

#### Credits
This app is done as test task for Amconsoft.
