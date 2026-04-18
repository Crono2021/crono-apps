.class public Lorg/drinkless/tdlib/TdApi$TextEntityTypeMediaTimestamp;
.super Lorg/drinkless/tdlib/TdApi$TextEntityType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TextEntityTypeMediaTimestamp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6dc925f0


# instance fields
.field public mediaTimestamp:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21242
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TextEntityType;-><init>()V

    .line 21243
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 21233
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TextEntityType;-><init>()V

    .line 21234
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$TextEntityTypeMediaTimestamp;->mediaTimestamp:I

    .line 21235
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21239
    const v0, -0x6dc925f0

    return v0
.end method
