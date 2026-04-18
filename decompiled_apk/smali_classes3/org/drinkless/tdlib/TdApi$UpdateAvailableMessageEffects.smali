.class public Lorg/drinkless/tdlib/TdApi$UpdateAvailableMessageEffects;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateAvailableMessageEffects"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x751af585


# instance fields
.field public reactionEffectIds:[J

.field public stickerEffectIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33788
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33789
    return-void
.end method

.method public constructor <init>([J[J)V
    .locals 0
    .param p1, "jArr"    # [J
    .param p2, "jArr2"    # [J

    .line 33778
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33779
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateAvailableMessageEffects;->reactionEffectIds:[J

    .line 33780
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateAvailableMessageEffects;->stickerEffectIds:[J

    .line 33781
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33785
    const v0, 0x751af585

    return v0
.end method
