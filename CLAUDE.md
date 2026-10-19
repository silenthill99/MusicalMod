
# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

A Minecraft mod (`musical_mod` / "MusicalMod") adding Gorillaz/pop-culture themed content: custom music discs (`ModItems`/`ModSoundEvents`), decorative statue blocks (`ModBlocks`), and mobs modeled after Gorillaz band members (`EntityTypesInit`). French is the primary dev language (commit messages, `lang/fr_fr.json`), with `lang/en_us.json` also maintained.

## ⚠️ Mixed Forge/NeoForge state — read before editing

The build tooling and the Java source are currently targeting **two different mod loader generations**, and the project will almost certainly fail to build as-is:

- `build.gradle` / `gradle.properties` are configured for **NeoForge 26.2.0.88** on **Minecraft 26.2**, using the `net.neoforged.moddev` Gradle plugin and Java 25 toolchain.
- `src/main/java/.../Main.java` and most classes under `src/main/java/.../init/` import a mix of **legacy Forge 1.16.5 APIs** (`net.minecraftforge.fml.*`, `net.minecraft.entity.CreatureEntity`, `net.minecraft.item.ItemGroup`, `EntityClassification`, etc.) **and** NeoForge APIs (`net.neoforged.bus.api.IEventBus`, `net.neoforged.fml.common.Mod`, `net.neoforged.neoforge.registries.DeferredRegister`) in the same files.
- `src/main/resources/META-INF/mods.toml` is still the **unedited Forge MDK template** (`modLoader="javafml"`, depends on `modId="forge"`, `versionRange="[1.16.5,1.17)"`) — NeoForge 26.2 expects a `neoforge.mods.toml` with the `javafml`/`neoforge` dependency format, not this file.
- `changelog.txt` / `README.txt` / `CREDITS.txt` are unmodified boilerplate from the Forge 1.16.5 MDK (not project-specific docs).

Before adding new features, check which API generation the surrounding file already (mostly) uses and don't assume the project currently compiles — verify with an actual build rather than reading the code alone.

## Commands

- Build: `./gradlew build` (Windows: `gradlew.bat build`)
- Run client: `./gradlew runClient`
- Run server: `./gradlew runServer`
- Run data generators (populates `src/generated/resources` from `--existing src/main/resources`): `./gradlew runData`
- Run gametests headlessly: `./gradlew runGameTestServer`
- Generate IDE run configs: `./gradlew genIntellijRuns` (IntelliJ) or `./gradlew genEclipseRuns` (Eclipse)
- There is no test source under `src/test` currently (directory exists but is empty) and no linter is configured.

## Architecture

- **Mod entry point**: `fr.silenthill99.musicalmod.Main`, annotated `@Mod(Main.MOD_ID)` where `MOD_ID = "musical_mod"`. Registers deferred registries on the mod event bus and hooks `clientSetup` (renderer/render-layer registration), `setup`, and `onEntityAttributeCreation`.
- **Registration pattern**: each content type has its own `DeferredRegister` holder class in `init/`:
  - `ModItems` — music discs (`MusicDiscItem`, backed by `ModSoundEvents`) and mob spawn eggs (`ForgeSpawnEggItem`).
  - `ModBlocks` — statue/decoration blocks; `createBlock(name, supplier)` registers both the `Block` and its matching `BlockItem` in one call, so new blocks should go through that helper rather than registering items separately.
  - `EntityTypesInit` — custom `EntityType`s for the Gorillaz mobs.
  - `ModSoundEvents` (in `utils/`) — one `SoundEvent` per music track, referenced by both `ModItems` and `assets/musical_mod/sounds.json`.
  - `ModItemGroups` (in `utils/`) — two creative tabs: `MusicalMod` (music discs) and `GorillazGroup` (statues/spawn eggs).
- **Blocks** (`init/blocks/`): custom blocks like `Statue2D`, `Cart`, `Chaise`, `StatueMurdoc`/`Noodle`/`Russel` define hand-authored `VoxelShape`s per facing direction (`SHAPE_N/S/E/O`) built from `Block.box(...)` unions, with `FACING` as a `DirectionProperty` state.
- **Entities** (`init/entities/<name>/`): each mob (`murdoc`, `noodle`, `russel`, `stuart`) follows a 3-file pattern — `<Name>` (entity behavior/goals/attributes), `<Name>Model` (geometry), `<Name>Renderer` (ties model+texture together, registered in `Main.clientSetup`).
- **Assets** live under `src/main/resources/assets/musical_mod/`: `blockstates/`, `models/{block,item}/`, `textures/{block,entities,item}/`, `sounds/` (the actual `.ogg` tracks) + `sounds.json`, and `lang/{en_us,fr_fr}.json`. Resource/translation keys follow `<type>.musical_mod.<registry_name>[.desc]`.
- Datagen output (`runData`) writes into `src/generated/resources`, which is wired into `sourceSets.main.resources` in `build.gradle` and should generally not be hand-edited.