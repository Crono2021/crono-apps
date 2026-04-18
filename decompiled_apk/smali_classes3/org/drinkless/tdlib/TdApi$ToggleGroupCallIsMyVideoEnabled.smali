.class public Lorg/drinkless/tdlib/TdApi$ToggleGroupCallIsMyVideoEnabled;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleGroupCallIsMyVideoEnabled"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x60d0af06


# instance fields
.field public groupCallId:I

.field public isMyVideoEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33268
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33269
    return-void
.end method

.method public constructor <init>(IZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z

    .line 33258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33259
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallIsMyVideoEnabled;->groupCallId:I

    .line 33260
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallIsMyVideoEnabled;->isMyVideoEnabled:Z

    .line 33261
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33265
    const v0, -0x60d0af06

    return v0
.end method
