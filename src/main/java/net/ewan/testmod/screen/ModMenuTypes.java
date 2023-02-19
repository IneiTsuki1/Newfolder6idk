package net.ewan.testmod.screen;

import net.ewan.testmod.testmod;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, testmod.MOD_ID);


    //
    public static final RegistryObject<MenuType<rocketWorkbenchMenu>> ROCKET_WORKBENCH_MENU =
            registerMenuType(rocketWorkbenchMenu::new, "rocketworkbenchmenu");

    public static final RegistryObject<MenuType<circuitFabricatorMenu>> CIRCUIT_FABRICATOR_MENU =
            registerMenuType(circuitFabricatorMenu::new, "circuit_fabricator_menu");

//
    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
