.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeVideoChat;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeVideoChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x119fa9c2


# instance fields
.field public isLiveStream:Z

.field public joinsAsSpeaker:Z

.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38370
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 38371
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;ZZ)V
    .locals 0
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z

    .line 38359
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 38360
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeVideoChat;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 38361
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeVideoChat;->isLiveStream:Z

    .line 38362
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeVideoChat;->joinsAsSpeaker:Z

    .line 38363
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38367
    const v0, -0x119fa9c2

    return v0
.end method
