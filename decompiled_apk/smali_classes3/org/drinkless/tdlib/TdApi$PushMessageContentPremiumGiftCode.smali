.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentPremiumGiftCode;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentPremiumGiftCode"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x18a15025


# instance fields
.field public monthCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18186
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18187
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 18177
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18178
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentPremiumGiftCode;->monthCount:I

    .line 18179
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18183
    const v0, 0x18a15025

    return v0
.end method
