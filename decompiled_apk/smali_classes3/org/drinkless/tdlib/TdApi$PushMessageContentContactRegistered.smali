.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentContactRegistered;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentContactRegistered"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4989f721


# instance fields
.field public asPremiumAccount:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18114
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18115
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 18105
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18106
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentContactRegistered;->asPremiumAccount:Z

    .line 18107
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18111
    const v0, 0x4989f721

    return v0
.end method
