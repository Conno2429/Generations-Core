package generations.gg.generations.core.generationscore.common.world.item.armor;

import com.cobblemon.mod.common.CobblemonItems;
import com.google.common.base.Suppliers;
import generations.gg.generations.core.generationscore.common.GenerationsCore;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum GenerationsArmorMaterials implements ArmorMaterial {
    AETHER("aether", 15, new int[] { 2, 5, 6, 2 }, 9, GenerationsItems.SILICON),
    AQUA("saphire", 15, new int[] { 2, 5, 6, 2 }, 9, GenerationsItems.SAPPHIRE),
    FLARE("flare", 15, new int[] { 2, 5, 6, 2 }, 9, GenerationsItems.RUBY),
    GALACTIC("galactic", 15, new int[] { 2, 5, 6, 2 }, 9, GenerationsItems.SILICON),
    MAGMA("ruby", 15, new int[] { 2, 5, 6, 2 }, 19, GenerationsItems.RUBY),
    NEO_PLASMA("neo_plasma", 15, new int[] { 2, 5, 6, 2 }, 9, GenerationsItems.CRYSTAL),
    PLASMA("plasma", 15, new int[] { 2, 5, 6, 2 }, 9, GenerationsItems.CRYSTAL),
    ROCKET("rocket", 15, new int[] { 2, 5, 6, 2 }, 9, () -> Items.AMETHYST_SHARD),
    SKULL("skull", 15, new int[] { 2, 5, 6, 2 }, 9, GenerationsItems.SILICON),
    CRYSTAL("crystal", 15, new int[] { 2, 5, 6, 2 }, 9, GenerationsItems.CRYSTAL),

    ULTRA("ultra", 33, new int[] { 3, 6, 7, 3 }, 10, GenerationsItems.Z_INGOT),
    DAWN_STONE("dawn_stone", 33, new int[] { 3, 6, 8, 3 }, 10, () -> CobblemonItems.DAWN_STONE, 2.0f, 0.0f),
    DUSK_STONE("dusk_stone", 33, new int[] { 3, 6, 8, 3 }, 10, () -> CobblemonItems.DUSK_STONE, 2.0f, 0.0f),
    FIRE_STONE("fire_stone", 33, new int[] { 3, 6, 8, 3 }, 10, () -> CobblemonItems.FIRE_STONE, 2.0f, 0.0f),
    ICE_STONE("ice_stone", 33, new int[] { 3, 6, 8, 3 }, 10, () -> CobblemonItems.ICE_STONE, 2.0f, 0.0f),
    LEAF_STONE("leaf_stone", 33, new int[] { 3, 6, 8, 3 }, 10, () -> CobblemonItems.LEAF_STONE, 2.0f, 0.0f),
    MOON_STONE("moon_stone", 33, new int[] { 3, 6, 8, 3 }, 10, () -> CobblemonItems.MOON_STONE, 2.0f, 0.0f),
    SUN_STONE("sun_stone", 33, new int[] { 3, 6, 8, 3 }, 10, () -> CobblemonItems.SUN_STONE, 2.0f, 0.0f),
    THUNDER_STONE("thunder_stone", 33, new int[] { 3, 6, 8, 3 }, 10, () -> CobblemonItems.THUNDER_STONE, 2.0f, 0.0f),
    WATER_STONE("water_stone", 33, new int[] { 3, 6, 8, 3 }, 10, () -> CobblemonItems.WATER_STONE, 2.0f, 0.0f),

    ULTRITE("ultrite", 42, new int[]{3, 6, 8, 3}, 20, GenerationsItems.ULTRITE_INGOT, 4.0f, 0.2f);

	private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    GenerationsArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, Supplier<Item> repairIngredient, float toughness, float knockbackResistance) {
        this.name = GenerationsCore.MOD_ID + ":" + name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, slotProtections[0]);
            map.put(ArmorItem.Type.LEGGINGS, slotProtections[1]);
            map.put(ArmorItem.Type.CHESTPLATE, slotProtections[2]);
            map.put(ArmorItem.Type.HELMET, slotProtections[3]);
        });
        this.enchantmentValue = enchantmentValue;
        this.sound = SoundEvents.ARMOR_EQUIP_IRON;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Suppliers.memoize(() -> Ingredient.of(repairIngredient.get()));
    }

    GenerationsArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, Supplier<Item> repairIngredient) {
        this(name, durabilityMultiplier, slotProtections, enchantmentValue, repairIngredient, 0.0f, 0.0f);
    }

    @Override
    public int getDurabilityForType(ArmorItem.@NotNull Type type) {
        return ArmorMaterials.HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.slotProtections.get(type);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull SoundEvent getEquipSound() {
        return this.sound;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public @NotNull String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
