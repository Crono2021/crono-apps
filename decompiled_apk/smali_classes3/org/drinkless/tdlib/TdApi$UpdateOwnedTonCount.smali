.class public Lorg/drinkless/tdlib/TdApi$UpdateOwnedTonCount;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateOwnedTonCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x41b14419


# instance fields
.field public tonAmount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21926
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21927
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 21917
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21918
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateOwnedTonCount;->tonAmount:J

    .line 21919
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21923
    const v0, -0x41b14419

    return v0
.end method
