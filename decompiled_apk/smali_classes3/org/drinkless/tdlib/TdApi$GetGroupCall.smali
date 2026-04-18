.class public Lorg/drinkless/tdlib/TdApi$GetGroupCall;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetGroupCall"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GroupCall;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5787668e


# instance fields
.field public groupCallId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12912
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12913
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 12903
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12904
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetGroupCall;->groupCallId:I

    .line 12905
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12909
    const v0, 0x5787668e

    return v0
.end method
