package antonio.com.br.aluraviagens.ui.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourcesUtil {
    public static Drawable devolveDrawable(Context context, String drawableEmtexto) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawableEmtexto,
                "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDrawable);
        return drawableImagemPacote;
    }
}
