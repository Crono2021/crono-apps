.class public Lorg/drinkless/tdlib/TdApi$GetPremiumState;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPremiumState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PremiumState;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x278e3ae2


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2529
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 2534
    const v0, 0x278e3ae2

    return v0
.end method
