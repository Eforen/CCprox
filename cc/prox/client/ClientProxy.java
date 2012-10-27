package eforen.cc.prox.client;

import tiin57.holo.common.CommonProxy;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderThings() {
		MinecraftForgeClient.preloadTexture(CommonProxy.textureLocation);
	}
}