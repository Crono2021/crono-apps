.class public Lorg/drinkless/tdlib/TdApi$GetPremiumStickers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPremiumStickers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Stickers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x10bef5b0


# instance fields
.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13344
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13345
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 13335
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13336
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetPremiumStickers;->limit:I

    .line 13337
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13341
    const v0, -0x10bef5b0

    return v0
.end method
