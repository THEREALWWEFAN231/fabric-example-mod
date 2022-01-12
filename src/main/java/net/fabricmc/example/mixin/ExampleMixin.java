package net.fabricmc.example.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;

@Mixin(MinecraftClient.class)
public class ExampleMixin {
	
	//this is what LocalCapture.PRINT says/this is the what mixin requires, but crashes when injecting
	@Inject(method = { "doItemUse" }, at = { @At(value = "INVOKE", target = "net/minecraft/client/network/ClientPlayerEntity.swingHand(Lnet/minecraft/util/Hand;)V", ordinal = 1) }, locals = LocalCapture.CAPTURE_FAILHARD)
	private void onBlockUse(CallbackInfo ci, Hand var1[], int var2, int var3, Hand hand, ItemStack itemStack, EntityHitResult entityHitResult, Entity entity, ActionResult actionResult, BlockHitResult blockHitResult, int i, ActionResult actionResult2) {
		System.out.println("epic");
	}
	
	//this is what it should be/what should work?
	/*@Inject(method = { "doItemUse" }, at = { @At(value = "INVOKE", target = "net/minecraft/client/network/ClientPlayerEntity.swingHand(Lnet/minecraft/util/Hand;)V", ordinal = 1) }, locals = LocalCapture.CAPTURE_FAILHARD)
	private void onBlockUse(CallbackInfo ci, Hand var1[], int var2, int var3, Hand hand, ItemStack itemStack, EntityHitResult entityHitResult, BlockHitResult blockHitResult, int i, ActionResult actionResult2) {
		System.out.println("epic");
	}*/
	
}
