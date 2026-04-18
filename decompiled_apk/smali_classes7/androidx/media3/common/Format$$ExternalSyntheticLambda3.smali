.class public final synthetic Landroidx/media3/common/Format$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Ljava/util/function/Predicate;


# instance fields
.field public final synthetic f$0:Landroidx/media3/common/Format$Builder;


# direct methods
.method public synthetic constructor <init>(Landroidx/media3/common/Format$Builder;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/media3/common/Format$$ExternalSyntheticLambda3;->f$0:Landroidx/media3/common/Format$Builder;

    return-void
.end method


# virtual methods
.method public final test(Ljava/lang/Object;)Z
    .locals 1

    iget-object v0, p0, Landroidx/media3/common/Format$$ExternalSyntheticLambda3;->f$0:Landroidx/media3/common/Format$Builder;

    check-cast p1, Landroidx/media3/common/Label;

    invoke-static {v0, p1}, Landroidx/media3/common/Format;->lambda$new$0(Landroidx/media3/common/Format$Builder;Landroidx/media3/common/Label;)Z

    move-result p1

    return p1
.end method
