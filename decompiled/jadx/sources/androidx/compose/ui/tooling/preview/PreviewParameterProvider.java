package androidx.compose.ui.tooling.preview;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: PreviewParameter.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "T", "", "count", "", "getCount", "()I", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "ui-tooling-preview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PreviewParameterProvider<T> {

    /* compiled from: PreviewParameter.android.kt */
    @SynthesizedClassV2(kind = 8, versionHash = "b33e07cc0d03f9f0e6c4c883743d0373fd130388f5a551bfa15ea60a927a2ecb")
    /* renamed from: androidx.compose.ui.tooling.preview.PreviewParameterProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static int $default$getCount(PreviewParameterProvider previewParameterProvider) {
            return SequencesKt.count(previewParameterProvider.getValues());
        }
    }

    /* compiled from: PreviewParameter.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> int getCount(PreviewParameterProvider<T> previewParameterProvider) {
            return CC.$default$getCount(previewParameterProvider);
        }
    }

    int getCount();

    Sequence<T> getValues();
}
