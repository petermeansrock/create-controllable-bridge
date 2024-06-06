# Create Fabric Controllable Prototype

This repository contains a prototype Fabric mod to bridge between Create and Controllable.

## Setup

This template is an extension of the base [Fabric Example Mod](https://github.com/FabricMC/fabric-example-mod).
Setup is mostly the same.

Additionally, set `recipe_viewer` in [gradle.properties](gradle.properties). Remember to remove unused
example code. Make sure versions are up-to-date.

When you publish your mod, you should use jars provided by GitHub Actions. These jars will have
build number metadata and will be compressed by the Machete plugin.

## Research

The easiest way to bridge Create and Controllable is by using Controllable's event registration hooks:

1. Controllable's `ControllerEvents.BUTTON` instance can be used to
   [register listener callbacks][controllable-hook-registration].
1. At runtime, Controllable gives [uses an `EventHelper` to give listeners][controllable-hook-invoke] an opportunity to
   handle an event.
1. This `EventHelper` then delegates to the appropriate instance in
   [`ControllerEvents`][controllable-hook-implementation].

A custom listener could leverage logic similar to Controllable's [hotbar scrolling code][create-mouse-scrolling] to
check for button presses. If the appropriate button is pressed, the listener could then handle events similar to
Create's [mouse wheel scrolling logic][create-mouse-scrolling].

Alternatively, the Vivecraft Compat mod [implemented a Create pop-up dialog][vivecraft-compat-create] to enable
elevator controls.

[create-mouse-scrolling]: https://github.com/Fabricators-of-Create/Create/blob/c5fe5a16a15072ad1976b968ae9a90df1987c7f8/src/main/java/com/simibubi/create/foundation/events/InputEvents.java#L32-L41
[controllable-scrolling]: https://github.com/MrCrayfish/Controllable/blob/c4f9d1a32c81018f5e6200a44c217cc0133f3178/Common/src/main/java/com/mrcrayfish/controllable/client/ControllerInput.java#L722-L735
[controllable-hook-registration]: https://github.com/MrCrayfish/Controllable/blob/c4f9d1a32c81018f5e6200a44c217cc0133f3178/Common/src/main/java/com/mrcrayfish/controllable/event/ControllerEvents.java#L29-L36
[controllable-hook-invoke]: https://github.com/MrCrayfish/Controllable/blob/c4f9d1a32c81018f5e6200a44c217cc0133f3178/Common/src/main/java/com/mrcrayfish/controllable/client/ControllerInput.java#L651-L652
[controllable-hook-implementation]: https://github.com/MrCrayfish/Controllable/blob/c4f9d1a32c81018f5e6200a44c217cc0133f3178/Common/src/main/java/com/mrcrayfish/controllable/client/util/EventHelper.java#L22-L25
[vivecraft-compat-create]: https://github.com/tom5454/ViveCraftCompat/commit/23eb1195e00bb23c2f425e739414999e26e5b992
