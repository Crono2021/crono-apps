.class public Lorg/drinkless/tdlib/TdApi$InputChatPhotoPrevious;
.super Lorg/drinkless/tdlib/TdApi$InputChatPhoto;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputChatPhotoPrevious"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x160e9d1


# instance fields
.field public chatPhotoId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14478
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputChatPhoto;-><init>()V

    .line 14479
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 14469
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputChatPhoto;-><init>()V

    .line 14470
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InputChatPhotoPrevious;->chatPhotoId:J

    .line 14471
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14475
    const v0, 0x160e9d1

    return v0
.end method
