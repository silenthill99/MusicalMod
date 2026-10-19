package fr.silenthill99.musicalmod.init;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.init.entities.stuart.Stuart;
import fr.silenthill99.musicalmod.init.entities.murdoc.Murdoc;
import fr.silenthill99.musicalmod.init.entities.noodle.Noodle;
import fr.silenthill99.musicalmod.init.entities.russel.Russel;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EntityTypesInit {

    public static final net.neoforged.neoforge.registries.DeferredRegister.Entities ENTITY_TYPE = DeferredRegister.createEntities(Main.MOD_ID);

    public static final Supplier<EntityType<Noodle>> NOODLE = ENTITY_TYPE.register("noodle", () ->
            EntityType.Builder.of(Noodle::new, MobCategory.MONSTER).sized(1.0f, 2.0f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Main.MOD_ID, "noodle"))));

    public static final Supplier<EntityType<Murdoc>> MURDOC = ENTITY_TYPE.register("murdoc", () ->
            EntityType.Builder.of(Murdoc::new, MobCategory.MONSTER).sized(1.0f, 2.0f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Main.MOD_ID, "murdoc"))));

    public static final Supplier<EntityType<Russel>> RUSSEL = ENTITY_TYPE.register("russel", () ->
            EntityType.Builder.of(Russel::new, MobCategory.AMBIENT).sized(1.0f, 2.0f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Main.MOD_ID, "russel"))));

    public static final Supplier<EntityType<Stuart>> STUART = ENTITY_TYPE.register("stuart", () ->
            EntityType.Builder.of(Stuart::new, MobCategory.AMBIENT).sized(1.0f, 2.0f)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Main.MOD_ID, "stuart"))));


}
