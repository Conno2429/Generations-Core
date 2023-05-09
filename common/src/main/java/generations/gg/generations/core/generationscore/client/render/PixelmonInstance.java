package generations.gg.generations.core.generationscore.client.render;

import com.pokemod.pokemod.api.render.LightingSettings;
import com.pokemod.rarecandy.storage.AnimatedObjectInstance;
import org.joml.Matrix4f;

import java.util.function.Supplier;

public class PixelmonInstance extends AnimatedObjectInstance {

    public final Supplier<LightingSettings> settingsSupplier;

    public PixelmonInstance(Matrix4f transformationMatrix, Matrix4f viewMatrix, String materialId, Supplier<LightingSettings> settingsSupplier) {
        super(transformationMatrix, viewMatrix, materialId);
        this.settingsSupplier = settingsSupplier;
    }

    public int lightColor() {
        return settingsSupplier.get().lightColor();
    }

    public float reflectivity() {
        return settingsSupplier.get().reflectivity();
    }

    public float shineDamper() {
        return settingsSupplier.get().shineDamper();
    }

    public float diffuseColorMix() {
        return settingsSupplier.get().diffuseColorMix();
    }
}
