.class public Lorg/drinkless/tdlib/TdApi$SetGiftSettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetGiftSettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1ef458fe


# instance fields
.field public settings:Lorg/drinkless/tdlib/TdApi$GiftSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19716
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19717
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$GiftSettings;)V
    .locals 0
    .param p1, "giftSettings"    # Lorg/drinkless/tdlib/TdApi$GiftSettings;

    .line 19707
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19708
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetGiftSettings;->settings:Lorg/drinkless/tdlib/TdApi$GiftSettings;

    .line 19709
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19713
    const v0, -0x1ef458fe

    return v0
.end method
