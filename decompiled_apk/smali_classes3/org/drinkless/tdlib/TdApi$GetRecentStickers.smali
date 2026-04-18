.class public Lorg/drinkless/tdlib/TdApi$GetRecentStickers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetRecentStickers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Stickers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x228c5561


# instance fields
.field public isAttached:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13434
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13435
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 13425
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13426
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$GetRecentStickers;->isAttached:Z

    .line 13427
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13431
    const v0, -0x228c5561

    return v0
.end method
