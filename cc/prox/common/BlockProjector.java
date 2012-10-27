package eforen.cc.prox.common;

import java.util.Random;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockProjector extends BlockContainer {
	public BlockProjector(int par1, int par2) {
		super(par1, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabRedstone);
	}
	public String getTextureFile() {
		return CommonProxy.textureLocation;
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		if (tile_entity == null || player.isSneaking()) {
			return false;
		}
		return true;
	}
	@Override
	public void breakBlock(World world, int x, int y, int z, int i, int j) {
		super.breakBlock(world, x, y, z, i, j);
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileProX();
	}
}
