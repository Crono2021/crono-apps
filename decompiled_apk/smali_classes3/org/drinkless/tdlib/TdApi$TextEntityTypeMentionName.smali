.class public Lorg/drinkless/tdlib/TdApi$TextEntityTypeMentionName;
.super Lorg/drinkless/tdlib/TdApi$TextEntityType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TextEntityTypeMentionName"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5da32a51


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21260
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TextEntityType;-><init>()V

    .line 21261
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 21251
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TextEntityType;-><init>()V

    .line 21252
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TextEntityTypeMentionName;->userId:J

    .line 21253
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21257
    const v0, -0x5da32a51

    return v0
.end method
