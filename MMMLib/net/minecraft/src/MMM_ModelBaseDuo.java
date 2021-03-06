package net.minecraft.src;

import java.util.Map;
import java.util.Random;

import org.lwjgl.opengl.GL11;

/**
 * アーマーの二重描画用クラス。
 * 必ずInner側にはモデルを設定すること。
 * 通常のRendererで描画するためのクラスなので、Renderをちゃんと記述するならいらないクラスです。
 */
public class MMM_ModelBaseDuo extends MMM_ModelBaseNihil implements MMM_IModelBaseMMM {

	public MMM_ModelMultiBase modelOuter;
	public MMM_ModelMultiBase modelInner;
	/**
	 * 部位毎のアーマーテクスチャの指定。
	 * 外側。
	 */
	public ResourceLocation[] textureOuter;
	/**
	 * 部位毎のアーマーテクスチャの指定。
	 * 内側。
	 */
	public ResourceLocation[] textureInner;
	/**
	 * 部位毎のアーマーテクスチャの指定。
	 * 外側・発光。
	 */
	public ResourceLocation[] textureOuterLight;
	/**
	 * 部位毎のアーマーテクスチャの指定。
	 * 内側・発光。
	 */
	public ResourceLocation[] textureInnerLight;
	/**
	 * 描画されるアーマーの部位。
	 * shouldRenderPassとかで指定する。
	 */
	public int renderParts;


	public MMM_ModelBaseDuo(RendererLivingEntity pRender) {
		rendererLivingEntity = pRender;
		renderParts = 0;
	}

	@Override
	public void setLivingAnimations(EntityLivingBase par1EntityLiving, float par2, float par3, float par4) {
		if (modelInner != null) {
			modelInner.setLivingAnimations(entityCaps, par2, par3, par4);
		}
		if (modelOuter != null) {
			modelOuter.setLivingAnimations(entityCaps, par2, par3, par4);
		}
		isAlphablend = true;
	}

	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (isAlphablend) {
			if (isModelAlphablend) {
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			} else {
				GL11.glDisable(GL11.GL_BLEND);
			}
		}
		GL11.glColor3f(1F, 1F, 1F);
//		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
//		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		MMM_Client.setLightmapTextureCoords(lighting);

		if (modelInner != null) {
			if (textureInner != null) {
				if (textureInner[renderParts] != null) {
					MMM_Client.setTexture(textureInner[renderParts]);
					modelInner.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
				}
			} else {
				modelInner.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			}
			if (textureInnerLight != null) {
				if (textureInnerLight[renderParts] != null) {
					MMM_Client.setTexture(textureInnerLight[renderParts]);
					float var4 = 1.0F;
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthFunc(GL11.GL_LEQUAL);
					
					MMM_Client.setLightmapTextureCoords(0x00f000f0);//61680
					GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
					modelInner.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
					MMM_Client.setLightmapTextureCoords(lighting);
					
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glDepthMask(true);
				}
			}
		}
		if (modelOuter != null) {
			if (textureOuter != null) {
				if (textureOuter[renderParts] != null) {
					MMM_Client.setTexture(textureOuter[renderParts]);
					modelOuter.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
				}
			} else {
				modelOuter.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			}
			if (textureOuterLight != null) {
				if (textureOuterLight[renderParts] != null) {
					MMM_Client.setTexture(textureOuterLight[renderParts]);
					float var4 = 1.0F;
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthFunc(GL11.GL_LEQUAL);
					
					MMM_Client.setLightmapTextureCoords(0x00f000f0);//61680
					GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
					modelOuter.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
					MMM_Client.setLightmapTextureCoords(lighting);
					
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glDepthMask(true);
				}
			}
		}
		isAlphablend = false;
	}

	@Override
	public TextureOffset getTextureOffset(String par1Str) {
		return modelInner == null ? null : modelInner.getTextureOffset(par1Str);
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Entity par7Entity) {
		if (modelInner != null) {
			modelInner.setRotationAngles(par1, par2, par3, par4, par5, par6, entityCaps);
		}
		if (modelOuter != null) {
			modelOuter.setRotationAngles(par1, par2, par3, par4, par5, par6, entityCaps);
		}
	}


	// IModelMMM追加分

	@Override
	public void renderItems(EntityLivingBase pEntity, Render pRender) {
		if (modelInner != null) {
			modelInner.renderItems(entityCaps);
		}
	}

	@Override
	public void showArmorParts(int pParts) {
		if (modelInner != null) {
			modelInner.showArmorParts(pParts, 0);
		}
		if (modelOuter != null) {
			modelOuter.showArmorParts(pParts, 1);
		}
	}

	/**
	 * Renderer辺でこの変数を設定する。
	 * 設定値はMMM_IModelCapsを継承したEntitiyとかを想定。
	 */
	@Override
	public void setEntityCaps(MMM_IModelCaps pEntityCaps) {
		entityCaps = pEntityCaps;
		if (capsLink != null) {
			capsLink.setEntityCaps(pEntityCaps);
		}
	}

	@Override
	public void setRender(Render pRender) {
		if (modelInner != null) {
			modelInner.render = pRender;
		}
		if (modelOuter != null) {
			modelOuter.render = pRender;
		}
	}

	@Override
	public void setArmorRendering(boolean pFlag) {
		isRendering = pFlag;
	}


	// IModelCaps追加分

	@Override
	public Map<String, Integer> getModelCaps() {
		return modelInner == null ? null : modelInner.getModelCaps();
	}

	@Override
	public Object getCapsValue(int pIndex, Object ... pArg) {
		return modelInner == null ? null : modelInner.getCapsValue(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		if (capsLink != null) {
			capsLink.setCapsValue(pIndex, pArg);
		}
		if (modelOuter != null) {
			modelOuter.setCapsValue(pIndex, pArg);
		}
		if (modelInner != null) {
			return modelInner.setCapsValue(pIndex, pArg);
		}
		return false;
	}

	@Override
	public void showAllParts() {
		if (modelInner != null) {
			modelInner.showAllParts();
		}
		if (modelOuter != null) {
			modelOuter.showAllParts();
		}
	}

}
