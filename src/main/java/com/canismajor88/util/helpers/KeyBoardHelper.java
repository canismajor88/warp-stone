package com.canismajor88.util.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyBoardHelper {
    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingShift(){
        return InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(),GLFW.GLFW_KEY_LEFT_SHIFT)
                ||InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(),GLFW.GLFW_KEY_RIGHT_SHIFT);
    }
}
