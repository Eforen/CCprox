package eforen.cc.prox.common;

import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod (modid = "CCProX", name = "CCProX", version = "1.0")
@NetworkMod (
	clientSideRequired = true,
	serverSideRequired = false
	)
public class CoreProx {
	public static Block proXBlock;
	public static int proXBlockId;
	public static boolean[] cfg = new boolean[137];
	
	@SidedProxy (
			clientSide = "eforen.cc.prox.client.ClientProxy",
			serverSide = "eforen.cc.prox.common.CommonProxy"
	)
	
	public static CommonProxy proxy;
	public static boolean craftingEnabled;
	
	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		proXBlockId = config.getBlock("proX ID", 230).getInt();
		craftingEnabled = config.get("Crafting", "CCProX", true).getBoolean(true);
		for(int i=0;i<cfg.length;i++) {
			cfg[i] = config.get("ID list", "" + i, true).getBoolean(true);
		}
		config.save();
		System.out.println("CCBC config loaded.");
	}
	@Init
	public void load(FMLInitializationEvent event) {
		proXBlock = new BlockProjector
				(proXBlockId, 0)
				.setStepSound(Block.soundStoneFootstep)
				.setHardness(1F)
				.setResistance(1.0F)
				.setBlockName("Projector");
		GameRegistry.registerBlock(proXBlock);
		GameRegistry.registerTileEntity(TileProX.class, "tileEntityProjector");
		LanguageRegistry.addName(proXBlock, "Projector");
		if (craftingEnabled) {
			GameRegistry.addRecipe(new ItemStack(proXBlock,1), new Object[] {
				"IGI", "GRG", "IGI", 'I', Block.blockDiamond, 'G', Block.blockGold, 'R', Item.eyeOfEnder
			});
		}
		proxy.registerRenderThings();
	}
}
