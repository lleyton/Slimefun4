package io.github.thebusybiscuit.slimefun4.implementation.items;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

/**
 * A quick and easy implementation of {@link SlimefunItem} that also implements the
 * interface {@link Radioactive}.
 * 
 * Simply specify a level of {@link Radioactivity} in the constructor.
 * 
 * @author TheBusyBiscuit
 * 
 * @see Radioactive
 * @see Radioactivity
 *
 */
public class RadioactiveItem extends SlimefunItem implements Radioactive, NotPlaceable {

    private final Radioactivity radioactivity;

    /**
     * This will create a new {@link RadioactiveItem} with the given level of {@link Radioactivity}
     * 
     * @param category
     *            The {@link Category} of this {@link SlimefunItem}
     * @param radioactivity
     *            the level of {@link Radioactivity}
     * @param item
     *            the {@link SlimefunItemStack} this {@link SlimefunItem} represents
     * @param recipeType
     *            The {@link RecipeType} for this item
     * @param recipe
     *            The recipe of how to craft this {@link SlimefunItem}
     */
    public RadioactiveItem(Category category, Radioactivity radioactivity, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        this(category, radioactivity, item, recipeType, recipe, null);
    }

    /**
     * This will create a new {@link RadioactiveItem} with the given level of {@link Radioactivity}
     * 
     * @param category
     *            The {@link Category} of this {@link SlimefunItem}
     * @param radioactivity
     *            the level of {@link Radioactivity}
     * @param item
     *            the {@link SlimefunItemStack} this {@link SlimefunItem} represents
     * @param recipeType
     *            The {@link RecipeType} for this item
     * @param recipe
     *            The recipe of how to craft this {@link SlimefunItem}
     * @param recipeOutput
     *            The recipe output
     */
    public RadioactiveItem(Category category, Radioactivity radioactivity, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, ItemStack recipeOutput) {
        super(category, item, recipeType, recipe, recipeOutput);

        this.radioactivity = radioactivity;
        addItemHandler(onRightClick());
    }

    private ItemUseHandler onRightClick() {
        return PlayerRightClickEvent::cancel;
    }

    @Override
    public Radioactivity getRadioactivity() {
        return radioactivity;
    }

}
