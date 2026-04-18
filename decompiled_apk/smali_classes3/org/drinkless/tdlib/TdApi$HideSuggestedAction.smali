.class public Lorg/drinkless/tdlib/TdApi$HideSuggestedAction;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HideSuggestedAction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5d10d481


# instance fields
.field public action:Lorg/drinkless/tdlib/TdApi$SuggestedAction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14226
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 14227
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$SuggestedAction;)V
    .locals 0
    .param p1, "suggestedAction"    # Lorg/drinkless/tdlib/TdApi$SuggestedAction;

    .line 14217
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 14218
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$HideSuggestedAction;->action:Lorg/drinkless/tdlib/TdApi$SuggestedAction;

    .line 14219
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14223
    const v0, -0x5d10d481

    return v0
.end method
