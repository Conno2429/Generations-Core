package generations.gg.generations.core.generationscore.client.model;

import com.mojang.math.Axis;
import com.pokemod.pokemod.PokeMod;
import com.pokemod.pokemod.client.MinecraftClientGameProvider;
import com.pokemod.pokemod.client.PokeModClient;
import com.pokemod.pokeutils.PixelAsset;
import com.pokemod.rarecandy.components.MeshObject;
import com.pokemod.rarecandy.components.MultiRenderObject;
import com.pokemod.rarecandy.loading.ModelLoader;
import com.pokemod.rarecandy.pipeline.Pipeline;
import com.pokemod.rarecandy.rendering.ObjectInstance;
import com.pokemod.rarecandy.storage.ObjectManager;
import de.javagl.jgltf.model.GltfModel;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Represents a compiled model which can be rendered
 */
public class CompiledModel {
    public final MultiRenderObject<MeshObject> renderObject;

    public CompiledModel(ResourceLocation a, InputStream stream, Function<String, Pipeline> pipeline, Function<GltfModel, Supplier<MeshObject>> supplier) {
        var loader = PokeModClient.getRareCandy().getLoader();
        this.renderObject = loader.createObject(
                () -> new PixelAsset(stream, a.toString()),
                (gltfModel, smdFileMap, pkxFileMap, object) -> {
                    var glCalls = new ArrayList<Runnable>();
                    try {
                        ModelLoader.create2(object, gltfModel, smdFileMap, pkxFileMap, glCalls, pipeline, supplier.apply(gltfModel));
                    } catch (NullPointerException e) {
                        PokeMod.LOGGER.error("Catching exception reading model %s.".formatted(a));
                        e.printStackTrace();
                    }
                    return glCalls;
                },
                object -> {}
        );
    }

    public void render(ObjectInstance instance, Matrix4f projectionMatrix) {
        render(instance, projectionMatrix, false, PokeModClient.getRareCandy().objectManager);
    }

    public void render(ObjectInstance instance, Matrix4f projectionMatrix, boolean isYNotUp, ObjectManager objectManager) {
        if (!renderObject.isReady()) return;
        Minecraft.getInstance().getProfiler().push("create_model_instance");
        MinecraftClientGameProvider.projMatrix = projectionMatrix;
        var modelMatrix = new Matrix4f();
        modelMatrix.identity();
        if (isYNotUp) modelMatrix.rotate(Axis.XP.rotationDegrees(90));
        objectManager.add(this.renderObject, instance);
        Minecraft.getInstance().getProfiler().pop();
    }
}

