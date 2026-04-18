.class public Lorg/drinkless/tdlib/TdApi$ClearSearchedForTags;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ClearSearchedForTags"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1e84c356


# instance fields
.field public clearCashtags:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10824
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10825
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 10815
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10816
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ClearSearchedForTags;->clearCashtags:Z

    .line 10817
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10821
    const v0, 0x1e84c356

    return v0
.end method
