---
name: Pitch Precision
colors:
  surface: '#f8f9ff'
  surface-dim: '#cbdbf5'
  surface-bright: '#f8f9ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#eff4ff'
  surface-container: '#e5eeff'
  surface-container-high: '#dce9ff'
  surface-container-highest: '#d3e4fe'
  on-surface: '#0b1c30'
  on-surface-variant: '#3c4a42'
  inverse-surface: '#213145'
  inverse-on-surface: '#eaf1ff'
  outline: '#6c7a71'
  outline-variant: '#bbcabf'
  surface-tint: '#006c49'
  primary: '#006c49'
  on-primary: '#ffffff'
  primary-container: '#10b981'
  on-primary-container: '#00422b'
  inverse-primary: '#4edea3'
  secondary: '#565e74'
  on-secondary: '#ffffff'
  secondary-container: '#dae2fd'
  on-secondary-container: '#5c647a'
  tertiary: '#a43a3a'
  on-tertiary: '#ffffff'
  tertiary-container: '#fc7c78'
  on-tertiary-container: '#711419'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#6ffbbe'
  primary-fixed-dim: '#4edea3'
  on-primary-fixed: '#002113'
  on-primary-fixed-variant: '#005236'
  secondary-fixed: '#dae2fd'
  secondary-fixed-dim: '#bec6e0'
  on-secondary-fixed: '#131b2e'
  on-secondary-fixed-variant: '#3f465c'
  tertiary-fixed: '#ffdad7'
  tertiary-fixed-dim: '#ffb3af'
  on-tertiary-fixed: '#410005'
  on-tertiary-fixed-variant: '#842225'
  background: '#f8f9ff'
  on-background: '#0b1c30'
  surface-variant: '#d3e4fe'
typography:
  headline-xl:
    fontFamily: Inter
    fontSize: 36px
    fontWeight: '700'
    lineHeight: 44px
    letterSpacing: -0.025em
  headline-xl-mobile:
    fontFamily: Inter
    fontSize: 28px
    fontWeight: '700'
    lineHeight: 34px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Inter
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 30px
    letterSpacing: -0.02em
  headline-md:
    fontFamily: Inter
    fontSize: 20px
    fontWeight: '600'
    lineHeight: 26px
    letterSpacing: -0.015em
  headline-sm:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '600'
    lineHeight: 22px
    letterSpacing: -0.01em
  body-lg:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
    letterSpacing: 0em
  body-md:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '400'
    lineHeight: 20px
    letterSpacing: 0em
  body-sm:
    fontFamily: Inter
    fontSize: 12px
    fontWeight: '400'
    lineHeight: 16px
    letterSpacing: 0.01em
  label-lg:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '500'
    lineHeight: 18px
    letterSpacing: 0.01em
  label-md:
    fontFamily: Inter
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
    letterSpacing: 0.02em
  label-sm:
    fontFamily: Inter
    fontSize: 10px
    fontWeight: '600'
    lineHeight: 14px
    letterSpacing: 0.04em
  metric-display:
    fontFamily: Inter
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 36px
    letterSpacing: -0.03em
rounded:
  sm: 0.125rem
  DEFAULT: 0.25rem
  md: 0.375rem
  lg: 0.5rem
  xl: 0.75rem
  full: 9999px
spacing:
  gutter: 1rem
  gutter-mobile: 0.75rem
  margin: 1rem
  margin-tablet: 1.5rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 0.75rem
  space-lg: 1rem
  space-xl: 1.5rem
  space-2xl: 2rem
---

## Brand & Style
The design system embodies a modern, high-performance athletic management aesthetic built around absolute clarity, tactical focus, and speed. Geared towards coaches, club directors, scouts, and players, the interface strips away visual bloat to deliver operational precision under pitch-side sunlight or rapid touch interaction.

The style fuses **Modern Functionalism** and **Tactile Minimalism**:
- **Pure Surfaces:** Crisp `#FFFFFF` canvases that eliminate cognitive noise and render stats, tactics, and rosters instantly scannable.
- **Pitch Energetics:** Emerald green accents evoke the precision cut of match turf, applied exclusively to key actions, real-time indicators, and positive performance metrics.
- **Deep Contrast Anchors:** A dense slate anchor bar (`#0F172A`) stabilizes mobile navigation, framing the white canvas and prioritizing single-thumb ergonomics.
- **Performance-First Geometry:** Flat surfaces, disciplined border weights, and zero graphic bloat to minimize GPU repaints and maintain low battery overhead during intensive matchday use.

## Colors
The color architecture prioritizes visual efficiency and contrast ratios compliant with WCAG AAA standards on dynamic data displays.

- **Primary (`#10B981`):** Pitch Emerald. Used for primary CTAs, active timeline events, live match status badges, and affirmative score trackers.
- **Secondary (`#0F172A`):** Deep Pitch Slate. Serves as the primary structural ground for the persistent bottom navigation bar, floating action summaries, and ultra-high-contrast title headings.
- **Neutral (`#64748B`):** Cool Slate. Drives secondary metadata, subtle dividers (`#E2E8F0`), placeholder text (`#94A3B8`), and structural outlines.
- **Canvas Base (`#FFFFFF`):** Pure White. The global background across all screens, cards, and modal sheets.
- **Subtle Surface (`#F8FAFC`):** Micro-tinted cool grey reserved for data table alternating rows, secondary metric backdrops, and disabled states.
- **Functional Semantics:**
  - Success/Live: `#10B981`
  - Warning/Caution (Yellow Card / Attention): `#F59E0B`
  - Critical/Expulsion (Red Card / Danger): `#EF4444`

## Typography
Typographic rhythm relies on `Inter` across all structural levels, using subtle weight shifts (400, 500, 600, 700) rather than decorative font switches.

- **Tabular Figures:** Always apply OpenType tabular numbers (`tnum`) to match clocks, player stats, squad numbers, and standings to prevent horizontal jitter during live score updates.
- **Hierarchy Rules:** Large headlines drop to tighter line heights to conserve vertical viewport space on compact mobile screens.
- **Labels & Micro-Data:** Labels, stat headers, and field position tags (e.g., `GK`, `CB`, `CM`, `ST`) utilize `label-sm` with slight uppercase tracking for glanceable identification.

## Layout & Spacing
The layout model operates on an 8-point base grid (with a 4-point micro-scale for precise metadata alignment).

- **Mobile Viewport (Primary):** Single-column vertical stream, 16px (`1rem`) outer canvas margins, and 12px horizontal gutters for multi-column stat cards and squad lineups.
- **Tablet / Split View (Pitch Mode):** Two-column split layout (e.g., interactive pitch view on the left, player roster and match events on the right) with 24px (`1.5rem`) margins.
- **Vertical Rhythm:** Tight component gaps (`space-xs` and `space-sm`) group related athlete data (name, position, fitness status), while larger gaps (`space-xl` and `space-2xl`) separate distinct operational modules (Training Plan, Next Fixture, Injury Report).
- **Navigation Inset:** All scrollable content incorporates a bottom padding of `80px` to clear the persistent dark navigation dock cleanly.

## Elevation & Depth
In alignment with the minimalist and low-resource overhead directives, depth is communicated through **structural borders and tonal differentiation**, eliminating GPU-heavy gaussian blurs and diffuse multi-stage shadows.

- **Surface Level 0 (Canvas):** `#FFFFFF` pure white, the default substrate.
- **Surface Level 1 (Cards & Data Tiles):** `#FFFFFF` with a crisp `1px` solid border (`#E2E8F0`). Flat profile, zero shadow.
- **Surface Level 2 (Selected / Active Tiles):** `#FFFFFF` framed by a `1.5px` border in `#10B981` with an interior accent highlight of `rgba(16, 185, 129, 0.04)`.
- **Surface Level 3 (Modals & Action Sheets):** `#FFFFFF` resting atop a light structural border (`#CBD5E1`), accompanied by an ultra-crisp, tight boundary shadow: `0px 4px 16px rgba(15, 23, 42, 0.08)`.
- **Anchored Surface (Bottom Nav):** Flat `#0F172A` ground with a top hairline border of `1px solid rgba(255, 255, 255, 0.08)` to separate the navigation layer without requiring floating elevations.

## Shapes
Geometry is disciplined, utilitarian, and athletic. Roundedness level `1` gives elements a clean, slightly softened engineering profile rather than an overly bubbly appearance:

- **Standard Elements (Buttons, Inputs, Metric Badges):** `4px` (`0.25rem`) radius.
- **Cards, Panels, and Grouped Lists:** `8px` (`0.5rem`) radius via `rounded-lg`.
- **Modals, Sheets, and Tactical Boards:** `12px` (`0.75rem`) radius via `rounded-xl`.
- **Strict Exceptions:** Live status dots, player jersey avatars, and active ball position indicators retain a true circle (`9999px` / `rounded-full`).

## Components

### Buttons
- **Primary Button:** `#10B981` background, white text (`#FFFFFF`), `font-weight: 600`, 44px min-touch height, `rounded` (4px). Active press scales to `0.98` opacity and darkens to `#059669`.
- **Secondary Button:** White background (`#FFFFFF`), `1px solid #E2E8F0` border, `#0F172A` text.
- **Ghost/Tertiary:** No background, `#64748B` text, switching to `#0F172A` when pressed.

### Navigation Dock (Dark Bottom Bar)
- **Container:** Persistent mobile bottom bar with `#0F172A` background, safe-area padding, and 64px bar height.
- **Items:** 4 to 5 icons with 10px labels underneath.
- **Inactive State:** Slate neutral `#64748B`, stroke 1.75px.
- **Active State:** High-contrast pitch emerald `#10B981` with a miniature 3px dot indicator beneath the icon.

### Cards & Data Containers
- White `#FFFFFF` container with `1px solid #E2E8F0` border and `rounded-lg` (8px).
- Internal padding of `16px` (`space-lg`).
- Cards avoid drop shadows, relying entirely on the border boundary to keep rendering instant.

### Chips & Badges
- **Status Badge (Live/In Match):** `#ECFDF5` background with `#047857` label, accompanied by a pulsing 6px `#10B981` indicator dot.
- **Filter Chips:** `#FFFFFF` background with `1px solid #E2E8F0` border. When selected, border switches to `#10B981` with `#065F46` text.

### Inputs & Search
- Inputs feature `#FFFFFF` ground, `1px solid #E2E8F0` border, `12px` horizontal padding, and `#0F172A` value text.
- Focused state transforms the border to `#10B981` with zero fuzzy focus rings, maintaining absolute edge crispness.

### Lists & Rosters
- List items feature a clean 52px height row with horizontal flex layout, bottom border of `1px solid #F1F5F9`.
- Left-aligned player number or position badge, middle-stacked player name and physical readiness, right-aligned stat data or quick chevron.

### Checkboxes & Radios
- Checkbox: 18x18px square with `rounded` (4px), `1.5px solid #CBD5E1`. Checked state fills with `#10B981` with a crisp white tick mark.
- Radio: 18x18px circle with `#10B981` inner solid dot when selected.