.class public Lorg/drinkless/tdlib/TdApi$CloseWebApp;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CloseWebApp"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x68a124c6


# instance fields
.field public webAppLaunchId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10896
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10897
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 10887
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10888
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CloseWebApp;->webAppLaunchId:J

    .line 10889
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10893
    const v0, 0x68a124c6

    return v0
.end method
