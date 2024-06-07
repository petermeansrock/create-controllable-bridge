package com.petermeansrock.minecraft.create.controllable;

import com.simibubi.create.Create;
import com.simibubi.create.content.contraptions.elevator.ElevatorControlsHandler;

import com.mrcrayfish.controllable.client.binding.ButtonBindings;
import com.mrcrayfish.controllable.client.input.Controller;
import com.mrcrayfish.controllable.event.ControllerEvents;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateControllableBridgeMod implements ModInitializer {
	public static final String ID = "create-controllable-bridge";
	public static final String NAME = "Create Controllable Bridge";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);

		ControllerEvents.BUTTON.register(CreateControllableBridgeMod::handleButtonPress);
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}

	public static boolean handleButtonPress(Controller controller) {
		if (ButtonBindings.SCROLL_LEFT.isButtonPressed()) {
			return ElevatorControlsHandler.onScroll(-1.0);
		} else if (ButtonBindings.SCROLL_RIGHT.isButtonPressed()) {
			return ElevatorControlsHandler.onScroll(1.0);
		}

		return false;
	}
}
