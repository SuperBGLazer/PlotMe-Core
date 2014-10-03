package com.worldcretornica.plotme_core.bukkit.event;

import com.worldcretornica.plotme_core.Plot;
import com.worldcretornica.plotme_core.PlotMe_Core;
import com.worldcretornica.plotme_core.api.*;
import com.worldcretornica.plotme_core.api.event.InternalPlotTeleportEvent;
import com.worldcretornica.plotme_core.bukkit.api.*;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class PlotTeleportEvent extends PlotEvent implements Cancellable {

    private InternalPlotTeleportEvent event;

    public PlotTeleportEvent(PlotMe_Core instance, World world, Plot plot, Player player, Location loc, String plotId) {
        super(instance, plot, world);
        event = new InternalPlotTeleportEvent(instance, new BukkitWorld(world), plot, new BukkitPlayer(player), new BukkitLocation(loc), plotId);
    }
    
    public PlotTeleportEvent(PlotMe_Core instance, IWorld world, Plot plot, IPlayer player, ILocation loc, String plotId) {
        super(instance, plot, world);
        event = new InternalPlotTeleportEvent(instance, world, plot, player, loc, plotId);
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

    public Location getLocation() {
        return ((BukkitLocation) event.getLocation()).getLocation();
    }

    public String getPlotId() {
        return event.getPlotId();
    }

    public boolean getIsPlotClaimed() {
        return (event.getPlot() != null);
    }
    
    public InternalPlotTeleportEvent getInternal() {
        return event;
    }
}
