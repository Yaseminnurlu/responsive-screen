# Responsive Layout Challenge

This project demonstrates a responsive layout in Jetpack Compose that adapts to screen width.

## Layout Behavior

- **Phone / Narrow Screens**
  - Single scrollable `LazyColumn`.
  - Top section includes "Home" text and an action button.
  - Below is a list of items in `Card`s with `ListItem`s.

- **Tablet / Wide Screens**
  - `Row` with two panes:
    - **Left pane:** `NavigationRail` with Home and Settings.
    - **Right pane:** Header text ("Detail Content") and a scrollable list of items in `Card`s.

- Responsive layout is implemented using `BoxWithConstraints` to detect the screen width.

## Material 3 Components Used

- `NavigationRail`
- `NavigationRailItem`
- `Text`
- `Button`
- `Card`
- `ListItem`
- `Icon`

## Screenshots
<img width="584" height="381" alt="Screenshot 2026-02-24 at 1 40 45 PM" src="https://github.com/user-attachments/assets/65ccb548-2722-407b-81da-cb3b8531ef7b" />
<img width="357" height="695" alt="Screenshot 2026-02-24 at 1 41 34 PM" src="https://github.com/user-attachments/assets/c0bef05f-1ce7-433a-bd66-2045df386825" />



## AI Disclosure

This project uses guidance from an AI assistant to help structure the responsive layout and ensure correct Material 3 usage. All code was reviewed and understood before submission.
