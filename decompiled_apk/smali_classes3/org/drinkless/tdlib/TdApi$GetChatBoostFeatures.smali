.class public Lorg/drinkless/tdlib/TdApi$GetChatBoostFeatures;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatBoostFeatures"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatBoostFeatures;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x173ed760


# instance fields
.field public isChannel:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12319
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 12309
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12310
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatBoostFeatures;->isChannel:Z

    .line 12311
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12315
    const v0, -0x173ed760

    return v0
.end method
