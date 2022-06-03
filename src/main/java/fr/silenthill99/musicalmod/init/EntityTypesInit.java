package fr.silenthill99.musicalmod.init;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.init.entities.stuart.Stuart;
import fr.silenthill99.musicalmod.init.entities.murdoc.Murdoc;
import fr.silenthill99.musicalmod.init.entities.noodle.Noodle;
import fr.silenthill99.musicalmod.init.entities.russel.Russel;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypesInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Main.MOD_ID);

    public static final RegistryObject<EntityType<Noodle>> NOODLE = ENTITY_TYPE.register("noodle", () ->
            EntityType.Builder.of(Noodle::new, EntityClassification.MONSTER).sized(1.0f, 2.0f)
                    .build(new ResourceLocation(Main.MOD_ID, "noodle").toString()));

    public static final RegistryObject<EntityType<Murdoc>> MURDOC = ENTITY_TYPE.register("murdoc", () ->
            EntityType.Builder.of(Murdoc::new, EntityClassification.MONSTER).sized(1.0f, 2.0f)
                    .build(new ResourceLocation(Main.MOD_ID, "murdoc").toString()));

    public static final RegistryObject<EntityType<Russel>> RUSSEL = ENTITY_TYPE.register("russel", () ->
            EntityType.Builder.of(Russel::new, EntityClassification.AMBIENT).sized(1.0f, 2.0f)
                    .build(new ResourceLocation(Main.MOD_ID, "russel").toString()));

    public static final RegistryObject<EntityType<Stuart>> STUART = ENTITY_TYPE.register("stuart", () ->
            EntityType.Builder.of(Stuart::new, EntityClassification.AMBIENT).sized(1.0f, 2.0f)
                    .build(new ResourceLocation(Main.MOD_ID, "stuart").toString()));


}
