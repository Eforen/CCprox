package eforen.cc.prox.common;

import net.minecraft.src.EntityPlayer;
import dan200.computer.api.IComputerAccess;
import dan200.computer.api.IPeripheral;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityMob;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public class TileProX extends TileEntity implements IPeripheral {
	public synchronized void detach(IComputerAccess ica) {
		
	}
	public void attach(IComputerAccess ica, String s) {
		
	}
	public String getType() {
		return "proX";
	}
	public String[] getMethodNames() {
		return (new String[] {
			
		});
	}
	public Object[] code() {
		Object[] error = new Object[] {
			"Invalid number of args"
		};
		return error;
	}
	public Object[] callMethod(IComputerAccess ica, int i, Object[] args) throws Exception {
		return null;
	}
	public boolean canAttachToSide(int i) {
		return true;
	}
}
