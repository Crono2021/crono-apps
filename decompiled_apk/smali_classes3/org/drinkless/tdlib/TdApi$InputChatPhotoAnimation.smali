.class public Lorg/drinkless/tdlib/TdApi$InputChatPhotoAnimation;
.super Lorg/drinkless/tdlib/TdApi$InputChatPhoto;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputChatPhotoAnimation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x56a3422


# instance fields
.field public animation:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public mainFrameTimestamp:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputChatPhoto;-><init>()V

    .line 27225
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;D)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "d9"    # D

    .line 27214
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputChatPhoto;-><init>()V

    .line 27215
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputChatPhotoAnimation;->animation:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 27216
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$InputChatPhotoAnimation;->mainFrameTimestamp:D

    .line 27217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27221
    const v0, 0x56a3422

    return v0
.end method
