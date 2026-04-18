.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentProximityAlertTriggered;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentProximityAlertTriggered"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xfc57ffa


# instance fields
.field public distance:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18205
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 18195
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18196
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentProximityAlertTriggered;->distance:I

    .line 18197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18201
    const v0, -0xfc57ffa

    return v0
.end method
