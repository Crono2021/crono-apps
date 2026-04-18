.class public Lorg/drinkless/tdlib/TdApi$MessageEffectTypePremiumSticker;
.super Lorg/drinkless/tdlib/TdApi$MessageEffectType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageEffectTypePremiumSticker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x61962bf9


# instance fields
.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16422
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageEffectType;-><init>()V

    .line 16423
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 16413
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageEffectType;-><init>()V

    .line 16414
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageEffectTypePremiumSticker;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 16415
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16419
    const v0, 0x61962bf9

    return v0
.end method
