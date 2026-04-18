.class public Lorg/drinkless/tdlib/TdApi$SetNetworkType;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetNetworkType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x29d21aa2


# instance fields
.field public type:Lorg/drinkless/tdlib/TdApi$NetworkType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19824
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19825
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$NetworkType;)V
    .locals 0
    .param p1, "networkType"    # Lorg/drinkless/tdlib/TdApi$NetworkType;

    .line 19815
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19816
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetNetworkType;->type:Lorg/drinkless/tdlib/TdApi$NetworkType;

    .line 19817
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19821
    const v0, -0x29d21aa2

    return v0
.end method
