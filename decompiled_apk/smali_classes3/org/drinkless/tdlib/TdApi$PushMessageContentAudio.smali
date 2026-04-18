.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentAudio;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentAudio"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x16be7872


# instance fields
.field public audio:Lorg/drinkless/tdlib/TdApi$Audio;

.field public isPinned:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29448
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29449
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Audio;Z)V
    .locals 0
    .param p1, "audio"    # Lorg/drinkless/tdlib/TdApi$Audio;
    .param p2, "z8"    # Z

    .line 29438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29439
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentAudio;->audio:Lorg/drinkless/tdlib/TdApi$Audio;

    .line 29440
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentAudio;->isPinned:Z

    .line 29441
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29445
    const v0, 0x16be7872

    return v0
.end method
