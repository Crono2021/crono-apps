.class public Lorg/drinkless/tdlib/TdApi$UpdateWebAppMessageSent;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateWebAppMessageSent"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x58431229


# instance fields
.field public webAppLaunchId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22250
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22251
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 22241
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22242
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateWebAppMessageSent;->webAppLaunchId:J

    .line 22243
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22247
    const v0, 0x58431229

    return v0
.end method
