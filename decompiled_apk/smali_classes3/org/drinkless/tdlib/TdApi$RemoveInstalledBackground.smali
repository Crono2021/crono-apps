.class public Lorg/drinkless/tdlib/TdApi$RemoveInstalledBackground;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveInstalledBackground"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5041253c


# instance fields
.field public backgroundId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18492
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18493
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 18483
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18484
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveInstalledBackground;->backgroundId:J

    .line 18485
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18489
    const v0, 0x5041253c

    return v0
.end method
