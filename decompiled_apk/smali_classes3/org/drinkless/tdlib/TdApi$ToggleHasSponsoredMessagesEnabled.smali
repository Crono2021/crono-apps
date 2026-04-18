.class public Lorg/drinkless/tdlib/TdApi$ToggleHasSponsoredMessagesEnabled;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleHasSponsoredMessagesEnabled"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x75055cec


# instance fields
.field public hasSponsoredMessagesEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21386
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21387
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 21377
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21378
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleHasSponsoredMessagesEnabled;->hasSponsoredMessagesEnabled:Z

    .line 21379
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21383
    const v0, 0x75055cec

    return v0
.end method
