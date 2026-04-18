.class public Lorg/drinkless/tdlib/TdApi$EnableProxy;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EnableProxy"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x59138296


# instance fields
.field public proxyId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11832
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11833
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 11823
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11824
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$EnableProxy;->proxyId:I

    .line 11825
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11829
    const v0, 0x59138296

    return v0
.end method
