# 🗡️ Java Platformer Game

A 2D tile-based platformer built in Java using the `StdDraw` graphics library. Navigate through levels, dodge hazards, and reach the exit to advance!

---

## 🎮 Gameplay

- Move your character through each level using the keyboard
- Avoid floor spikes and ceiling spikes — touching either kills you instantly
- Reach the **exit tile** to advance to the next level
- The game ends when you complete all levels or die

---

## 🕹️ Controls

| Key | Action |
|-----|--------|
| ← Left Arrow | Move left |
| → Right Arrow | Move right |
| ↑ Up Arrow | Jump |
| Space | Jump |

---

## 🗂️ Project Structure

```
├── Game.java          # Main game loop — initializes the game and drives update/render cycles
├── Scene.java         # Builds and manages a level (blocks, hazards, player, exit)
├── World.java         # Loads all level data from worldData.txt
├── Player.java        # Player character with movement and animation
├── Physics.java       # Gravity, friction, velocity, and collision logic
├── Controller.java    # Maps keyboard input to player actions
├── GameObject.java    # Base class for all drawable/positional objects
├── Block.java         # Standard wall/floor tile with collision detection
├── FloorHazard.java   # Upward-facing spike tile (kills on contact)
├── CeilingHazard.java # Downward-facing spike tile (kills on contact)
├── Exit.java          # Level exit tile — touching it advances to the next level
├── Animation.java     # Cycles through image frames at a fixed interval (~75ms)
├── Pose.java          # Enum of player facing directions with associated animations
├── StdDraw.java       # Princeton graphics/input library (do not modify)
└── worldData.txt      # Level data file
```

---

## 📁 Assets Required

Place the following images in an `Assets/` folder in your project root:

| File | Used For |
|------|----------|
| `background.png` | Level background |
| `tile-brick.png` | Standard block tile |
| `tile-spikes-floor.png` | Floor hazard |
| `tile-spikes-ceiling.png` | Ceiling hazard |
| `tile-exit.png` | Exit tile |
| `link-right.png` | Player facing right (frame 1) |
| `link-right2.png` | Player facing right (frame 2) |
| `link-left.png` | Player facing left (frame 1) |
| `link-left2.png` | Player facing left (frame 2) |
| `link-down.png` | Player default/idle |

---

## 🗺️ Level Format (`worldData.txt`)

The world data file defines all levels. The format is:

```
<number of levels>
<rows> <cols>
<map line 1>
<map line 2>
...
```

### Tile Legend

| Symbol | Tile |
|--------|------|
| `#` | Solid block (wall/floor/ceiling) |
| `@` | Player spawn point |
| `!` | Exit |
| `A` | Floor spike (hazard) |
| `V` | Ceiling spike (hazard) |
| ` ` | Empty space |

### Example

```
14 12
############
#@         #
#          #
#AAAAAAAAA!#
############
```

---

## ▶️ How to Run

1. Compile all `.java` files:
   ```bash
   javac *.java
   ```

2. Run the game and pipe in the world data:
   ```bash
   java Game < worldData.txt
   ```

> **Note:** The game reads level data from standard input, so you must redirect `worldData.txt` when running.

---

## ⚙️ Physics Overview

The `Physics` class handles all movement simulation:

- **Gravity** is applied every frame, accelerating the player downward up to a terminal velocity
- **Friction** slows horizontal movement each frame when no key is held
- **Collisions** are checked against all solid blocks — floor, ceiling, and wall collisions are handled separately
- **Jumping** is only allowed when the player is grounded (not already jumping)

---

## 🧩 Class Hierarchy

```
GameObject
├── Block
│   ├── FloorHazard
│   ├── CeilingHazard
│   └── Exit
└── Player
```

---

## 📝 Notes

- The canvas size is automatically set based on the level dimensions (tiles × 32px)
- The Y-axis is **inverted** (0 is top, height is bottom) to match tile-map conventions
- `StdDraw` is Princeton's educational graphics library and handles both rendering and keyboard input
