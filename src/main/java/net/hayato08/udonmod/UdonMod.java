package net.hayato08.udonmod;

import net.hayato08.udonmod.block.UdonBlocks;
import net.hayato08.udonmod.init.UdonModMenus;
import net.hayato08.udonmod.item.UdonCreativeModeTabs;
import net.hayato08.udonmod.item.UdonItems;
import net.hayato08.udonmod.item.custom.KitsuneKatanaItem;
import net.hayato08.udonmod.sound.UdonSounds;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.minecraft.util.Tuple;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;


@Mod(UdonMod.MOD_ID)
public class UdonMod
{
    public static final String MOD_ID = "udonmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public UdonMod(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerNetworking);

        NeoForge.EVENT_BUS.register(this);

        // レジストリの登録
        UdonCreativeModeTabs.register(modEventBus);
        UdonItems.register(modEventBus);
        UdonBlocks.register(modEventBus);
        UdonModMenus.register(modEventBus);
        UdonSounds.register(modEventBus);


        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private static boolean networkingRegistered = false;
    private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

    private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
    }

    public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
        if (networkingRegistered)
        {
            throw new IllegalStateException("Cannot register new network messages after networking has been registered");
        }
        MESSAGES.put(id, new NetworkMessage<>(reader, handler));
    }

    private void registerNetworking(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(MOD_ID);
        MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
        networkingRegistered = true;
    }

    public static void queueServerWork(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
            workQueue.add(new Tuple<>(action, tick));
    }

    private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();


    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(UdonItems.FLOUR);
            event.accept(UdonItems.DASHI);
            event.accept(UdonItems.DRY_UDON);
            event.accept(UdonItems.RAW_UDON);

        }
        else if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(UdonItems.BUKKAKE_UDON);
            event.accept(UdonItems.RICH_BUKKAKE_UDON);
            event.accept(UdonItems.CURRY_UDON);
            event.accept(UdonItems.RICH_CURRY_UDON);
            event.accept(UdonItems.COLD_UDON);
            event.accept(UdonItems.RICH_COLD_UDON);
            event.accept(UdonItems.KITSUNE_UDON);
            event.accept(UdonItems.RICH_KITSUNE_UDON);
            event.accept(UdonItems.ZARU_UDON);
            event.accept(UdonItems.RICH_ZARU_UDON);
        }
        else if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS)
        {
            event.accept(UdonBlocks.STONE_MILL);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }

    @SubscribeEvent
    public void tick(ServerTickEvent.Post event) {

        KitsuneKatanaItem.onServerTick(event); // きつね刀の処理（きつねの消滅）
        List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
        workQueue.forEach(work -> {
            work.setB(work.getB() - 1);
            if (work.getB() == 0)
                actions.add(work);
        });
        actions.forEach(e -> e.getA().run());
        workQueue.removeAll(actions);
    }
}
