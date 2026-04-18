.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentVideo;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x127ad12f


# instance fields
.field public caption:Ljava/lang/String;

.field public isPinned:Z

.field public isSecret:Z

.field public video:Lorg/drinkless/tdlib/TdApi$Video;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44766
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 44767
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Video;Ljava/lang/String;ZZ)V
    .locals 0
    .param p1, "video"    # Lorg/drinkless/tdlib/TdApi$Video;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 44754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 44755
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentVideo;->video:Lorg/drinkless/tdlib/TdApi$Video;

    .line 44756
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentVideo;->caption:Ljava/lang/String;

    .line 44757
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentVideo;->isSecret:Z

    .line 44758
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentVideo;->isPinned:Z

    .line 44759
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44763
    const v0, 0x127ad12f

    return v0
.end method
