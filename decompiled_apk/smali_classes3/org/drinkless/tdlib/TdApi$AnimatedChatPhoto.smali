.class public Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AnimatedChatPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xb719c2e


# instance fields
.field public file:Lorg/drinkless/tdlib/TdApi$File;

.field public length:I

.field public mainFrameTimestamp:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35640
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35641
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$File;D)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "file"    # Lorg/drinkless/tdlib/TdApi$File;
    .param p3, "d9"    # D

    .line 35629
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35630
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;->length:I

    .line 35631
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;->file:Lorg/drinkless/tdlib/TdApi$File;

    .line 35632
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;->mainFrameTimestamp:D

    .line 35633
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35637
    const v0, 0xb719c2e

    return v0
.end method
