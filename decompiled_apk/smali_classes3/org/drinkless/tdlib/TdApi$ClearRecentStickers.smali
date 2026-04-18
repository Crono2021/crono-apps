.class public Lorg/drinkless/tdlib/TdApi$ClearRecentStickers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ClearRecentStickers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1325c63c


# instance fields
.field public isAttached:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10806
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10807
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 10797
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10798
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ClearRecentStickers;->isAttached:Z

    .line 10799
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10803
    const v0, -0x1325c63c

    return v0
.end method
