package com.worldcretornica.plotme_core.bukkit.event;

import com.worldcretornica.plotme_core.Plot;
import com.worldcretornica.plotme_core.PlotMe_Core;
import com.worldcretornica.plotme_core.api.*;
import com.worldcretornica.plotme_core.api.event.InternalPlotClearEvent;
import com.worldcretornica.plotme_core.bukkit.api.*;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class PlotClearEvent extends PlotEvent implements Cancellable {

    private InternalPlotClearEvent event;

    public PlotClearEvent(PlotMe_Core instance, World world, Plot plot, Player clearer) {
        super(instance, plot, world);
        event = new InternalPlotClearEvent(instance, new BukkitWorld(world), plot, new BukkitPlayer(clearer));
    }
    
    public PlotClearEvent(PlotMe_Core instance, IWorld world, Plot plot, IPlayer clearer) {
        super(instance, plot, world);
        event = new InternalPlotClearEvent(instance, world, plot, clearer);
    }

    @Override
    public boolean isCancelled() {
        return event.isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        event.setCancelled(cancel);
    }

    public Player getPlayer() {
        return ((BukkitPlayer) event.getPlayer()).getPlayer();
    }
    
    public InternalPlotClearEvent getInternal() {
        return event;
    }
}
